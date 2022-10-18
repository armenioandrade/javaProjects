package com.springsystem.web.controller;
import com.springsystem.domain.Cargo;
import com.springsystem.domain.Funcionario;
import com.springsystem.domain.UF;
import com.springsystem.service.CargoService;
import com.springsystem.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;
    @Autowired
    CargoService cargoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario){
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        return "/funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "/funcionario/cadastro";
        }
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionário inserido com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos(){
        return cargoService.buscarTodos();
    }

    @ModelAttribute("uf")
    public UF[] getUFs(){
            return UF.values();
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, Model model){
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        model.addAttribute("success", "Registro atualizado com sucesso.");
        return "funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Funcionario funcionario,BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "/funcionario/cadastro";
        }
        funcionarioService.editar(funcionario);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id")Long id, RedirectAttributes attr){
        funcionarioService.excluir(id);
        return "redirect:/funcionarios/listar";
    }
    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, Model model){
        model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
        return "funcionario/lista";
    }
    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, Model model){
        model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
        return "funcionario/lista";
    }
    @GetMapping("buscar/data")
    public String getPorDatas(@RequestParam(value = "entrada", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              Model model){
        model.addAttribute("funcionarios", funcionarioService.buscarPorDatas(entrada,saida));
        return "/funcionario/lista";
    }
}
