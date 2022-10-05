package com.springsystem.web.controller;

import com.springsystem.domain.Departamento;
import com.springsystem.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Departamento departamento) { //Envia uma instancia de departamento para a pagina cadastro ao acessar a URI /cadastrar
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("departamentos", service.buscarTodos());
        return "/departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento) {
        service.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }
    
    @GetMapping("/editar/{id}")
    public String preEditar(){
        return null;
    }
}
