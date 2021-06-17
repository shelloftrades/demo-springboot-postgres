package com.example.beginnerdemo.dao;

import com.example.beginnerdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * We need to tell SpringBoot that this class needs to be instantiated as a BEAN
 * so that we could inject it in other classes.
 * You can use annotations: Repository or Component
 * > Repository - serves as repository
 * > Component - a more generic description
 */
@Repository("fakeDao")
public class FakePersonAccessDataService implements PersonDao {
    // This data-member mocks the function of the database.
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        // 1. get the person by ID
        // 2. find out which index of the person from the list
        // 3. if the index is not within range, return 0
        // 3. else: set the value of name / properties from parameter person.
        // 4. save the updated element and return 1
        System.out.println("Update person object: " + person);
        return selectPersonById(id).map(
                p -> {
                    int indexToUpdate = DB.indexOf(p);

                    if (indexToUpdate < 0 | indexToUpdate >= DB.size())
                        return 0;
                    // create a new temporary object to set properties
                    Person temp = new Person(
                            p.getId(),
                            person.getName()
                    );

                    DB.set(indexToUpdate, temp);
                    return 1;

                }
        ).orElse(0);
    }

    @Override
    public int deletePersonById(UUID id) {
        // 1. get the person
        // 2. if person is not present return 0,
        // 3. else remove it from DB and return 1.

        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }

        DB.remove(personMaybe.get());
        return 1;
    }
}
