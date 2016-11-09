package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;
import com.formento.java8.lambda.expressions.repository.PersonRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final EmailSender emailSender;
    private final PersonRepoitory personRepoitory;

    @Autowired
    public PersonService(EmailSender emailSender, PersonRepoitory personRepoitory) {
        this.emailSender = emailSender;
        this.personRepoitory = personRepoitory;
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

    public Person getById(Integer id) {
        return personRepoitory
                .getById(id)
                .filter(Person::isEnabled)
                .orElseThrow(() -> new DataNotFoundException("Id " + id + " not found"));
    }

}
