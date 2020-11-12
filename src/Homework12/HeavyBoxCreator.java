package Homework12;

public abstract class HeavyBoxCreator {

    public static HeavyBox createHeavyBox(int weight, double capacity, BoxMaterial material) {
        if (weight < 0) {
            weight = 0;
        }
        if (capacity < 0) {
            capacity = 0;
        }
        return new HeavyBox(weight, capacity, material);
    }
}
