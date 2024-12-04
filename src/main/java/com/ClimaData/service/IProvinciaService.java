package com.ClimaData.service;

import java.util.List;

import com.ClimaData.model.entity.Provincia;

public interface IProvinciaService {
    List<Provincia> getAllProvincias();
    Provincia getProvinciaById(Long id);
    Provincia createProvincia(Provincia provincia);
    Provincia updateProvincia(Long id, Provincia provinciaDetails);
    boolean deleteProvincia(Long id);
}