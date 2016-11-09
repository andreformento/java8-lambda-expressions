package com.formento.java8.lambda.expressions.service;

import com.formento.java8.lambda.expressions.model.Person;
import com.formento.java8.lambda.expressions.repository.PersonRepoitory;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.chrono.IsoChronology;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Spy
    private EmailSender emailSender;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private PersonRepoitory personRepoitory;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Person fred;
    private Person jane;
    private Person george;
    private Person bob;

    @Before
    public void init() {
        final Integer currentYear = IsoChronology.INSTANCE.dateNow().getYear();

        fred = new Person(
                "Fred",
                IsoChronology.INSTANCE.date(currentYear - 30, 6, 20),
                Person.Sex.MALE,
                Optional.of("fred@example.com"));
        jane = new Person(
                "Jane",
                IsoChronology.INSTANCE.date(currentYear - 25, 7, 15),
                Person.Sex.FEMALE, Optional.of("jane@example.com"));

        george = new Person(
                "George",
                IsoChronology.INSTANCE.date(currentYear - 17, 8, 13),
                Person.Sex.MALE, Optional.of("george@example.com"));
        bob = new Person(
                "Bob",
                IsoChronology.INSTANCE.date(currentYear - 13, 9, 12),
                Person.Sex.MALE, Optional.empty());
    }

    @Test
    public void shouldShowPersonsOlderThan() {
        // given
        final Integer age = 18;

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
        personService.printPersonsOlderThan(roster, age);

        // then
        verify(spyFred, times(1)).printPerson();
        verify(spyJane, times(1)).printPerson();

        verify(spyGeorge, never()).printPerson();
        verify(spyBob, never()).printPerson();
    }

    @Test
    public void shouldLikeProfileWithEmail() {
        // when
        personService.likeProfile(george);

        // then
        verify(emailSender, times(1)).sendEmail(any(), any());
    }

    @Test
    public void shouldLikeProfileWithoutEmail() {
        // when
        personService.likeProfile(bob);

        // then
        verify(emailSender, never()).sendEmail(any(), any());
    }

    @Test
    public void shouldGetByIdWhenExists() {
        // given
        final Integer id = 1;

        // when
        final Person person = personService.getById(id);

        // then
        assertNotNull(person);
    }

    @Test
    public void shouldNotGetByIdWhenPersonIsNotEnabled() {
        // given
        final Integer id = 2;

        // expected exception
        expectedException.expect(DataNotFoundException.class);
        expectedException.expectMessage("Id 2 not found");

        // when
        personService.getById(id);
    }

    @Test
    public void shouldNotGetByIdWhenNotExists() {
        // given
        final Integer id = 987;

        // expected exception
        expectedException.expect(DataNotFoundException.class);
        expectedException.expectMessage("Id 987 not found");

        // when
        personService.getById(id);
    }

}
