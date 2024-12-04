package com.ClimaData.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClimaData.model.dao.INoticiasDao;
import com.ClimaData.model.entity.Noticia;

@Service
public class NoticiaServiceImpl implements INoticiaService{
	
	@Autowired
    private INoticiasDao noticiaDao;

    @Override
    public List<Noticia> getAllNoticias() {
        return (List<Noticia>) noticiaDao.findAll();
    }

    @Override
    public Noticia getNoticiaById(Long id) {
        Optional<Noticia> optionalNoticia = noticiaDao.findById(id);
        return optionalNoticia.orElse(null);
    }

    @Override
    public Noticia saveNoticia(Noticia noticia) {
        return noticiaDao.save(noticia);
    }

    @Override
    public void deleteNoticia(Long id) {
        noticiaDao.deleteById(id);
    }
}
