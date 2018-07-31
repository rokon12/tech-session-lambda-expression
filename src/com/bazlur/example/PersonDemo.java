package com.bazlur.example;

import com.bazlur.Gender;
import com.bazlur.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;


@FunctionalInterface
interface Predicate {
    boolean test(Person person);
}


public class PersonDemo {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

        calculate((a, b) -> a + b,  5, 6);


        List<Person> shortList = Person.createShortList();

        findPerson(shortList, (Person person) -> person.getGender() == Gender.MALE);

        findPerson(shortList, new Predicate() {
            @Override
            public boolean test(Person person) {
                return person.getGender() == Gender.FEMALE && person.getAge() <= 25;
            }
        });

    }

    public static List<Person> findPerson(List<Person> list, Predicate predicate) {
        List<Person> persons = new ArrayList<>();

        for (Person person : list) {
            if (predicate.test(person)) {
                persons.add(person);
            }
        }

        return persons;
    }

    public List<Person> findMalePersons(List<Person> list) {
        List<Person> persons = new ArrayList<>();

        for (Person person : list) {
            if (person.getGender() == Gender.MALE) {
                persons.add(person);
            }
        }

        return persons;
    }

    public List<Person> findFemalePersons(List<Person> list) {
        List<Person> persons = new ArrayList<>();

        for (Person person : list) {
            if (person.getGender() == Gender.FEMALE) {
                persons.add(person);
            }
        }

        return persons;
    }

    public List<Person> findFemalePersonsNoMoreThan25YearsOld(List<Person> list) {
        List<Person> persons = new ArrayList<>();

        for (Person person : list) {
            if (person.getGender() == Gender.FEMALE
                    && person.getAge() <= 25) {
                persons.add(person);
            }
        }

        return persons;
    }

    public static Integer calculate(BiFunction<Integer, Integer, Integer> function, int a, int b) {
       return function.apply(a, b);
    }

    public static void calculateDouble(BiFunction<Double, Double, Double> function) {

    }

}
