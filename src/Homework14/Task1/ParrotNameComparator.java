package Homework14.Task1;

/**
 * Использовать иерархию из задания 13.2 (животные).
 * Использовать в качестве ключа для TreeMap объекты
 * класса Parrot. В качестве значения использовать объекты
 * класса Doctor. Вывести все элементы на экран. Написать
 * свой компаратор для класса Parrot и создать второй
 * TreeMap. Вывести и его элементы.
 */

import Homework13.Task2_3.Parrot;

import java.util.Comparator;

public class ParrotNameComparator implements Comparator<Parrot> {

    @Override
    public int compare(Parrot o1, Parrot o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
