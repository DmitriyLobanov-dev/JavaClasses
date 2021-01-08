package homework18.task3;

import java.util.List;
import java.util.Objects;

/**
 * В текстовом файле лежат данные о покупателях и их покупках (в любом удобном формате).
 * Создать классы Клиент (покупатель) и Покупка. Создать класс ClientRepository, в котором
 * разместить методы для работы с файлом: добавить нового покупателя со списком покупок, по
 * id покупателя найти список его покупок, по email найти покупателя (учитывать то, что
 * покупателя с нужным id или email может не быть, использовать Optional для возвращаемых
 * значений методов). Написать класс main с использованием методов класса ClientRepository.
 */

public class Customer {

    private final long ID;
    private String name;
    private String email;
    private List<Purchase> shopList;

    public Customer(long ID, String name, String email, List<Purchase> shopList) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.shopList = shopList;
    }

    public Customer(long ID, String name, String email) {
        this.ID = ID;
        this.name = name;
        this.email = email;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getShopList() {
        return shopList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(ID, customer.ID) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID='" + ID + '\'' +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", shopList=" + shopList +
                '}';
    }
}
