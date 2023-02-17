package com.uniovi.sdi2223301spring.controllers;

import com.uniovi.sdi2223301spring.entities.Professor;
import com.uniovi.sdi2223301spring.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorsService professorsService;
    @RequestMapping("/professor/list")
    public String getList(Model model){
        model.addAttribute("professorList", professorsService.getProfessors());
        return "professor/list";
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor){
        professorsService.addProfessor(professor);
        return "redirect:/professor/list";
    }
    @RequestMapping(value = "/professor/details/{dni}")
    public String getDetail(Model model, @PathVariable String dni){
        model.addAttribute("professor", professorsService.getProfessor(dni));
        return "professor/details";
    }
    @RequestMapping(value = "/professor/delete/{dni}")
    public String deleteProfessor(@PathVariable String dni){
        professorsService.deleteProfessor(dni);
        return "redirect:/professor/list";
    }
    @RequestMapping(value = "/professor/add")
    public String getProfessor() {
        return "professor/add";
    }
}
