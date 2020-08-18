/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import java.util.List;

import com.spring.mvc.registraduria.model.entity.TablaRegistro;
import com.spring.mvc.registraduria.model.entity.dao.IRegistroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author User
 *
 */
@Service
public class RegistroServiceImpl implements IRegistroService {
	
	@Autowired
	private IRegistroDao registroDao;

	@Override
	public List<TablaRegistro> findAll() {
		// TODO Auto-generated method stub
		return (List<TablaRegistro>) registroDao.findAll();
	}

	@Override
	public void save(TablaRegistro registro) {
		// TODO Auto-generated method stub
		registroDao.save(registro);
	}

	@Override
	public TablaRegistro findOne(Long codRegistro) {
		// TODO Auto-generated method stub
		return registroDao.findById(codRegistro).orElse(null);
	}

	@Override
	public void delete(Long codRegistro) {
		// TODO Auto-generated method stub
		registroDao.deleteById(codRegistro);
	}

}
