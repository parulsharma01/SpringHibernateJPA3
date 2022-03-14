package com.parul.springdata.springdatajpa3.repos;

import com.parul.springdata.springdatajpa3.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
