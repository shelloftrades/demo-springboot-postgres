package com.example.beginnerdemo.service;

import com.example.beginnerdemo.dao.PersonDao;
import com.example.beginnerdemo.model.Person;
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
    private final PersonDao personDao_;

    /**
     * To tell spring that we wanted to INJECT into PersonDao, use @Autowired.
     * Since we can inject to multiple DAOs, simply annotate @Qualifier to specify DAO.
     * @param personDao
     */
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao_ = personDao;
    }

    /**
     * Service implementation to add a person for request coming from the API.
     * @param person
     * @return
     */
    public int addPerson( Person person){
        return personDao_.insertPerson(person);
    }

    /**
     * Service implementation to get all existing people upon the request from the API.
     * @return
     */
    public List<Person> getAllPeople() {
        return personDao_.selectAllPeople();
    }

    /**
     * Service implementation to retrieve a person by its ID.
     * @param id
     * @return
     */
    public Optional<Person> getPersonById(UUID id){
        return personDao_.selectPersonById(id);
    }

    /**
     * Service implementation to retrieve a person information using its email address.
     * @param email
     * @return
     */
    public Optional<Person> getPersonByEmail(String email) {
        return personDao_.selectPersonByEmail(email);
    }

    /**
     * Implementation of update person by ID.
     * @param id
     * @param person
     * @return
     */
    public int updatePersonById(UUID id, Person person){
        return personDao_.updatePersonById(id, person);
    }

    /**
     * Removes a person with ID.
     * @param id
     * @return
     */
    public int deletePersonById(UUID id){
        return personDao_.deletePersonById(id);
    }
}
