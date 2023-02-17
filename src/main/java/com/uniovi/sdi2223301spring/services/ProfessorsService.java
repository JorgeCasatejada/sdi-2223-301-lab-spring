package com.uniovi.sdi2223301spring.services;

import com.uniovi.sdi2223301spring.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorsService {
    private List<Professor> professors = new LinkedList<>();
    @PostConstruct
    public void init(){
        professors.add(new Professor("56389567N","Juan","Pérez Álvarez","Titular"));
        professors.add(new Professor("34689421A","Jorge","Casatejada Santamarta","Asociado"));
        professors.add(new Professor("97653342Q","Laura","Menéndez Rodríguez","Adjunto"));
        professors.add(new Professor("96324534V","María","Castro Muñoz","Catedrático"));
        professors.add(new Professor("08462941H","Pedro","Gómez Ruiz","Sustituto"));
        professors.add(new Professor("02362941H","Teresa","Campo Aguilar","Titular"));
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public Professor getProfessor(String dni){
        return professors.stream().filter(professor -> professor.getDni().equals(dni)).findFirst().get();
    }
    public void addProfessor(Professor professor) {
        professors.add(professor);
    }
    public void deleteProfessor(String dni) {
        professors.removeIf(professor -> professor.getDni().equals(dni));
    }

}
