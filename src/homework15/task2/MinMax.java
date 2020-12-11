package homework15.task2;

import java.sql.Array;
import java.util.*;

/**
 * Написать обобщенный класс MinMax, который содержит методы для
 * нахождения минимального и максимального элемента массива.
 * Элементы в массиве могут быть разного типа (integer,double,long).
 * Массив является переменной класса. Массив должен передаваться в
 * класс через конструктор.
 */

public final class MinMax<T extends Comparable<T>> {

    private final T[] valuesArray;

    public MinMax(T[] valuesArray) {
        this.valuesArray = valuesArray;
    }

    public T minValue() {
        List<T> list = new ArrayList<>(Arrays.asList(valuesArray));
        T min = list.get(0);
        for (T el : list) {
            if (el.compareTo(min) < 0) {
                min = el;
            }
        }
        return min;
    }

    public T maxValue() {
        List<T> list = new ArrayList<>(Arrays.asList(valuesArray));
        T max = list.get(0);
        for (T el : list) {
            if (el.compareTo(max) > 0) {
                max = el;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "valuesArray=" + Arrays.toString(valuesArray) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinMax<?> minMax = (MinMax<?>) o;
        return Arrays.equals(valuesArray, minMax.valuesArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(valuesArray);
    }
}
