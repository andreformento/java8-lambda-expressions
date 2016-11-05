# Java 8: Lambda expressions

Based on [The Java™ Tutorials: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach2)

#### Approach 2: Create More Generalized Search Methods

The following method is more generic than printPersonsOlderThan; it prints members within a specified range of ages:

```
public void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
    for (Person p : roster) {
        if (low <= p.getAge() && p.getAge() < high) {
            p.printPerson();
        }
    }
}
```
What if you want to print members of a specified sex, or a combination of a specified gender and age range? What if you decide to change the Person class and add other attributes such as relationship status or geographical location? Although this method is more generic than printPersonsOlderThan, trying to create a separate method for each possible search query can still lead to brittle code. You can instead separate the code that specifies the criteria for which you want to search in a different class.
