package com.erudio.rest_with_spring_and_java_erudio.Respository;

import com.erudio.rest_with_spring_and_java_erudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
