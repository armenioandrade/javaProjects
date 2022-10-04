
package com.springdoctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.persistence.*;
import javax.print.Doc;


@Controller
@RequestMapping(path="/Doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping(path = "")
    public String index(Model model){
        System.out.println("chegou no index sem barra");
        model.addAttribute("lista", doctorRepository.findAll());
        return "index";
    }

    @GetMapping(path = "/")
    public String indexBarra(Model model){
        System.out.println("chegou no index sem barra");
        model.addAttribute("lista", doctorRepository.findAll());
        return "index";
    }

    @GetMapping(path = "/addDoctor")
    public String addDoctorForm(Model model){
        System.out.println("chegou no getmapping adddoctor");
        model.addAttribute("doctor", new Doctor());
        return "cadastro";
    }

    @PostMapping(path = "/addDoctor")
    public String addDoctorSubmit(@ModelAttribute Doctor doctor, Model model, RedirectAttributes redirectAttributes){
        System.out.println("chegou no postmapping adddoctor");
        doctorRepository.save(doctor);
        redirectAttributes.addFlashAttribute("mensagem", "usuario cadastrado!");
        return "redirect:/Doctor/";
    }

    @GetMapping(path = "/DeleteDoctor")
    public String deleteDoctor(@RequestParam int doctorId){
        System.out.println("chegou no metodo deletar");
        System.out.println("id "+doctorId);
        doctorRepository.deleteById(doctorId);
        return "redirect:/Doctor/";
    }

    @Entity
    @Table(name = "Doctor")
    public static class Doctor {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;
        private String name;
        private String cpf;
        private String crm;

        public Doctor(){

        }

        @Override
        public String toString() {
            return "Doctor{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", crm='" + crm + '\'' +
                    '}';
        }

        public Doctor(Integer id, String name, String cpf, String crm) {
            this.id = id;
            this.name = name;
            this.cpf = cpf;
            this.crm = crm;
        }

        public String getCrm() {
            return crm;
        }

        public void setCrm(String crm) {
            this.crm = crm;
        }

        public void setId(Integer id) {
            this.id = id;
        }


        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }


    }
}
