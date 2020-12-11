package homework15.task2;

public class Runner {

    public static void main(String[] args) {
        Integer[] array = {2, 5, 6, 7, 8, 9, 3, 5, 6, 8, 8};
        MinMax<Integer> values = new MinMax<>(array);

        System.out.println(values.minValue());
        System.out.println(values.maxValue());

    }
}
