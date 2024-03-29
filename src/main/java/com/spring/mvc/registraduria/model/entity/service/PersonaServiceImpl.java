/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import java.util.List;

import com.spring.mvc.registraduria.model.entity.TablaPersona;
import com.spring.mvc.registraduria.model.entity.dao.IPersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author User
 *
 */
@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaDao personaDao;

	@Override
	public List<TablaPersona> findAll() {
		return (List<TablaPersona>) personaDao.findAll();
	}

	@Override
	public void save(TablaPersona persona) {
		personaDao.save(persona);
	}

	@Override
	public TablaPersona findOne(Integer cedula) {
		return personaDao.findById(cedula).orElse(null);
	}

	@Override
	public void delete(Integer cedula) {
		personaDao.deleteById(cedula);
	}

	@Override
	public List<Object[]> obtenerPersonas() {
		return personaDao.obtenerPersonas();
	}

}
