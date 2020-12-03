package Homework13.Tasks5;

/**
 * Даны две переменные - a и b. Например, они равны a=2; b=3. Необходимо
 * поменять местами эти числа (то есть a=3, b=2). Но не используя третью
 * переменную.
 */

public class Runner {

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);
    }
}
