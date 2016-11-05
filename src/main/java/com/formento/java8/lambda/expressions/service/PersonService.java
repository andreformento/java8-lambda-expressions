package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;

import java.util.List;

public class PersonService {

    public void printPersonsOlderThan(List<Person> roster, Integer age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

}
