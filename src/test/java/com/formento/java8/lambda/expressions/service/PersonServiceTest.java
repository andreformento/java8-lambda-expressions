package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.time.chrono.IsoChronology;
import java.util.List;

import static org.junit.Assert.*;

public class PersonServiceTest {

    private PersonService personService;
    private List<Person> roster;

    private Person fred;
    private Person jane;

    @Before
    public void init() {
        this.personService = new PersonService();
        final Integer currentYear = IsoChronology.INSTANCE.dateNow().getYear();

        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(currentYear - 30, 6, 20),
                Person.Sex.MALE,
                "fred@example.com");
        jane = new Person(
                "Jane",
                IsoChronology.INSTANCE.date(currentYear - 25, 7, 15),
                Person.Sex.FEMALE, "jane@example.com");

        this.roster = ImmutableList
                .<Person>builder()
                .add(fred)
                .add(jane)
                .add(new Person(
                        "George",
                        IsoChronology.INSTANCE.date(currentYear - 17, 8, 13),
                        Person.Sex.MALE, "george@example.com"))
                .add(new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(currentYear - 13, 9, 12),
                        Person.Sex.MALE, "bob@example.com"))
                .build();
    }

    @Test
    public void shouldShowPersonsOlderThan() {
        // given
        final Integer age = 18;

        // when
        final List<Person> personsOlderThan18 = personService.filterPersonsOlderThan(roster, age);

        // then
        assertNotNull(personsOlderThan18);
        assertEquals(2, personsOlderThan18.size());
        assertTrue(personsOlderThan18.contains(fred));
        assertTrue(personsOlderThan18.contains(jane));
    }

}
