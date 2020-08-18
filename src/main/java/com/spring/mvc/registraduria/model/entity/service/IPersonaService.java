/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import com.spring.mvc.registraduria.model.entity.TablaPersona;

import java.util.List;


/**
 * @author User
 *
 */
public interface IPersonaService {
	
	public List<TablaPersona> findAll();

	public void save(TablaPersona persona);

	public TablaPersona findOne(Integer cedula);

	public void delete(Integer cedula);
	
}
