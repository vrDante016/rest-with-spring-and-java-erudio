package com.erudio.rest_with_spring_and_java_erudio.service;

import com.erudio.rest_with_spring_and_java_erudio.Respository.PersonRepository;
import com.erudio.rest_with_spring_and_java_erudio.data.vo.PersonVO;
import com.erudio.rest_with_spring_and_java_erudio.exception.ResouceNotFoundException;
import com.erudio.rest_with_spring_and_java_erudio.exceptionHandler.CustomizeResponseEntityExceptionHandler;
import com.erudio.rest_with_spring_and_java_erudio.model.Person;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(String.valueOf(PersonService.class));

    public List<PersonVO> findAll(){
        logger.info("Finding all person");
        return personRepository.findAll();
    }

    public PersonVO findById(Long id){
        logger.info("Finding one Person");
         return personRepository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this id"));


    }
    public PersonVO create(PersonVO person){
        logger.info("Creating one person");
        return personRepository.save(person);
    }
    public PersonVO update(Long id, PersonVO person){
        logger.info("Update one person");
        try{
            Person entity = personRepository.getReferenceById(id);
            updateData(entity, person);
            return personRepository.save(entity);

        }catch (EntityNotFoundException e){
            throw new ResouceNotFoundException("not found datas from a person");
        }
    }
    public void updateData(PersonVO entity, PersonVO person){
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
    }
    public void deleteById(Long id){
        logger.info("Delete one person");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No records found for this id"));
        personRepository.deleteById(entity.getId());

    }

}
