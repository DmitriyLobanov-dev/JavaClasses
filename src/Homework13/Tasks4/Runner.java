package Homework13.Tasks4;

import Homework13.Task2_3.Cat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Напишите метод, который на вход получает коллекцию объектов (например,
 * ArrayList), а возвращает коллекцию уже без дубликатов.
 */

public class Runner {

    public static void main(String[] args) {

        ArrayList<Object> names = new ArrayList<>();
        names.add(new Cat("Smelly Cat", "hobo", 1, true));
        names.add(new Cat("Smelly Cat", "hobo", 1, true));
        names.add(new Cat("Smelly Cat", "hobo", 1, true));
        names.add(new Cat("Jelly Cat", "hobo", 1, false));
        names.add(new Cat("Jelly Cat", "hobo", 1, false));
        names.add(new Cat("Jelly Cat", "hobo", 1, false));
        names.add(new Cat("Behemoth", "hobo", 1, true));
        names.add(new Cat("Behemoth", "hobo", 1, true));
        names.add(new Cat("Behemoth", "hobo", 1, true));

        System.out.println(names);

        System.out.println(deduplicate(names));

    }

    public static Set<Object> deduplicate(ArrayList<Object> list) {
        return new HashSet<>(list);
    }

}
