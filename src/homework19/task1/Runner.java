package homework19.task1;

/**
 * Необходимо создать три потока, которые изменяют один и тот же объект. Каждый поток
 * должен вывести на экран одну букву 100 раз, и затем увеличить значение символа на 1.
 * a) Создать класс расширяющий Thread.
 * б) Переопределить метод run() - здесь будет находиться синхронизированный блок кода.
 * в) Для того чтобы три объекта потока имели доступ к одному объекту, создаем конструктор
 * принимающий на вход StringBuilder объект.
 * г) Синхронизированный блок кода будет получать монитор на объект StringBuilder из пункта
 * в).
 * д) Внутри синхронизированного блока кода выведите StringBuilder на экран 100 раз, а потом
 * увеличьте значение символа на 1.
 * е) В методе main() создайте один объект класса StringBuilder, используя символ ‘a’. Затем
 * создайте три экземпляра объекта нашего класса и запустите потоки.
 */

public class Runner {

    public static void main(String[] args) {

        StringBuilder a = new StringBuilder("a");

        Thread thread1 = new CharIncThread(a);
        Thread thread2 = new CharIncThread(a);
        Thread thread3 = new CharIncThread(a);

        thread1.start();
        thread2.start();
        thread3.start();

    }

}
