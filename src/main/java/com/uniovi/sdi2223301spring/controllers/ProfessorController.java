package com.uniovi.sdi2223301spring.controllers;

import com.uniovi.sdi2223301spring.entities.Mark;
import com.uniovi.sdi2223301spring.entities.Professor;
import com.uniovi.sdi2223301spring.services.ProfessorsService;
import com.uniovi.sdi2223301spring.validators.AddMarkValidator;
import com.uniovi.sdi2223301spring.validators.AddProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {
    @Autowired
    private AddProfessorValidator addProfessorValidator;
    @Autowired
    private ProfessorsService professorsService;
    @RequestMapping("/professor/list")
    public String getList(Model model){
        model.addAttribute("professorList", professorsService.getProfessors());
        return "professor/list";
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@Validated Professor professor, BindingResult result, Model model){
        addProfessorValidator.validate(professor, result);
        if (result.hasErrors()){
            model.addAttribute("professor", professor);
            return "professor/add";
        }
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
    public String getProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }
}
