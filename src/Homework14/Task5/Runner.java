package Homework14.Task5;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Дана упорядоченная последовательность чисел от 1 до N.
 * Из нее удалили одно число, а оставшиеся перемешали.
 * Найти удаленное число за 1 проход по массиву (т.е. ыцикл
 * for используется только 1 раз).
 */

public class Runner {

    public static void main(String[] args) {

        int minValue = 1;
        int maxValue = 25;

        Integer[] arrayValues = new Integer[maxValue];
        for (int i = 0; i < arrayValues.length; i++) {
            arrayValues[i] = i + 1;
        }

        Integer valueToRemove = (int) (Math.random() * (maxValue - minValue)) + minValue;
        List<Integer> listValues = new ArrayList<>(Arrays.asList(arrayValues));
        System.out.println("The original sequence is: " + "\n" + listValues);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("The value to remove is: " + "\n" + valueToRemove);
        System.out.println("---------------------------------------------------------------------------");
        listValues.remove(valueToRemove);
        Collections.shuffle(listValues);
        System.out.println("The shuffled sequence is: " + "\n" + listValues);
        System.out.println("---------------------------------------------------------------------------");

        for (Integer arrayValue : arrayValues) {
            if (!listValues.contains(arrayValue)) {
                System.out.println("The value " + arrayValue + " was deleted from the original sequence");
            }
        }

    }
}

