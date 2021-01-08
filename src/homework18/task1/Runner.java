package homework18.task1;

/**
 * Создать класс NewThread расширяющий Thread. Переопределить метод run(). В цикле for
 * вывести на консоль символ 100 раз. Создать экземпляр класса и запустить новый поток.
 */

public class Runner {

    public static void main(String[] args) {

        Thread thread1 = new NewThread();
        thread1.start();

    }

}
