package Homework13.Task2_3;

/**
 * Cоздать класс Pet и его наследников Cat, Dog, Parrot. Создать класс Доктор,
 * содержащий имя и номер. Создать отображение из домашних животных, где в
 * качестве ключа выступает доктор, который обслуживает животное, а в
 * качестве значения – само животное.
 */

public class Cat extends Pet {

    public Cat(String name, String breed, int age, boolean isWild) {
        super(name, breed, age, isWild);
    }

    @Override
    public String toString() {
        return "Cat{ " + super.toString() + '}';
    }
}
