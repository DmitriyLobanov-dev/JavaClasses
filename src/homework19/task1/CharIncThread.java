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

public class CharIncThread extends Thread {

    StringBuilder str;

    public CharIncThread(StringBuilder str) {
        this.str = str;
    }

    @Override
    public void run() {
        synchronized (str) {
            char ch = str.substring(0, 1).charAt(0);
            for (int i = 0; i < 100; i++) {
                System.out.print(str);
            }
            System.out.println();
            ch += 1;
            str.replace(0, 1, String.valueOf(ch));
        }
    }
}
