package com.erudio.rest_with_spring_and_java_erudio.controller;

import com.erudio.rest_with_spring_and_java_erudio.data.vo.PersonVO;
import com.erudio.rest_with_spring_and_java_erudio.data.vo2.vo.PersonVO2;
import com.erudio.rest_with_spring_and_java_erudio.model.Person;
import com.erudio.rest_with_spring_and_java_erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value =  "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll(){

        return personService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody PersonVO person){

        return personService.create(person);
    }
    @PostMapping(value = "/v2",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO2 create2(@RequestBody PersonVO2 person){

        return personService.create2(person);
    }



    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@PathVariable Long id,@RequestBody PersonVO person){
        return personService.update(id, person);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id){
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }




}
