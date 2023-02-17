package com.uniovi.sdi2223301spring.services;

import com.uniovi.sdi2223301spring.entities.Professor;
import com.uniovi.sdi2223301spring.repositories.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorsService {
    @Autowired
    private ProfessorsRepository professorsRepository;

    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<>();
        professorsRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Professor getProfessor(String dni){
        return professorsRepository.findById(dni).get();
    }
    public void addProfessor(Professor professor) {
        professorsRepository.save(professor);
    }
    public void deleteProfessor(String dni) {
        professorsRepository.deleteById(dni);
    }

}
