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
		// TODO Auto-generated method stub
		return (List<TablaCiudad>) ciudadDao.findAll();
	}

	@Override
	public void save(TablaCiudad ciudad) {
		// TODO Auto-generated method stub
		ciudadDao.save(ciudad);
	}

	@Override
	public TablaCiudad findOne(String codCiudad) {
		// TODO Auto-generated method stub
		return ciudadDao.findById(codCiudad).orElse(null);
	}

	@Override
	public void delete(String codCiudad) {
		// TODO Auto-generated method stub
		ciudadDao.deleteById(codCiudad);
	}

}
