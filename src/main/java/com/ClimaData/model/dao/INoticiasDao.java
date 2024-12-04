package com.ClimaData.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.ClimaData.model.entity.Noticia;

public interface INoticiasDao extends CrudRepository<Noticia,Long>{

}
