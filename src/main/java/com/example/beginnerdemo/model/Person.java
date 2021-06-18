package com.example.beginnerdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.NonNull;

import java.sql.Date;
import java.util.UUID;

public class Person {
    // TODO: add validation annotation to show a property is NOT NULL, etc.
    private final UUID id;
    private final String name;
    private final Date birthday;
    private final String email;
    private final String address;

    /**
     * This object is POJO.
     * This allows the backend to understand JSON objects received from API.
     *
     * @param id
     * @param name
     */
    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("birthday")Date birthday,
                  @JsonProperty("email")String email,
                  @JsonProperty("address")String address
    ) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
