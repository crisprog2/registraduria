package com.spring.mvc.registraduria.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.mvc.registraduria.model.entity.*;
import com.spring.mvc.registraduria.model.entity.dto.ConsultaDto;
import com.spring.mvc.registraduria.model.entity.dto.responseGoogleMapsGeocode.Geocode;
import com.spring.mvc.registraduria.model.entity.dto.responseGoogleMapsGeocode.Result;
import com.spring.mvc.registraduria.model.entity.service.IPersonaService;
import com.spring.mvc.registraduria.model.entity.service.IRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author Christian Chacon
 */
@Controller
@SessionAttributes("consulta")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IRegistroService registroService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value= {"","/","/index"})
    public String index(Model model) {
        ConsultaDto consultaDto=new ConsultaDto();
        model.addAttribute("consulta", consultaDto);
        return "home/index";
    }

    @PostMapping(value = "/index")
    public String consulta(Model model, @RequestParam(name = "cedula") int cedula) throws JsonProcessingException {
        ConsultaDto consultaDto=new ConsultaDto();
        TablaPersona persona=personaService.findOne(cedula);
        if(persona==null){
            return "redirect:/home/index";
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
            consultaDto.setLugarVoto(tablaLugarVoto.getNombreLugar());
            consultaDto.setCiudadVoto(tablaCiudad.getCiudad());
            consultaDto.setDepartamentoVoto(tablaDepartamento.getDepartamento());
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl = "https://maps.googleapis.com/maps/api/geocode/json?address="+tablaLugarVoto.getNombreLugar()+", "+consultaDto.getCiudadVoto()+"&key=AIzaSyBP9BzaVQMLVAX5HaJOcOvYVkeoTMmv0CQ";
            Geocode geocode=restTemplate.getForObject(fooResourceUrl, Geocode.class);
            Result result=geocode.getResults().get(0);
            consultaDto.setLat(result.getGeometry().getViewport().getNortheast().getLat());
            consultaDto.setLng(result.getGeometry().getViewport().getNortheast().getLng());
            TablaRegistro registro= persona.getRegistro();
            registro.setRegistro(registro.getRegistro()+1);
            registroService.save(registro);
            model.addAttribute("consulta", consultaDto);
            return "redirect:/home/ver";
        }
    }

    @GetMapping(value="/ver")
    public String ver(@SessionAttribute(name="consulta", required = false) ConsultaDto consultaDto, Model model, SessionStatus status) {
        if(consultaDto==null) {
            return "redirect:/home/index";
        }
        status.setComplete();
        return "home/index";
    }

}
