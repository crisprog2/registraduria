/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.dao;

import com.spring.mvc.registraduria.model.entity.TablaMesa;
import org.springframework.data.repository.CrudRepository;


/**
 * @author User
 *
 */
public interface IMesaDao extends CrudRepository<TablaMesa, Long> {

}
