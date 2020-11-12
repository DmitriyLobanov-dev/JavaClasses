package Homework12;

import java.sql.Array;
import java.util.*;

/**
 * 1. а) Создать коллекцию, содержащую объекты класса HeavyBox.
 * б) Раcпечатать его содержимое используя for each.
 * в) Изменить вес первого ящика на 1.
 * г) Удалить последний ящик.
 * д) Получить массив содержащий ящики из коллекции двумя способами и вывести на консоль.
 * е) Удалить все ящики.
 * 2. Получить массив содержащий объекты класса HeavyBox из коллекции тремя способами и
 * вывести на консоль.
 * 3. Создать очередь, содержащую объекты класса HeavyBox. Используем класс ArrayDeque.
 * Поместить объекты в очередь с помощью метода offer(). Удалить объекты методом poll().
 * 4. Создать коллекцию, содержащую объекты HeavyBox. Написать метод, который перебирает
 * элементы коллекции и проверяет вес коробок. Если вес коробки больше 300 гр, коробка
 * перемещается в другую коллекцию.
 */

public class Runner {

    public static void main(String[] args) {

        //Создать коллекцию, содержащую объекты класса HeavyBox.
        List<HeavyBox> boxList = new ArrayList<HeavyBox>(9) {{
            add(HeavyBoxCreator.createHeavyBox(125, 12.5, BoxMaterial.CARDBOARD));
            add(HeavyBoxCreator.createHeavyBox(141, 14, BoxMaterial.CARDBOARD));
            add(HeavyBoxCreator.createHeavyBox(213, 20, BoxMaterial.CARDBOARD));
            add(HeavyBoxCreator.createHeavyBox(790, 12.5, BoxMaterial.WOOD));
            add(HeavyBoxCreator.createHeavyBox(950, 14, BoxMaterial.WOOD));
            add(HeavyBoxCreator.createHeavyBox(1027, 20, BoxMaterial.WOOD));
            add(HeavyBoxCreator.createHeavyBox(2700, 12.5, BoxMaterial.METAL));
            add(HeavyBoxCreator.createHeavyBox(3430, 14, BoxMaterial.METAL));
            add(HeavyBoxCreator.createHeavyBox(4096, 20, BoxMaterial.METAL));
        }};

        //Распечатать содержимое используя for each
        System.out.println("Printing collection content:");
        for (HeavyBox el : boxList) {
            if (el != null) {
                System.out.println(el);
            }
        }

        System.out.println("\n");

        //Изменить вес первого ящика на 1
        if (boxList.get(0) != null) {
            boxList.get(0).setWeight(1);
        }
        System.out.println("Printing 1st:");
        System.out.println(boxList.get(0));

        System.out.println("\n");

        //Удалить последний ящик.
        if (boxList.get(boxList.size() - 1) != null) {
            boxList.remove(boxList.size() - 1);
        }
        System.out.println("New collection size is: " + boxList.size());
        System.out.println("Printing changed collection content:");
        for (HeavyBox el : boxList) {
            if (el != null) {
                System.out.println(el);
            }
        }

        System.out.println("\n");

        //Получить массив содержащий ящики из коллекции двумя способами и вывести на консоль.
        // Задание можно объединить с пунктом 2 - Получить массив содержащий объекты класса HeavyBox из коллекции тремя способами и вывести на консоль.
        /**
         * HeavyBox[] exampleArray1 = (HeavyBox[]) boxList.toArray();
        почему это не рабоатет???? Exception in thread "main" java.lang.ClassCastException
         */

        HeavyBox[] exampleArray1 = new HeavyBox[boxList.size()];
        for (int i = 0; i < boxList.size(); i++) {
            if (boxList.get(i) != null) {
                exampleArray1[i] = boxList.get(i);
            }
        }
        System.out.println("Printing exampleArray1 content:");
        for (Object el : exampleArray1) {
            if (el != null) {
                System.out.println(el);
            }
        }
        System.out.println();

        HeavyBox[] exampleArray2 = new HeavyBox[boxList.size()];
        Iterator boxListIterator = boxList.iterator();
        int i = 0;
        while (boxListIterator.hasNext()) {
            HeavyBox next = (HeavyBox) boxListIterator.next();
            if (next != null) {
                exampleArray2[i] = next;
            }
            i++;
        }
        System.out.println("Printing exampleArray2 content:");
        for (Object el : exampleArray2) {
            if (el != null) {
                System.out.println(el);
            }
        }
        System.out.println();

        HeavyBox[] exampleArray3 = Arrays.copyOf(exampleArray1, boxList.size());
        System.out.println("Printing exampleArray3 content:");
        for (Object el : exampleArray3) {
            if (el != null) {
                System.out.println(el);
            }
        }

        System.out.println("\n");

        //Удалить все ящики
        boxList.removeAll(boxList);
        System.out.println("The collection \"boxList\" was cleared. It's current size is: " + boxList.size());

        System.out.println("\n");

        //Создать очередь, содержащую объекты класса HeavyBox. Используем класс ArrayDeque.
        // * Поместить объекты в очередь с помощью метода offer(). Удалить объекты методом poll()
        Deque<HeavyBox> boxQueue = new ArrayDeque();
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(125, 12.5, BoxMaterial.CARDBOARD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(141, 14, BoxMaterial.CARDBOARD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(213, 20, BoxMaterial.CARDBOARD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(790, 12.5, BoxMaterial.WOOD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(950, 14, BoxMaterial.WOOD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(1027, 20, BoxMaterial.WOOD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(2700, 12.5, BoxMaterial.METAL));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(3430, 14, BoxMaterial.METAL));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(4096, 20, BoxMaterial.METAL));

        while (!boxQueue.isEmpty()) {
            System.out.println(boxQueue.poll());
        }

        System.out.println("\n");

        //Создать коллекцию, содержащую объекты HeavyBox. Написать метод, который перебирает
        // * элементы коллекции и проверяет вес коробок. Если вес коробки больше 300 гр, коробка
        // * перемещается в другую коллекцию.

        boxQueue.offer(HeavyBoxCreator.createHeavyBox(125, 12.5, BoxMaterial.CARDBOARD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(141, 14, BoxMaterial.CARDBOARD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(213, 20, BoxMaterial.CARDBOARD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(790, 12.5, BoxMaterial.WOOD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(950, 14, BoxMaterial.WOOD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(1027, 20, BoxMaterial.WOOD));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(2700, 12.5, BoxMaterial.METAL));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(3430, 14, BoxMaterial.METAL));
        boxQueue.offer(HeavyBoxCreator.createHeavyBox(4096, 20, BoxMaterial.METAL));

        Collection<HeavyBox> superHeavyBoxesList = findSuperHeavyBoxes(boxQueue);
        System.out.println("Printing the collection with box weight over 300 grams:");
        for (HeavyBox el : superHeavyBoxesList) {
            System.out.println(el);
        }


    }

    public static Collection<HeavyBox> findSuperHeavyBoxes(Collection<HeavyBox> list) {
        List<HeavyBox> superHeavyBoxesList = new ArrayList<HeavyBox>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            HeavyBox next = (HeavyBox) iterator.next();
            if (next.getWeight() > 300) {
                superHeavyBoxesList.add(next);
            }
        }
        return superHeavyBoxesList;
    }

}
