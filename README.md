# Java 8: Lambda expressions

Based on [The Java™ Tutorials: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach7)

#### Approach 7: Use Lambda Expressions Throughout Your Application

Reconsider the method printPersonsWithPredicate to see where else you could use lambda expressions:

```
public void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
    for (Person p : roster) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}
```

This method checks each Person instance contained in the List parameter roster whether it satisfies the criteria specified in the Predicate parameter tester. If the Person instance does satisfy the criteria specified by tester, the method printPersron is invoked on the Person instance.

Instead of invoking the method printPerson, you can specify a different action to perform on those Person instances that satisfy the criteria specified by tester. You can specify this action with a lambda expression. Suppose you want a lambda expression similar to printPerson, one that takes one argument (an object of type Person) and returns void. Remember, to use a lambda expression, you need to implement a functional interface. In this case, you need a functional interface that contains an abstract method that can take one argument of type Person and returns void. The Consumer<T> interface contains the method void accept(T t), which has these characteristics. The following method replaces the invocation p.printPerson() with an instance of Consumer<Person> that invokes the method accept:

```
public void processPersons(
    List<Person> roster,
    Predicate<Person> tester,
    Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
}
```

As a result, the following method invocation is the same as when you invoked printPersons in Approach 3: Specify Search Criteria Code in a Local Class to obtain members who are eligible for Selective Service. The lambda expression used to print members is highlighted:

```
processPersons(
     roster,
     p -> p.getGender() == Person.Sex.MALE
         && p.getAge() >= 18
         && p.getAge() <= 25,
     p -> p.printPerson()
);
```

What if you want to do more with your members' profiles than printing them out. Suppose that you want to validate the members' profiles or retrieve their contact information? In this case, you need a functional interface that contains an abstract method that returns a value. The Function<T,R> interface contains the method R apply(T t). The following method retrieves the data specified by the parameter mapper, and then performs an action on it specified by the parameter block:

```
public void processPersonsWithFunction(
    List<Person> roster,
    Predicate<Person> tester,
    Function<Person, String> mapper,
    Consumer<String> block) {
    for (Person p : roster) {
        if (tester.test(p)) {
            String data = mapper.apply(p);
            block.accept(data);
        }
    }
}
```

The following method retrieves the email address from each member contained in roster who is eligible for Selective Service and then prints it:

```
processPersonsWithFunction(
    roster,
    p -> p.getGender() == Person.Sex.MALE
        && p.getAge() >= 18
        && p.getAge() <= 25,
    p -> p.getEmailAddress(),
    email -> System.out.println(email)
);
```
