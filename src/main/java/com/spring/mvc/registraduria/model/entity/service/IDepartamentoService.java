/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import com.spring.mvc.registraduria.model.entity.TablaDepartamento;

import java.util.List;


/**
 * @author User
 *
 */
public interface IDepartamentoService {

	public List<TablaDepartamento> findAll();

	public void save(TablaDepartamento departamento);

	public TablaDepartamento findOne(String codDepartamento);

	public void delete(String codDepartamento);

}
