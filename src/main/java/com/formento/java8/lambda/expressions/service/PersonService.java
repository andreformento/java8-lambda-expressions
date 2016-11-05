package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    public List<Person> filterPersonsOlderThan(List<Person> roster, Integer age) {
        List<Person> result = new ArrayList<>();
        for (Person p : roster) {
            if (p.getAge() >= age) {
                result.add(p);
            }
        }
        return result;
    }

}
