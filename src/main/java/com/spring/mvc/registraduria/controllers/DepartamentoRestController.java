package com.spring.mvc.registraduria.controllers;

import com.spring.mvc.registraduria.model.entity.TablaDepartamento;
import com.spring.mvc.registraduria.model.entity.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Christian Chacon
 */
@RestController
@RequestMapping("/api")
public class DepartamentoRestController {
    @Autowired
    private IDepartamentoService departamentoService;

    /**
     *
     * @return List<TablaDepartamento>
     */
    @GetMapping("/departamentos")
    public List<TablaDepartamento> index() {
        return departamentoService.findAll();
    }
}
