package com.uniovi.sdi2223301spring.repositories;

import com.uniovi.sdi2223301spring.entities.Mark;
import com.uniovi.sdi2223301spring.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorsRepository extends CrudRepository<Professor, String> {
}
