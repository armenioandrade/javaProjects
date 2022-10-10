package com.springsystem.web.controller;

import com.springsystem.domain.Cargo;
import com.springsystem.domain.Departamento;
import com.springsystem.service.CargoService;
import com.springsystem.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "/cargo/cadastro";
    }
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr){
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
        return "redirect:/cargos/cadastrar";
    }
    /*Método reponsável por enviar uma lista de departamentos para a página*/
    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.buscarTodos();
    }
        @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, Model model){
        model.addAttribute("cargo", cargoService.buscarPorId(id));
        model.addAttribute("success", "Registro atualizado com sucesso.");
        return "/cargo/cadastro";
    }
    @PostMapping("/editar")
    public String editar(Cargo cargo){
        cargoService.editar(cargo);
        return "redirect:/cargos/listar";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id")Long id, RedirectAttributes attr){
        if(cargoService.cargoTemFuncionarios(id)){
            attr.addFlashAttribute("fail", "Cargo tem funcionário(s) vinculado(s).");
        }else{
            cargoService.excluir(id);
            attr.addFlashAttribute("success", "Cargo excluído com sucesso.");
        }
        return "redirect:/cargos/listar";
    }

}
