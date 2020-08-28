package com.spring.mvc.registraduria.controllers;

import com.spring.mvc.registraduria.model.entity.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.*;

/**
 * @author User
 */
@Controller
@RequestMapping("/reports")
public class ReporteRegistrosCiudad {

    @Autowired
    private IPersonaService personaService;

    @GetMapping(value="/ciudad")
    public String ciudad(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        for (Object[] objeto:personaService.obtenerPersonas()) {
            graphData.put(objeto[0].toString(), Integer.parseInt(objeto[1].toString()));
        }
        model.addAttribute("chartData", graphData);
        return "reports/ciudad";
    }

}
