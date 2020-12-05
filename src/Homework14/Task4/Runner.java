package Homework14.Task4;

/**
 * Напишите метод, находящий максимальное из двух чисел,
 * не используя операторы if-else или любые другие
 * операторы сравнения.
 */

public class Runner {

    public static void main(String[] args) {
        System.out.println(findMax(1, 10));
    }

    public static int findMax (int min, int max) {
        return Integer.max(min, max);
    }
}
