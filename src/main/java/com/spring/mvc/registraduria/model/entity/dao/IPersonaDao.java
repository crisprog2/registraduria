/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.dao;

import com.spring.mvc.registraduria.model.entity.TablaPersona;
import org.springframework.data.repository.CrudRepository;


/**
 * @author User
 *
 */
public interface IPersonaDao extends CrudRepository<TablaPersona, Integer> {

}
