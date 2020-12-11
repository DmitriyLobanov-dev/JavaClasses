package homework15.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Напишите параметризованный класс NewYearBox, который содержит
 * List подарков типа Т, цену коробки – P и владельца V. Реализуйте для
 * класса геттеры, сеттеры и toString. Используйте класс в main с
 * разными типами параметров.
 * @param <T>
 */


public final class NewYearBox<T, P, V> {

    private List<T> presents;
    private P boxPrice;
    private V owner;

    public NewYearBox(List<T> presents, P boxPrice, V owner) {
        this.presents = new ArrayList<>(presents);
        this.boxPrice = boxPrice;
        this.owner = owner;
    }

    public List<T> getPresents() {
        return new ArrayList<>(presents);
    }

    public void setPresents(List<T> presents) {
        this.presents = new ArrayList<>(presents);
    }

    public P getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(P boxPrice) {
        this.boxPrice = boxPrice;
    }

    public V getOwner() {
        return owner;
    }

    public void setOwner(V owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewYearBox<?, ?, ?> that = (NewYearBox<?, ?, ?>) o;
        return Objects.equals(presents, that.presents) &&
                Objects.equals(boxPrice, that.boxPrice) &&
                Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(presents, boxPrice, owner);
    }

    @Override
    public String toString() {
        return "NewYearBox{" +
                "presents=" + presents +
                ", boxPrice=" + boxPrice +
                ", owner=" + owner +
                '}';
    }

}
