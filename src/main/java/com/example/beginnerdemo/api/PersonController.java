package com.example.beginnerdemo.api;

import com.example.beginnerdemo.model.Person;
import com.example.beginnerdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 1. This class receives different HTTP requests from clients.
 * These requests can be in the form of GET, POST, PUT, DELETE
 * Annotate it with @RestController
 * <p>
 * 2. To specify the URI or the path this request will be received,
 * just annotate @RequestMapping
 */

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService_;

    /**
     * Specify that this controller is injecting to PersonService
     *
     * @param personService
     */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService_ = personService;
    }

    /**
     * This method specifies that is accepts POST request from client,
     * thus the @PostMapping annotation
     *
     * @param person - Tell the spring that we want to get the request body and shovel that to the Person object.
     *               - the Person model will auto-convert the JSON object
     *               - To do that, simply add @RequestBody
     *               Path: 'localhost:8080/api/v1/person/'
     */
    @PostMapping
    public void addPerson(@RequestBody @Validated @NonNull Person person) {
        personService_.addPerson(person);
    }

    /**
     * This method specifies that it accepts GET request from client.
     * Path: 'localhost:8080/api/v1/person/'
     *
     * @return
     */
    @GetMapping
    public List<Person> getAllPeople() {
        return personService_.getAllPeople();
    }

    /**
     * This method specifies that it accepts GET request from client.
     * Additionally, an ID is concatenated to know which record is to be retrieved.
     * Sample path: 'localhost:8080/api/v1/person/801e5ea5-fd4c-4a46-8c22-4b7d55c1a45f'
     *
     * @return
     */
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") @NonNull UUID id) {
        return personService_.getPersonById(id)
                .orElse(null); // Here you can add a custom message and code to send to client if
                                     // there is no person found.
    }

    /**
     * TODO: BUG, when calling this method it returns all the people from the DB
     * This method accepts GET request from client with the request parameter email.
     * Sample path: 'localhost:8080/api/v1/person/email=akinner5@usa.gov'
     * @param email
     * @return
     */
    @GetMapping(params = "{email}")
    public Person getPersonByEmail(@RequestParam("email") String email) {
        return personService_.getPersonByEmail(email)
                .orElse(null); // Here you can add a custom message and code to send to client if
                                     // there is no person found.
    }

    /**
     * This method accepts PUT request from client.
     * ID is concatenated at the path eg. 'localhost:8080/api/v1/person/801e5ea5-fd4c-4a46-8c22-4b7d55c1a45f'
     *
     * @param id
     * @param person
     * @return
     */
    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @RequestBody @NonNull @Validated Person person) {
        return personService_.updatePersonById(id, person);
    }

    /**
     * This method accepts a DELETE request from client.
     * ID is part of the request parameter of the request.
     * This is just to show variant to show how to pass the ID for delete.
     *
     * @param id
     * @return
     */
    @DeleteMapping(params = "id")
    public int deletePersonById(@RequestParam("id") UUID id) {
        return personService_.deletePersonById(id);
    }

}
