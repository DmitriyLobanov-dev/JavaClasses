package Homework13.Task2_3;

import java.util.Objects;

/**
 * Cоздать класс Pet и его наследников Cat, Dog, Parrot. Создать класс Доктор,
 * содержащий имя и номер. Создать отображение из домашних животных, где в
 * качестве ключа выступает доктор, который обслуживает животное, а в
 * качестве значения – само животное.
 */

public class Doctor implements Comparable<Doctor> {

    private String name;
    private int id;

    public Doctor(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id &&
                Objects.equals(name, doctor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Doctor o) {
        return this.getId() - o.getId();
    }
}
