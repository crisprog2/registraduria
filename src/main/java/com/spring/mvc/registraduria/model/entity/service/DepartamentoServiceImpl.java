/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import java.util.List;

import com.spring.mvc.registraduria.model.entity.TablaDepartamento;
import com.spring.mvc.registraduria.model.entity.dao.IDepartamentoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author User
 *
 */
@Service
public class DepartamentoServiceImpl implements IDepartamentoService {
	
	@Autowired
	private IDepartamentoDao departamentoDao;
	
	@Override
	public List<TablaDepartamento> findAll() {
		// TODO Auto-generated method stub
		return (List<TablaDepartamento>) departamentoDao.findAll();
	}

	@Override
	public void save(TablaDepartamento departamento) {
		// TODO Auto-generated method stub
		departamentoDao.save(departamento);
	}

	@Override
	public TablaDepartamento findOne(String codDepartamento) {
		// TODO Auto-generated method stub
		return departamentoDao.findById(codDepartamento).orElse(null);
	}

	@Override
	public void delete(String codDepartamento) {
		// TODO Auto-generated method stub
		departamentoDao.deleteById(codDepartamento);
	}
	
}
