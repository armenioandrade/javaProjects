
package com.springdoctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Controller
@RequestMapping(path="/Doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping(path="/add")
    public @ResponseBody String addNewForm (@RequestParam String name, @RequestParam String cpf, @RequestParam String crm){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setCpf(cpf);
        doctor.setCrm(crm);
        doctorRepository.save(doctor);
        return "saved";
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewDoctor (@RequestParam String name, @RequestParam String cpf, @RequestParam String crm){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setCpf(cpf);
        doctor.setCrm(crm);
        doctorRepository.save(doctor);
       return "saved";
    }

    @GetMapping(path = "/addDoctor")
    public String addDoctorForm(Model model){
        System.out.println("chegou no getmapping adddoctor");
        model.addAttribute("doctor", new Doctor());
        return "cadastro";
    }

    @PostMapping(path = "/addDoctor")
    public String addDoctorSubmit(@ModelAttribute Doctor doctor, Model model){
        System.out.println("chegou no postmapping adddoctor");
        doctorRepository.save(doctor);
        return list(model, doctor);
    }

    @GetMapping(path = "/list")
    public String list(Model model, Doctor doctor){
        model.addAttribute("lista", doctorRepository.findAll());
        return "index";
    }

    @PostMapping(path = "/list")
    public String listPost(Model model, Doctor doctor){
        model.addAttribute("lista", doctorRepository.findAll());
        return "index";
    }

    @Entity
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
