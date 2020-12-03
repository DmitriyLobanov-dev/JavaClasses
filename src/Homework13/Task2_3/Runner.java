package Homework13.Task2_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Cоздать класс Pet и его наследников Cat, Dog, Parrot. Создать класс Доктор,
 * содержащий имя и номер. Создать отображение из домашних животных, где в
 * качестве ключа выступает доктор, который обслуживает животное, а в
 * качестве значения – само животное.
 */

public class Runner {

    public static void main(String[] args) {

        //Task2
        Map<Doctor, Pet> patientMap = new HashMap<>();
        patientMap.put(new Doctor("Dr.Acula", 666), new Cat("Mr.Anderson", "just cat", 2, false));
        patientMap.put(new Doctor("Dr.Alibi", 7), new Dog("Kilmister", "Jack Daniels", 3, true));
        patientMap.put(new Doctor("Dr.Strange", 13), new Parrot("Cotton's Parrot", "Ara yellow-blue", 33, true));

        System.out.println(patientMap);

        //Task3 отображение, которое будет хранить человека (как ключ) и список (List) всех его животных (как значение)
        ArrayList<Pet> petList1 = new ArrayList<>();
        petList1.add(new Parrot("The Chick", "chicken", 1, false));
        petList1.add(new Parrot("The Duck", "duck", 1, false));
        ArrayList<Pet> petList2 = new ArrayList<>();
        petList1.add(new Cat("Smelly Cat", "hobo", 1, true));

        Map<Person, ArrayList<Pet>> petsOwnedMap = new HashMap<>();
        petsOwnedMap.put(new Person("Joey", "Tribbiani"), petList1);
        petsOwnedMap.put(new Person("Chandler", "Bing"), petList1);
        petsOwnedMap.put(new Person("Phoebe", "Buffay"), petList2);

        System.out.println(petsOwnedMap);
    }

}
