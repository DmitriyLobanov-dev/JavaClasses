package homework16.task1;

/**
 * Необходимо реализовать класс-обертку над массивом ArrayWrapper,
 * который может хранить массив любого типа данных. Индексация
 * элементов этим классов ведется от 1.
 * Определить один конструктор, в который передается массив любого типа.
 * Определить метод получения элемента по индексу (пример: get(2)) (счет
 * ведется от 1, а не от 0).
 * Определить метод замены элемента по определенному индексу (пример:
 * replace(1, “Test”)). Реализовать следующие ограничения:
 * Для String: заменить строку можно только на строку большей длины
 * Для Integer: заменить число можно только на большее по значению
 * Метод replace должен возвращать boolean значение успешности замены.
 * Реализовать класс-исключение throw new IncorrectArrayWrapperIndex
 * (unchecked), которое выбрасывается при выходе за границы.
 * Используйте Generics.
 * Пример см. Тесты.
 */

public class ArrayWrapper<T> {

    private T[] anyArray;

    public ArrayWrapper(T[] anyArray) {
        this.anyArray = anyArray;
    }

    public T[] getAnyArray() {
        return anyArray;
    }

    //Определить метод получения элемента по индексу (счет ведется от 1, а не от 0).
    public T get(int indexValue) throws IncorrectArrayWrapperIndexException {
        if (indexValue <= 0 || indexValue >= this.anyArray.length + 1) {
            throw new IncorrectArrayWrapperIndexException("Incorrect element index, must be >=1 & <= array.length");
        }
        return this.anyArray[indexValue - 1];
    }

    //Определить метод замены элемента по определенному индексу (пример: replace(1, “Test”)). Метод replace должен возвращать boolean значение успешности замены.
    public boolean replace(int indexValue, T value) {
        boolean result;
        if (indexValue <= 0 || indexValue >= this.anyArray.length + 1) {
            throw new IncorrectArrayWrapperIndexException("Incorrect element index, should be >=1 & <= array.length");
        }
        //String. Заменить строку можно только на строку большей длины
        if (value instanceof String) {
            result = false;
            String origStr = (String) get(indexValue);
            String replStr = (String) value;
            if (origStr.length() < replStr.length()) {
                this.anyArray[indexValue - 1] = value;
                result = true;
            } else {
                System.out.println("Replace has failed. New String length must be bigger than original");
            }
            //Integer. Заменить число  можно только на большее по значению
        } else if (value instanceof Integer) {
            result = false;
            Integer origInt = (Integer) this.anyArray[indexValue - 1];
            Integer replInt = (Integer) value;
            if (origInt < replInt) {
                this.anyArray[indexValue - 1] = value;
                result = true;
            } else {
                System.out.println("Replace has failed. New Integer must be bigger than original");
            }
            //для элементов массива других типов
        } else {
            this.anyArray[indexValue - 1] = value;
            result = true;
        }
        return result;
    }
}
