package homework16.homework14_task5_v2;

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

        //исходный вариант решения, не выполняется требование "без использования метода contains"
        for (Integer arrayValue : arrayValues) {
            if (!listValues.contains(arrayValue)) {
                System.out.println("The value " + arrayValue + " was deleted from the original sequence");
            }
        }

        //второй вариант решения, но не выполняется требование "без коллекций"
        for (Integer arrayValue : arrayValues) {
            if (Collections.frequency(listValues, arrayValue) == 0) {
                System.out.println("The value " + arrayValue + " was deleted from the original sequence");
            }
        }

        //третий вариант решения. Все объекты созданы заново, коллекции, созданные выше для 1 и 2 варианта не участвуют.
        int[] arrayOriginal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrayCutShuffled = {2, 4, 8, 10, 1, 3, 5, 7, 9}; //удалили цифру 6 и перемешали
        int sumOriginal = 0;
        int sumCut = 0;
        for (int i = 0; i < arrayOriginal.length; i++) {
            sumOriginal += arrayOriginal[i]; //сумма чисел исходного массива
            if (i < arrayCutShuffled.length) {
                sumCut += arrayCutShuffled[i]; //сумма чисел второго массива
            }
        }
        int result = sumOriginal - sumCut; //разница сумм - искомое удаленное число
        System.out.println("The value " + result + " was deleted from the original sequence");

    }
}

