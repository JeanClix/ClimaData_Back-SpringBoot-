package com.ClimaData.service;

import java.util.List;

import com.ClimaData.model.entity.Noticia;

public interface INoticiaService {
    List<Noticia> getAllNoticias();
    Noticia getNoticiaById(Long id);
    Noticia saveNoticia(Noticia noticia);
    void deleteNoticia(Long id);
}
