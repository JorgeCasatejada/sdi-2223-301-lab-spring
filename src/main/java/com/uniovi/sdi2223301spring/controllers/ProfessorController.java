package com.uniovi.sdi2223301spring.controllers;

import com.uniovi.sdi2223301spring.entities.Professor;
import com.uniovi.sdi2223301spring.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorsService professorsService;
    @RequestMapping("/professor/list")
    public String getList(){
        return professorsService.getProfessors().toString();
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor){
        professorsService.addProfessor(professor);
        return "Ok";
    }
    @RequestMapping(value = "/professor/details/{dni}")
    public String getDetail(@PathVariable String dni){
        return professorsService.getProfessor(dni).toString();
    }
    @RequestMapping(value = "/professor/delete/{dni}")
    public String deleteProfessor(@PathVariable String dni){
        professorsService.deleteProfessor(dni);
        return "Ok";
    }
}
