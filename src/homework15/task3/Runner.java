package homework15.task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        NewYearBox<String, Integer, Owner> box1 = new NewYearBox<>(Arrays.asList("ticket to the Hague", "AK magazine", "miracle"), 25, new Owner("Sasha"));
        NewYearBox<Integer, Double, String> box2 = new NewYearBox<>(Arrays.asList(1, 2, 3), 100.0, "Owner");

        System.out.println(box1);
        System.out.println(box2);
    }
}
