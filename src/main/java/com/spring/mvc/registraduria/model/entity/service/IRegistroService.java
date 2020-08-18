/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import com.spring.mvc.registraduria.model.entity.TablaRegistro;

import java.util.List;



/**
 * @author User
 *
 */
public interface IRegistroService {
	
	public List<TablaRegistro> findAll();

	public void save(TablaRegistro registro);

	public TablaRegistro findOne(Long codRegistro);

	public void delete(Long codRegistro);

}
