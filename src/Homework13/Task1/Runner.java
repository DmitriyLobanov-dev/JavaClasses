package Homework13.Task1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Сгенерируйте массив, состоящий из 25 случайных элементов. Используя
 * HashMap посчитайте количество вхождений каждого числа, встречающегося в
 * массиве хотя бы однажды, в этот массив. Пример: массив[] = {2,3,4,5,4,7, 5,3},
 * вывод: 2 -> 1, 3 -> 2, 7 -> 1, 4 -> 2, 5 -> 2.
 */

public class Runner {

    public static void main(String[] args) {

        System.out.println("The current array's elements are:" );

        Integer[] intArray = new Integer[25];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = ThreadLocalRandom.current().nextInt(1, intArray.length + 1);
            System.out.print(intArray[i] + " ");
        }
        System.out.println();

        Map<Integer, Integer> map = new HashMap<>();
        for (int el : intArray) {
            Integer counter = 1;
            if (!map.containsKey(el)) {
                map.put(el, counter);
            } else {
                Integer value = map.get(el) + 1;
                map.put(el, value);
            }
        }

        System.out.println("The count of each element is:" );
        map.forEach((key, value) -> System.out.println("Element " + key + " has been found for " + value + " times"));

    }

}
