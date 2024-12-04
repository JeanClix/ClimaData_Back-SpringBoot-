package com.ClimaData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClimaData.model.entity.Departamento;
import com.ClimaData.model.entity.Provincia;
import com.ClimaData.service.IDepartamentoService;
import com.ClimaData.service.IProvinciaService;

@RestController
@RequestMapping("/api/departamentos/{nombreDepartamento}/provincias")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciaController {

    @Autowired
    private IProvinciaService provinciaService;

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Provincia>> getAllProvincias(@PathVariable String nombreDepartamento) {
        Departamento departamento = departamentoService.getDepartamentoByName(nombreDepartamento);
        if (departamento != null) {
            return ResponseEntity.ok(departamento.getProvincias());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provincia> getProvinciaById(@PathVariable String nombreDepartamento, @PathVariable Long id) {
        Departamento departamento = departamentoService.getDepartamentoByName(nombreDepartamento);
        if (departamento != null) {
            Provincia provincia = provinciaService.getProvinciaById(id);
            if (provincia != null && provincia.getDepartamento().getIdDep().equals(departamento.getIdDep())) {
                return ResponseEntity.ok(provincia);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Provincia> createProvincia(@PathVariable String nombreDepartamento, @RequestBody Provincia provincia) {
        Departamento departamento = departamentoService.getDepartamentoByName(nombreDepartamento);
        if (departamento != null) {
            provincia.setDepartamento(departamento);
            return ResponseEntity.ok(provinciaService.createProvincia(provincia));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provincia> updateProvincia(@PathVariable String nombreDepartamento, @PathVariable Long id, @RequestBody Provincia provinciaDetails) {
        Departamento departamento = departamentoService.getDepartamentoByName(nombreDepartamento);
        if (departamento != null) {
            Provincia provincia = provinciaService.getProvinciaById(id);
            if (provincia != null && provincia.getDepartamento().getIdDep().equals(departamento.getIdDep())) {
                provinciaDetails.setCodProvincia(id);
                provinciaDetails.setDepartamento(departamento);
                return ResponseEntity.ok(provinciaService.updateProvincia(id, provinciaDetails));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvincia(@PathVariable String nombreDepartamento, @PathVariable Long id) {
        Departamento departamento = departamentoService.getDepartamentoByName(nombreDepartamento);
        if (departamento != null) {
            Provincia provincia = provinciaService.getProvinciaById(id);
            if (provincia != null && provincia.getDepartamento().getIdDep().equals(departamento.getIdDep())) {
                provinciaService.deleteProvincia(id);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}