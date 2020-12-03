package Homework14.Task1;

import Homework13.Task2_3.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * Использовать иерархию из задания 13.2 (животные).
 * Использовать в качестве ключа для TreeMap объекты
 * класса Parrot. В качестве значения использовать объекты
 * класса Doctor. Вывести все элементы на экран. Написать
 * свой компаратор для класса Parrot и создать второй
 * TreeMap. Вывести и его элементы.
 */

public class Runner {

    public static void main(String[] args) {

        Map<Pet, Doctor> petsMap = new TreeMap<>();
        petsMap.put(new Parrot("Mr.Anderson", "just cat", 2, false), new Doctor("Dr.Acula", 666));
        petsMap.put(new Parrot("Kilmister", "Jack Daniels", 3, true), new Doctor("Dr.Alibi", 7));
        petsMap.put(new Parrot("Cotton's Parrot", "Ara yellow-blue", 33, true), new Doctor("Dr.Strange", 13));

        System.out.println(petsMap);

        Map<Pet, Doctor> petsMap2 = new TreeMap<>();
        petsMap2.put(new Parrot("Mr.Anderson", "just cat", 2, false), new Doctor("Dr.Acula", 666));
        petsMap2.put(new Parrot("Mr.Anderson", "just cat", 2, false), new Doctor("Dr.Acula", 666));
        petsMap2.put(new Parrot("Mr.Anderson", "just cat", 2, false), new Doctor("Dr.Acula", 666));

        System.out.println(petsMap2);

    }
}
