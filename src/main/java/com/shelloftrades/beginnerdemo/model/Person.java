package com.shelloftrades.beginnerdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue
    private  UUID id;
    @NonNull
    private  String name;
    private  Date birthday;

    @NonNull
    private  String email;
    private  String address;

    @NonNull
    private String password;
}
