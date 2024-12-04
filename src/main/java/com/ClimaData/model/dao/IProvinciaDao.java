package com.ClimaData.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ClimaData.model.entity.Departamento;
import com.ClimaData.model.entity.Provincia;

public interface IProvinciaDao extends CrudRepository<Provincia,Long>{

    List<Provincia> findByDepartamento(Departamento departamento);
}