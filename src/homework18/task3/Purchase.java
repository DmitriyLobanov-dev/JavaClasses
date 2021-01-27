package homework18.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * В текстовом файле лежат данные о покупателях и их покупках (в любом удобном формате).
 * Создать классы Клиент (покупатель) и Покупка. Создать класс ClientRepository, в котором
 * разместить методы для работы с файлом: добавить нового покупателя со списком покупок, по
 * id покупателя найти список его покупок, по email найти покупателя (учитывать то, что
 * покупателя с нужным id или email может не быть, использовать Optional для возвращаемых
 * значений методов). Написать класс main с использованием методов класса ClientRepository.
 */

public class Purchase {

    Logger log = LoggerFactory.getLogger(Purchase.class.getName());

    private String title;

    public Purchase(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(title, purchase.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
