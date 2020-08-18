/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.dao;

import com.spring.mvc.registraduria.model.entity.TablaCiudad;
import org.springframework.data.repository.CrudRepository;



/**
 * @author User
 *
 */
public interface ICiudadDao extends CrudRepository<TablaCiudad, String> {

}
