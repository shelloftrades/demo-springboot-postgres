package com.example.beginnerdemo.repository;

import com.example.beginnerdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findByEmail(String email);
}
