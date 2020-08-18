/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.dao;

import com.spring.mvc.registraduria.model.entity.TablaRegistro;
import org.springframework.data.repository.CrudRepository;


/**
 * @author User
 *
 */
public interface IRegistroDao extends CrudRepository<TablaRegistro, Long> {

}
