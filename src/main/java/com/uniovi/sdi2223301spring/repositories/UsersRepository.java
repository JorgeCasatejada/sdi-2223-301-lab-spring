package com.uniovi.sdi2223301spring.repositories;

import com.uniovi.sdi2223301spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
