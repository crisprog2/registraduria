package com.spring.mvc.registraduria.controllers;

import com.spring.mvc.registraduria.model.entity.*;
import com.spring.mvc.registraduria.model.entity.dto.ConsultaDto;
import com.spring.mvc.registraduria.model.entity.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Christian Chacon
 */
@RestController
@RequestMapping("/api")
public class HomeRestController {

    @Autowired
    private IPersonaService personaService;

    /**
     *
     * @return ConsultaDto
     */
    @GetMapping("/consulta/{id}")
    public ConsultaDto index(@PathVariable int id) {
        ConsultaDto consultaDto=new ConsultaDto();
        TablaPersona persona=personaService.findOne(id);
        if(persona==null){
            consultaDto=null;
            return consultaDto;
        }else{
            TablaMesa tablaMesa=persona.getCod_Mesa();
            TablaLugarVoto tablaLugarVoto=tablaMesa.getCod_lugar();
            TablaCiudad tablaCiudad=tablaLugarVoto.getCod_Ciudad();
            TablaDepartamento tablaDepartamento=tablaCiudad.getCod_Departamento();
            consultaDto.setPrimerNombre(persona.getPrimerNombre());
            consultaDto.setSegundoNombre(persona.getSegundoNombre());
            consultaDto.setPrimerApellido(persona.getPrimerApellido());
            consultaDto.setSegundoApellido(persona.getSegundoApellido());
            consultaDto.setCedulaVotante(persona.getCedula());
            consultaDto.setEdadVotante(persona.getEdad());
            if (persona.getJurado().equals("Y")){
                consultaDto.setJurado("Es jurado");
            }else{
                persona.getJurado().equals("No es Jurado");
            }
            consultaDto.setMesaVoto(tablaMesa.getMesa());
            consultaDto.setDireccionVoto(tablaLugarVoto.getDireccionVoto());
            consultaDto.setCiudadVoto(tablaCiudad.getCiudad());
            consultaDto.setDepartamentoVoto(tablaDepartamento.getDepartamento());
            return consultaDto;
        }
    }

}
