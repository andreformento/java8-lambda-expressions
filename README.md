# Java 8: Lambda expressions

Based on [The Java™ Tutorials: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach8)

#### Approach 8: Use Generics More Extensively

Reconsider the method processPersonsWithFunction. The following is a generic version of it that accepts, as a parameter, a collection that contains elements of any data type:

```
public <X, Y> void processElements(
    Iterable<X> source,
    Predicate<X> tester,
    Function <X, Y> mapper,
    Consumer<Y> block) {
    for (X p : source) {
        if (tester.test(p)) {
            Y data = mapper.apply(p);
            block.accept(data);
        }
    }
}
```

To print the e-mail address of members who are eligible for Selective Service, invoke the processElements method as follows:

```
processElements(
    roster,
    p -> p.getGender() == Person.Sex.MALE
        && p.getAge() >= 18
        && p.getAge() <= 25,
    p -> p.getEmailAddress(),
    email -> System.out.println(email)
);
```

This method invocation performs the following actions:
1. Obtains a source of objects from the collection source. In this example, it obtains a source of Person objects from the collection roster. Notice that the collection roster, which is a collection of type List, is also an object of type Iterable.
2. Filters objects that match the Predicate object tester. In this example, the Predicate object is a lambda expression that specifies which members would be eligible for Selective Service.
3. Maps each filtered object to a value as specified by the Function object mapper. In this example, the Function object is a lambda expression that returns the e-mail address of a member.
4. Performs an action on each mapped object as specified by the Consumer object block. In this example, the Consumer object is a lambda expression that prints a string, which is the e-mail address returned by the Function object.
5. You can replace each of these actions with an aggregate operation.
