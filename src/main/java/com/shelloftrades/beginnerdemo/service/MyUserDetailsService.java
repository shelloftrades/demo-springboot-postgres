package com.shelloftrades.beginnerdemo.service;

import com.shelloftrades.beginnerdemo.model.Person;
import com.shelloftrades.beginnerdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final PersonRepository repository;

    @Autowired
    public MyUserDetailsService(PersonRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Person person = repository.findByEmail(userName).orElse(null);
        if(person == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String email = person.getEmail();
        String password = person.getPassword();
        return new User(email, password, new ArrayList<>());
    }
}
