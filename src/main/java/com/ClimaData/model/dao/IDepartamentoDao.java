package com.ClimaData.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.ClimaData.model.entity.Departamento;

public interface IDepartamentoDao extends CrudRepository<Departamento, Long> {

	Departamento findByNombre(String nombre);
}
