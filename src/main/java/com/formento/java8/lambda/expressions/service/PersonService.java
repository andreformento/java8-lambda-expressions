package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;

import java.util.List;

public class PersonService {
    private final EmailSender emailSender;

    public PersonService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public void likeProfile(Person person) {
        System.out.println("+1 " + person.toString());
        person.getEmailAddress().ifPresent(
                emailAddress -> emailSender.sendEmail(emailAddress, "Now you are more important")
        );
    }

}
