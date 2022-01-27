/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import java.util.List;

import com.spring.mvc.registraduria.model.entity.TablaCiudad;
import com.spring.mvc.registraduria.model.entity.dao.ICiudadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author User
 *
 */
@Service
public class CiudadServiceImpl implements ICiudadService {
	
	@Autowired
	ICiudadDao ciudadDao;

	@Override
	public List<TablaCiudad> findAll() {
		return (List<TablaCiudad>) ciudadDao.findAll();
	}

	@Override
	public void save(TablaCiudad ciudad) {
		ciudadDao.save(ciudad);
	}

	@Override
	public TablaCiudad findOne(String codCiudad) {
		return ciudadDao.findById(codCiudad).orElse(null);
	}

	@Override
	public void delete(String codCiudad) {
		ciudadDao.deleteById(codCiudad);
	}

}
