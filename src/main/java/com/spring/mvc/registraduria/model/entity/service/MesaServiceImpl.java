/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.service;

import java.util.List;

import com.spring.mvc.registraduria.model.entity.TablaMesa;
import com.spring.mvc.registraduria.model.entity.dao.IMesaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author User
 *
 */
@Service
public class MesaServiceImpl implements IMesaService {
	
	@Autowired
	private IMesaDao mesaDao;

	@Override
	public List<TablaMesa> findAll() {
		// TODO Auto-generated method stub
		return (List<TablaMesa>) mesaDao.findAll();
	}

	@Override
	public void save(TablaMesa mesa) {
		// TODO Auto-generated method stub
		mesaDao.save(mesa);
	}

	@Override
	public TablaMesa findOne(Long codMesa) {
		// TODO Auto-generated method stub
		return mesaDao.findById(codMesa).orElse(null);
	}

	@Override
	public void delete(Long codMesa) {
		// TODO Auto-generated method stub
		mesaDao.deleteById(codMesa);
	}

}
