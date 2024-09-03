package com.erudio.rest_with_spring_and_java_erudio.config;

import com.erudio.rest_with_spring_and_java_erudio.Respository.PersonRepository;
import com.erudio.rest_with_spring_and_java_erudio.model.Person;
import com.erudio.rest_with_spring_and_java_erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person = new Person(1L, "John", "Doe", "123 Main St, Springfield", "Male");
        personRepository.save(person);
    }
}
