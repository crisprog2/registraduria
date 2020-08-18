/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import java.util.List;

import com.spring.mvc.registraduria.model.entity.TablaLugarVoto;
import com.spring.mvc.registraduria.model.entity.dao.ILugarVotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author User
 *
 */
@Service
public class LugarVotoImpl implements ILugarVotoService {
	
	@Autowired
	private ILugarVotoDao lugarDao;

	@Override
	public List<TablaLugarVoto> findAll() {
		// TODO Auto-generated method stub
		return (List<TablaLugarVoto>) lugarDao.findAll();
	}

	@Override
	public void save(TablaLugarVoto lugar) {
		// TODO Auto-generated method stub
		lugarDao.save(lugar);
	}

	@Override
	public TablaLugarVoto findOne(String codLugar) {
		// TODO Auto-generated method stub
		return lugarDao.findById(codLugar).orElse(null);
	}

	@Override
	public void delete(String codLugar) {
		// TODO Auto-generated method stub
		lugarDao.deleteById(codLugar);
	}

}
