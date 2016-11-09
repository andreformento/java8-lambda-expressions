package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.time.chrono.IsoChronology;
import java.util.List;

import static org.mockito.Mockito.*;

public class ProcessorServiceTest {

    private Person fred;
    private Person jane;
    private Person george;
    private Person bob;

    @Before
    public void init() {
        final Integer currentYear = IsoChronology.INSTANCE.dateNow().getYear();

        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(currentYear - 24, 6, 20),
                Person.Sex.MALE,
                "fred@example.com");
        jane = new Person(
                "Jane",
                IsoChronology.INSTANCE.date(currentYear - 26, 7, 15),
                Person.Sex.FEMALE, "jane@example.com");

        george = new Person(
                "George",
                IsoChronology.INSTANCE.date(currentYear - 17, 8, 13),
                Person.Sex.MALE, "george@example.com");
        bob = new Person(
                "Bob",
                IsoChronology.INSTANCE.date(currentYear - 13, 9, 12),
                Person.Sex.MALE, "bob@example.com");
    }

    @Test
    public void shouldShowPersonsOlderThan() {
        // given
        final Person spyFred = spy(fred);
        final Person spyJane = spy(jane);
        final Person spyGeorge = spy(george);
        final Person spyBob = spy(bob);

        final List<Person> roster = ImmutableList
                .<Person>builder()
                .add(spyFred)
                .add(spyJane)
                .add(spyGeorge)
                .add(spyBob)
                .build();

        // when
        roster
                .stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(Person::getEmailAddress)
                .forEach(System.out::println);

        // then
        verify(spyFred, times(1)).getEmailAddress();

        verify(spyJane, never()).getEmailAddress();
        verify(spyGeorge, never()).getEmailAddress();
        verify(spyBob, never()).getEmailAddress();
    }

}
