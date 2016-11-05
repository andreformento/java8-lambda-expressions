package com.formento.java8.lambda.expressions.model;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    private final String name;
    private final LocalDate birthday;
    private final Sex gender;
    private final String emailAddress;

    public Person(final String name, final LocalDate birthday, final Sex gender, final String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public Integer getAge() {
        return birthday
                .until(IsoChronology.INSTANCE.dateNow())
                .getYears();
    }

    public String toString() {
        return new StringBuilder()
                .append(this.name)
                .append(", ")
                .append(this.getAge())
                .toString();
    }

    public Sex getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (birthday != null ? !birthday.equals(person.birthday) : person.birthday != null) return false;
        if (gender != person.gender) return false;
        return emailAddress != null ? emailAddress.equals(person.emailAddress) : person.emailAddress == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }
}
