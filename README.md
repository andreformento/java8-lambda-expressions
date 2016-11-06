# Java 8: Lambda expressions

Based on [The Java™ Tutorials: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach5)

#### Approach 5: Specify Search Criteria Code with a Lambda Expression

The CheckPerson interface is a functional interface. A functional interface is any interface that contains only one abstract method. (A functional interface may contain one or more default methods or static methods.) Because a functional interface contains only one abstract method, you can omit the name of that method when you implement it. To do this, instead of using an anonymous class expression, you use a lambda expression, which is highlighted in the following method invocation:

```
printPersons(
    roster,
    (Person p) -> p.getGender() == Person.Sex.MALE
        && p.getAge() >= 18
        && p.getAge() <= 25
);
```

See Syntax of Lambda Expressions for information about how to define lambda expressions.

You can use a standard functional interface in place of the interface CheckPerson, which reduces even further the amount of code required.
