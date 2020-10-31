package stream;

import POJOS.Person;
import Enum.Gender;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {

    private final static Gender MALE = Gender.MALE;
    private final static Gender FEMALE = Gender.FEMALE;

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Jhone", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        people.stream()
                .map(Person::getGender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        Function<Person, String> personStringFunction = person -> person.getName();
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.getGender());

        boolean containsOnlyFemale = people.stream()
                .allMatch(personPredicate);

        System.out.println(containsOnlyFemale);

        boolean containsAnyFemale = people.stream()
                .anyMatch(personPredicate);

        System.out.println(containsAnyFemale);

    }

}
