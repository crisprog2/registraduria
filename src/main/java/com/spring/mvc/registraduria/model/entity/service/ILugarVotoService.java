/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import com.spring.mvc.registraduria.model.entity.TablaLugarVoto;

import java.util.List;



/**
 * @author User
 *
 */
public interface ILugarVotoService {
	
	public List<TablaLugarVoto> findAll();

	public void save(TablaLugarVoto lugar);

	public TablaLugarVoto findOne(String codLugar);

	public void delete(String codLugar);

}
