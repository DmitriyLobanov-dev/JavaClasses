package Homework13.Task2_3;

import java.util.Objects;

/**
 * Cоздать класс Pet и его наследников Cat, Dog, Parrot. Создать класс Доктор,
 * содержащий имя и номер. Создать отображение из домашних животных, где в
 * качестве ключа выступает доктор, который обслуживает животное, а в
 * качестве значения – само животное.
 */

public abstract class Pet {

    private String name;
    private String breed;
    private int age;
    private boolean isWild;

    public Pet(String name, String breed, int age, boolean isWild) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.isWild = isWild;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                isWild == pet.isWild &&
                Objects.equals(name, pet.name) &&
                Objects.equals(breed, pet.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, age, isWild);
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", isWild=" + isWild;
    }
}
