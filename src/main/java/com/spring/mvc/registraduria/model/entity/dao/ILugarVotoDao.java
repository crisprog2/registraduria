/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.dao;

import com.spring.mvc.registraduria.model.entity.TablaLugarVoto;
import org.springframework.data.repository.CrudRepository;


/**
 * @author User
 *
 */
public interface ILugarVotoDao extends CrudRepository<TablaLugarVoto, String> {

}
