package com.jxust.controller;

import com.jxust.dao.PersonRepository;
import com.jxust.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
/**
 * Created by user on 2018/12/13.
 */
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @GetMapping(value = "/person")
    private List<Person> personList(){
        return personRepository.findAll();
    }

    /**
     * add a person
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value="/person")
    public Person personAdd(@RequestParam("name") String name,
                            @RequestParam("age") Integer age){
        Person person = new Person();
               person.setName(name);
               person.setAge(age);
        return personRepository.save(person);
    }

}
