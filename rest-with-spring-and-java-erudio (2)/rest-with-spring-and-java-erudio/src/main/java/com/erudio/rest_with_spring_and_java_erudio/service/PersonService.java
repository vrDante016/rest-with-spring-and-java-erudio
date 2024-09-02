package com.erudio.rest_with_spring_and_java_erudio.service;

import com.erudio.rest_with_spring_and_java_erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(String.valueOf(PersonService.class));

    public List<Person> findAll(){
        logger.info("Finding all person");
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            Person person = mackoPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mackoPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Person last name" + i );
        person.setAddress("person addres" + i);
        person.setGender("person gender" + i);
        return person;
    }

    public Person findById(String id){
        logger.info("Finding one Person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("rafael");
        person.setLastName("germano");
        person.setAddress("Ribeirão");
        person.setGender("male");
        return person;
    }
    public Person create(Person person){
        logger.info("Creating one person");
        return person;
    }
    public Person update(Person person){
        logger.info("Update one person");
        return person;
    }
    public void deleteById(String id){
        logger.info("Delete one person");

    }

}
