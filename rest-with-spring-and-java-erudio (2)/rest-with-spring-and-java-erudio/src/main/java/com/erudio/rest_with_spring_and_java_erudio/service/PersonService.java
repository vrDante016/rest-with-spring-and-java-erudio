package com.erudio.rest_with_spring_and_java_erudio.service;

import com.erudio.rest_with_spring_and_java_erudio.Respository.PersonRepository;
import com.erudio.rest_with_spring_and_java_erudio.data.vo.PersonVO;
import com.erudio.rest_with_spring_and_java_erudio.data.vo2.vo.PersonVO2;
import com.erudio.rest_with_spring_and_java_erudio.exception.ResouceNotFoundException;
import com.erudio.rest_with_spring_and_java_erudio.exceptionHandler.CustomizeResponseEntityExceptionHandler;
import com.erudio.rest_with_spring_and_java_erudio.mapper.DozerMapper;
import com.erudio.rest_with_spring_and_java_erudio.mapperCustom.PersonMapper;
import com.erudio.rest_with_spring_and_java_erudio.model.Person;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper mapper;

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(String.valueOf(PersonService.class));

    public List<PersonVO> findAll(){
        logger.info("Finding all person");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        logger.info("Finding one Person");
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this id"));
        return DozerMapper.parseObject(entity, PersonVO.class);

    }
    public PersonVO create(PersonVO person){
        logger.info("Creating one person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var VO =  personRepository.save(entity);
        return DozerMapper.parseObject(VO, PersonVO.class);
    }

    public PersonVO2 create2(PersonVO2 person){
        logger.info("Creating one person");
        var entity = mapper.converVoToEntity(person);
        var vo = mapper.convertEntityToVo(personRepository.save(entity));
        return vo;
    }

    public PersonVO update(Long id, PersonVO person){
        logger.info("Update one person");
        try{
            Person entity = personRepository.getReferenceById(id);

            updateData(DozerMapper.parseObject(entity, PersonVO.class), person);
            var VO = personRepository.save(entity);
            return DozerMapper.parseObject(VO, PersonVO.class);

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
