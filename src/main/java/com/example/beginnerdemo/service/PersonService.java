package com.example.beginnerdemo.service;

import com.example.beginnerdemo.dao.PersonDao;
import com.example.beginnerdemo.model.Person;
import com.example.beginnerdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This is the Person Service class.
 * To specify its specific purpose, we add @Service.
 * However you can also use @Component to be more generic.
 */
@Service
public class PersonService {
    //private final PersonDao personDao_;

    private final PersonRepository repository;


    /**
     * To tell spring that we wanted to INJECT into PersonRepository, use @Autowired.
     */
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    /**
     * Service implementation to add a person for request coming from the API.
     * @param person
     * @return
     */
    public Person addPerson( Person person){

        return repository.save(person);
    }

    /**
     * Service implementation to get all existing people upon the request from the API.
     * @return
     */
    public List<Person> getAllPeople() {
        return repository.findAll();
    }

    /**
     * Service implementation to retrieve a person by its ID.
     * @param id
     * @return
     */
    public Optional<Person> getPersonById(UUID id){
        return repository.findById(id);
    }

    /**
     * Service implementation to retrieve a person information using its email address.
     * @param email
     * @return
     */
    public Optional<Person> getPersonByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * Implementation of update person by ID.
     * @param id
     * @param person
     * @return
     */
    public Person updatePersonById(UUID id, Person person) {
        Person existingPerson = repository.findById(id).orElse(null);
        if(existingPerson == null)
            return  null;

        existingPerson.setName(person.getName());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setBirthday(person.getBirthday());
        existingPerson.setEmail(person.getEmail());

        return repository.save(existingPerson);
    }

    /**
     * Removes a person with ID.
     * @param id
     * @return
     */
    public UUID deletePersonById(UUID id){
         repository.deleteById(id);
        return id;
    }
}
