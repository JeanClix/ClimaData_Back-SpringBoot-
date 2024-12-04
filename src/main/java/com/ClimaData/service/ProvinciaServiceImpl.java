package com.ClimaData.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClimaData.model.dao.IProvinciaDao;
import com.ClimaData.model.entity.Provincia;

@Service
public class ProvinciaServiceImpl implements IProvinciaService {

	@Autowired
	private IProvinciaDao provinciaDao;

	@Override
	public List<Provincia> getAllProvincias() {
		return (List<Provincia>) provinciaDao.findAll();
	}

	@Override
	public Provincia getProvinciaById(Long id) {
		Optional<Provincia> provincia = provinciaDao.findById(id);
		return provincia.orElse(null);
	}

	@Override
	public Provincia createProvincia(Provincia provincia) {
		return provinciaDao.save(provincia);
	}

	@Override
	public Provincia updateProvincia(Long id, Provincia provinciaDetails) {
		Optional<Provincia> optionalProvincia = provinciaDao.findById(id);

		if (optionalProvincia.isPresent()) {
			Provincia provincia = optionalProvincia.get();
			provincia.setNombreProvincia(provinciaDetails.getNombreProvincia());
			provincia.setDepartamento(provinciaDetails.getDepartamento());

			return provinciaDao.save(provincia);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteProvincia(Long id) {
		if (provinciaDao.existsById(id)) {
			provinciaDao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}