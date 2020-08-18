/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import com.spring.mvc.registraduria.model.entity.TablaCiudad;

import java.util.List;



/**
 * @author User
 *
 */
public interface ICiudadService {
	
	public List<TablaCiudad> findAll();

	public void save(TablaCiudad ciudad);

	public TablaCiudad findOne(String codCiudad);

	public void delete(String codCiudad);
	
}
