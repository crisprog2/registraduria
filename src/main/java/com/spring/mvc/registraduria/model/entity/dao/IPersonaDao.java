/**
 * 
 */
package com.spring.mvc.registraduria.model.entity.dao;

import com.spring.mvc.registraduria.model.entity.TablaPersona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * @author User
 *
 */
public interface IPersonaDao extends CrudRepository<TablaPersona, Integer> {

    @Query(value = "select tabla_ciudad.ciudad, sum(tabla_registro.registro) as consultas_diarias from registraduriatest.tabla_persona, registraduriatest.tabla_registro, registraduriatest.tabla_ciudad, registraduriatest.tabla_mesa, registraduriatest.tabla_lugar where tabla_registro.cedula=tabla_persona.cedula AND tabla_persona.cod_mesa=tabla_mesa.cod_mesa AND tabla_mesa.cod_lugar=tabla_lugar.cod_lugar AND tabla_lugar.cod_ciudad=tabla_ciudad.cod_ciudad group by tabla_ciudad.ciudad", nativeQuery = true)
    List<Object[]> obtenerPersonas();

}
