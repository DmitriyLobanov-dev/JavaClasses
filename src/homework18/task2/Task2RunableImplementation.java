package homework18.task2;

/**
 * Создать класс, реализующий интерфейс Runnable. Переопределить run() метод. Создать
 * цикл for. В цикле распечатываем значения от 0 до 100 делящиеся на 10 без остатка.
 * Используем статический метод Thread.sleep() чтобы сделать паузу. Создать три потока,
 * выполняющих задачу распечатки значений.
 */

public class Task2RunableImplementation implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 10 == 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }
}
