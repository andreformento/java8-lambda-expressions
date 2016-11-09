package com.formento.java8.lambda.expressions.repository;

import com.formento.java8.lambda.expressions.model.Person;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

import java.time.chrono.IsoChronology;
import java.util.Map;
import java.util.Optional;

@Repository
public class PersonRepoitory {

    private static final Map<Integer, Person> PERSONS = ImmutableMap
            .<Integer, Person>builder()
            .put(1, new Person("André", IsoChronology.INSTANCE.dateNow().minusYears(18), Person.Sex.MALE, Optional.of("andreformento.sc@gmail.com")))
            .put(2, new Person("Peter", IsoChronology.INSTANCE.dateNow().minusYears(32), Person.Sex.MALE, Optional.empty(), false))
            .build();

    public Optional<Person> getById(Integer id) {
        return PERSONS.containsKey(id) ? Optional.ofNullable(PERSONS.get(id)) : Optional.empty();
    }


}
