package homework16.task1;

import java.sql.Array;
import java.util.Arrays;



public class Runner {

    public static void main(String[] args) {

        ArrayWrapper<String> wrapper = new ArrayWrapper<>(new String[]{"1", "2", "3", "4"});
        System.out.println(wrapper.get(2));

        ArrayWrapper<Integer> wrapper2 = new ArrayWrapper<>(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(wrapper.get(4));



    }

}
