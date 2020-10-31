package imperative;

import POJOS.Person;
import Enum.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

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

        System.out.println("// Imperative approach");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.getGender())) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        System.out.println("// Declarative approach");

        Predicate<Person> personPredicate = female -> FEMALE.equals(female.getGender());

        List<Person> females1 = people
                .stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        females1.forEach(System.out::println);

    }

}
