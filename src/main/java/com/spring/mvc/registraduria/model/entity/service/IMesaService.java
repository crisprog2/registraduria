/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import com.spring.mvc.registraduria.model.entity.TablaMesa;

import java.util.List;



/**
 * @author User
 *
 */
public interface IMesaService {
	
	public List<TablaMesa> findAll();

	public void save(TablaMesa mesa);

	public TablaMesa findOne(Long codMesa);

	public void delete(Long codMesa);
	
}
