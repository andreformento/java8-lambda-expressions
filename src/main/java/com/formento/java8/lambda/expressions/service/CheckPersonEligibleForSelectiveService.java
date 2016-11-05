package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;

public class CheckPersonEligibleForSelectiveService implements CheckPerson {

    public boolean test(Person p) {
        return Person.Sex.MALE.equals(p.getGender()) &&
                p.getAge() >= 18 && p.getAge() <= 25;
    }

}
