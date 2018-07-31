package com.bazlur.foreach;

import com.bazlur.Person;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Person> shortList = Person.createShortList();
        //forEach(shortList, person -> System.out.println(person.toString()));
        //orEach(shortList, Person::getAge, System.out::println);


//        for (int i = 0; i < shortList.size(); i++) {
//            System.out.println(shortList.get(i).getGivenName());
//
//            ///
//        }

//        forEach(shortList, person -> {
//            System.out.println(person.getGivenName());
//        });


        List<Integer> ages = shortList.stream()
                .parallel()
                .filter(person -> person.getAge() < 25) // filter
                .map(Person::getAge)
                .map(age -> age - 2)// map
                .collect(Collectors.toList());// collect


        //forEach(shortList, Person::getAge, integer -> System.out.println(integer));
    }

//    public static void forEach(List<Person> shortList, Function<Person, Integer> function,  Consumer<Integer> consumer){
//        for (int i = 0; i < shortList.size(); i++) {
//            //
//            Person person = shortList.get(i);
//            Integer age = function.apply(person);
//            consumer.accept(age);
//        }
//    }


    public static <T, E> void forEach(List<T> item, Function<T, E> function, Consumer<E> consumer) {

        for (int i = 0; i < item.size(); i++) {
            E transformed = function.apply(item.get(i));
            consumer.accept(transformed);
        }
    }
//
//    public static void forEach(List<Person> personList, Consumer<Person> consumer) {
//
//        for (int i = 0; i < personList.size(); i++) {
//            Person person = personList.get(i);
//
//            consumer.accept(person);
//        }
//    }
}
