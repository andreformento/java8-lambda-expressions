# Java 8: Lambda expressions

Based on [The Java™ Tutorials: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach9)

#### Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters

The following example uses aggregate operations to print the e-mail addresses of those members contained in the collection roster who are eligible for Selective Service:

```
roster
    .stream()
    .filter(
        p -> p.getGender() == Person.Sex.MALE
            && p.getAge() >= 18
            && p.getAge() <= 25)
    .map(p -> p.getEmailAddress())
    .forEach(email -> System.out.println(email));
```

The following table maps each of the operations the method processElements performs with the corresponding aggregate operation:

 processElements Action | Aggregate Operation 
---|---
 Obtain a source of objects | `Stream<E> stream()` 
 Filter objects that match a Predicate object | `Stream<T> filter(Predicate<? super T> predicate)` 
 Map objects to another value as specified by a Function object | `<R> Stream<R> map(Function<? super T,? extends R> mapper)` 
 Perform an action as specified by a Consumer object | `void forEach(Consumer<? super T> action)` 

The operations filter, map, and forEach are aggregate operations. Aggregate operations process elements from a stream, not directly from a collection (which is the reason why the first method invoked in this example is stream). A stream is a sequence of elements. Unlike a collection, it is not a data structure that stores elements. Instead, a stream carries values from a source, such as collection, through a pipeline. A pipeline is a sequence of stream operations, which in this example is filter- map-forEach. In addition, aggregate operations typically accept lambda expressions as parameters, enabling you to customize how they behave.

For a more thorough discussion of aggregate operations, see the Aggregate Operations lesson.
