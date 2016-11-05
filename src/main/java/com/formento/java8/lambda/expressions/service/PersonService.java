package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;

import java.util.List;

public class PersonService {

    public void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

}
