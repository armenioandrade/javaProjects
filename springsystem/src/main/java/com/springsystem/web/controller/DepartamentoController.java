package com.springsystem.web.controller;

import com.springsystem.domain.Departamento;
import com.springsystem.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String salvar(Departamento departamento, RedirectAttributes attr) {
        service.salvar(departamento);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }
    
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, Model model){
        model.addAttribute("departamento", service.buscarPorId(id));
        model.addAttribute("success", "Registro atualizado com sucesso.");
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Departamento departamento){
        service.editar(departamento);
        return "redirect:/departamentos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id")Long id, Model model){
    if(!service.departamentoTemCargos(id)){
        service.excluir(id);
    }
    return listar(model);
    }
}
