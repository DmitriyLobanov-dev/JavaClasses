package homework16.task1;

import java.sql.Array;
import java.util.Arrays;


public class Runner {

    public static void main(String[] args) {

        //@Test1 STATUS: PASSED
        ArrayWrapper<String> wrapper = new ArrayWrapper<>(new String[]{"1", "2", "3", "4"});
        System.out.println(wrapper.get(2));

        //@Test2 STATUS: PASSED
        ArrayWrapper<Integer> wrapper2 = new ArrayWrapper<>(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(wrapper2.get(4));

        //@Test3 STATUS: PASSED
        User user = new User("first1", "last1");
        ArrayWrapper<User> wrapper3 = new ArrayWrapper<>(new User[]{null, null, user, null});
        System.out.println((wrapper3.get(3)));

        //@Test4(expected = IncorrectArrayWrapperIndex.class) STATUS: PASSED
        ArrayWrapper<Integer> wrapper4 = new ArrayWrapper<>(new Integer[]{1, 2, 3});
        //wrapper4.get(0); //убрать комментарий, чтобы словить эксепшн

        //@Test5(expected = IncorrectArrayWrapperIndex.class) STATUS: PASSED
        ArrayWrapper<Double> wrapper5 = new ArrayWrapper<>(new Double[]{1., 2., 3.});
        //wrapper5.get(-2); //убрать комментарий, чтобы словить эксепшн

        //@Test6(expected = IncorrectArrayWrapperIndex.class) STATUS: PASSED
        ArrayWrapper<String> wrapper6 = new ArrayWrapper<>(new String[]{"1", "2", "3"});
        //wrapper6.get(4); //убрать комментарий, чтобы словить эксепшн

        //@Test7(expected = IncorrectArrayWrapperIndex.class) STATUS: PASSED
        ArrayWrapper<Long> wrapper7 = new ArrayWrapper<>(new Long[]{1L, 2L, 3L});
        //wrapper7.get(10); //убрать комментарий, чтобы словить эксепшн

        //@Test8 Replace. String replaced. STATUS: PASSED
        ArrayWrapper<String> wrapper8 = new ArrayWrapper<>(new String[]{"1", "2", "3"});
        boolean isReplaced = wrapper8.replace(2, "new2");
        System.out.println(isReplaced);
        System.out.println(wrapper8.get(1));
        System.out.println(wrapper8.get(2));
        System.out.println(wrapper8.get(3));

        //@Test9 Replace. Integer replaced. STATUS: PASSED
        ArrayWrapper<Integer> wrapper9 = new ArrayWrapper<>(new Integer[]{1, 2, 3, 4, 5});
        boolean isReplaced2 = wrapper9.replace(2, 9);
        System.out.println(isReplaced2);
        System.out.println(wrapper9.get(1));
        System.out.println(wrapper9.get(2));
        System.out.println(wrapper9.get(3));
        System.out.println(wrapper9.get(4));
        System.out.println(wrapper9.get(5));

        //@Test10 Replace. String not replaced 1. STATUS: PASSED
        ArrayWrapper<String> wrapper10 = new ArrayWrapper<>(new String[]{"string1", "string2", "string3"});
        boolean isReplaced3 = wrapper10.replace(1, "new1");
        System.out.println(isReplaced3);
        System.out.println(wrapper10.get(1));
        System.out.println(wrapper10.get(2));
        System.out.println(wrapper10.get(3));

        //@Test11 Replace. String not replaced 2. STATUS: PASSED
        ArrayWrapper<String> wrapper11 = new ArrayWrapper<>(new String[]{"string1", "string2", "string3"});
        boolean isReplaced4 = wrapper11.replace(2, "string9");
        System.out.println(isReplaced4);
        System.out.println(wrapper11.get(1));
        System.out.println(wrapper11.get(2));
        System.out.println(wrapper11.get(3));

        //@Test12 Replace. Integer not replaced 1. STATUS: PASSED
        ArrayWrapper<Integer> wrapper12 = new ArrayWrapper<>(new Integer[]{2, 3, 4, 5});
        boolean isReplaced5 = wrapper12.replace(3, 1);
        System.out.println(isReplaced5);
        System.out.println(wrapper12.get(1));
        System.out.println(wrapper12.get(2));
        System.out.println(wrapper12.get(3));
        System.out.println(wrapper12.get(4));

        //@Test13 Replace. Integer not replaced 1. STATUS: PASSED
        ArrayWrapper<Integer> wrapper13 = new ArrayWrapper<>(new Integer[]{2, 3, 4});
        boolean isReplaced6 = wrapper13.replace(2, 3);
        System.out.println(isReplaced6);
        System.out.println(wrapper13.get(1));
        System.out.println(wrapper13.get(2));
        System.out.println(wrapper13.get(3));



    }


}
