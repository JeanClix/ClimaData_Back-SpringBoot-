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

import com.ClimaData.model.entity.Noticia;
import com.ClimaData.service.INoticiaService;

@RestController
@RequestMapping("/api/noticias")
@CrossOrigin(origins = "http://localhost:4200")
public class NoticiaController {
    @Autowired
    private INoticiaService noticiaService;

    @GetMapping
    public ResponseEntity<List<Noticia>> consultarNoticias() {
        List<Noticia> listaNoticias = noticiaService.getAllNoticias();
        return ResponseEntity.ok(listaNoticias);
    }

    @PostMapping
    public ResponseEntity<Noticia> guardarNoticia(@RequestBody Noticia noticia) {
        Noticia noticiaGuardada = noticiaService.saveNoticia(noticia);
        return ResponseEntity.ok(noticiaGuardada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> buscarNoticia(@PathVariable Long id) {
        Noticia noticiaConsultada = noticiaService.getNoticiaById(id);
        if (noticiaConsultada != null) {
            return ResponseEntity.ok(noticiaConsultada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> editarNoticia(@RequestBody Noticia noticia, @PathVariable Long id) {
        Noticia noticiaExistente = noticiaService.getNoticiaById(id);
        if (noticiaExistente != null) {
            noticia.setId(id); 
            Noticia noticiaAct= noticiaService.saveNoticia(noticia);
            return ResponseEntity.ok(noticiaAct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNoticia(@PathVariable Long id) {
        Noticia noticiaExistente = noticiaService.getNoticiaById(id);
        if (noticiaExistente != null) {
            noticiaService.deleteNoticia(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
