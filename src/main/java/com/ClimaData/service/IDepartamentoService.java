package com.ClimaData.service;

import java.util.List;

import com.ClimaData.model.entity.Departamento;

public interface IDepartamentoService {
    List<Departamento> getAllDepartamentos();
    Departamento getDepartamentoById(Long id);
    Departamento getDepartamentoByName(String nombre);
    Departamento createDepartamento(Departamento departamento);
    Departamento updateDepartamento(Long id, Departamento departamentoDetails);
    boolean deleteDepartamento(Long id);
}