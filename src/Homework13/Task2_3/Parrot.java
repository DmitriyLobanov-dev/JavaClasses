package Homework13.Task2_3;

/**
 * Cоздать класс Pet и его наследников Cat, Dog, Parrot. Создать класс Доктор,
 * содержащий имя и номер. Создать отображение из домашних животных, где в
 * качестве ключа выступает доктор, который обслуживает животное, а в
 * качестве значения – само животное.
 */

public class Parrot extends Pet {

    public Parrot(String name, String breed, int age, boolean isWild) {
        super(name, breed, age, isWild);
    }

    @Override
    public String toString() {
        return "Parrot{ " + super.toString() + '}';
    }

    @Override
    public int compareTo(Pet o) {
        String cr1 = this.getName() + this.getBreed();
        String cr2 = o.getName() + o.getBreed();
        return cr1.compareTo(cr2);
    }
}
