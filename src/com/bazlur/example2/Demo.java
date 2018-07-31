package com.bazlur.example2;

public class Demo {
    public static void main(String[] args) {
        // PersonWithText personWithText = new PersonWithText();
        // PersonWitVideo personWitVideo = new PersonWitVideo();

        call(new Person() {
            @Override
            public void response() {
                System.out.println("hello world!");
            }
        });

        //Person person = () -> System.out.println("hello world!");
        Runnable runnable = () -> System.out.println("bye bye!");

        call(() -> System.out.println("bye bye!"));

    }

    public static void call(Person person){
        person.response();;
    }
}

//class PersonWitVideo implements Person{
//
//    @Override
//    public void response() {
//        System.out.println(" sending video call");
//    }
//}
//class PersonWithText implements Person{
//
//    @Override
//    public void response() {
//        System.out.println(" Im sending a text");
//    }
//}

//@FunctionalInterface
interface Person{

    public void response();
    //public void walk();
}
