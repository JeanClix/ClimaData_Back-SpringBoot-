package com.ClimaData.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClimaData.model.dao.IDepartamentoDao;
import com.ClimaData.model.entity.Departamento;

import java.util.List;
import java.util.Optional;
@Service
public class DepartamentoServiceImpl implements IDepartamentoService {

    @Autowired
    private IDepartamentoDao departamentoDao;

    @Override
    public List<Departamento> getAllDepartamentos() {
        return (List<Departamento>) departamentoDao.findAll();
    }

    @Override
    public Departamento getDepartamentoById(Long id) {
        Optional<Departamento> departamento = departamentoDao.findById(id);
        return departamento.orElse(null);
    }

    @Override
    public Departamento getDepartamentoByName(String nombre) {
        return departamentoDao.findByNombre(nombre);
    }

    @Override
    public Departamento createDepartamento(Departamento departamento) {
        return departamentoDao.save(departamento);
    }

    @Override
    public Departamento updateDepartamento(Long id, Departamento departamentoDetails) {
        Optional<Departamento> optionalDepartamento = departamentoDao.findById(id);

        if (optionalDepartamento.isPresent()) {
            Departamento departamento = optionalDepartamento.get();
            departamento.setNombre(departamentoDetails.getNombre());
            departamento.setExtensionKm2(departamentoDetails.getExtensionKm2());
            departamento.setPoblacion(departamentoDetails.getPoblacion());
            departamento.setFoto(departamentoDetails.getFoto());
            departamento.setAltitud(departamentoDetails.getAltitud());
            departamento.setDes(departamentoDetails.getDes());
            departamento.setProvincias(departamentoDetails.getProvincias());

            return departamentoDao.save(departamento);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteDepartamento(Long id) {
        if (departamentoDao.existsById(id)) {
            departamentoDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}