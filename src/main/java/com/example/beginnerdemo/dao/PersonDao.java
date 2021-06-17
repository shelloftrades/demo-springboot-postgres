package com.example.beginnerdemo.dao;

import com.example.beginnerdemo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class is an interface that will be implemented by different database service class.
 * Example is 'FakePersonAccessDataService.java'
 */
public interface PersonDao {

    /**
     * Insert a new person into the database.
     * @param id
     * @param person
     * @return
     */
    int insertPerson(UUID id, Person person);

    /**
     * Inserts new person into the database without the given ID.
     * @param person
     * @return
     */
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    /**
     * List all person found in the database
     * @return
     */
    List<Person> selectAllPeople();

    /**
     * Retrieve a person from the database using its ID.
     * Option is used since there might me times that this method will return null
     * when there is no matching record with its ID.
     * @param id
     * @return
     */
    Optional<Person> selectPersonById(UUID id);

    /**
     * Update an existing record of a person
     * @param id
     * @param person
     * @return
     */
    int updatePersonById(UUID id, Person person);

    /**
     * Removes an existing person
     * @param id
     * @return
     */
    int deletePersonById(UUID id);
}
