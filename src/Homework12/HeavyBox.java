package Homework12;

import java.util.Objects;

public class HeavyBox {

    private int weight; //gram
    private double capacity; //litres
    private BoxMaterial material; //Enum - CARDBOARD, WOOD, METAL

    public HeavyBox(int weight, double capacity, BoxMaterial material) {
        this.weight = weight;
        this.capacity = capacity;
        this.material = material;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public BoxMaterial getMaterial() {
        return material;
    }

    public void setMaterial(BoxMaterial material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeavyBox heavyBox = (HeavyBox) o;
        return weight == heavyBox.weight &&
                Double.compare(heavyBox.capacity, capacity) == 0 &&
                Objects.equals(material, heavyBox.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, capacity, material);
    }

    @Override
    public String toString() {
        return "HeavyBox{" +
                "weight=" + weight +
                ", capacity=" + capacity +
                ", material='" + material + '\'' +
                '}';
    }
}
