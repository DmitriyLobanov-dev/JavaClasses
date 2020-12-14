package Homework14.Task3;

import java.util.*;

/**
 * 3)Таксопарк. Определить иерархию легковых автомобилей.
 * Создать таксопарк. Подсчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу
 * топлива. Найти автомобиль в компании, соответствующий
 * заданному диапазону параметров скорости.
 */

public class Runner {

    public static void main(String[] args) {

        Car car1 = CarCreator.createCar(180, 5.5, 13000, "Kia Rio 2019", CarClass.BASE);
        Car car2 = CarCreator.createCar(200, 5.2, 13000, "VW Polo 2020", CarClass.BASE);
        Car car3 = CarCreator.createCar(250, 9, 32000, "Kia Stinger 2021", CarClass.SPORT);
        Car car4 = CarCreator.createCar(220, 8.4, 45000, "BMW 5 2020", CarClass.COMFORT);
        Car car5 = CarCreator.createCar(150, 12, 23000, "VW Transporter 2020", CarClass.MINIVAN);
        Car car6 = CarCreator.createCar(190, 8, 13000, "Škoda Superb 2020", CarClass.COMFORT);

        Map<Integer, Car> taxiStation = new HashMap<>();
        taxiStation.put(car1.getID(), car1);
        taxiStation.put(car2.getID(), car2);
        taxiStation.put(car3.getID(), car3);
        taxiStation.put(car4.getID(), car4);
        taxiStation.put(car5.getID(), car5);
        taxiStation.put(car6.getID(), car6);

        System.out.println("-----------------------------------------------------------------------------------");
        //Подсчитать стоимость автопарка.
        int totalcost = 0;
        for (Map.Entry entry : taxiStation.entrySet()) {
            totalcost += taxiStation.get(entry.getKey()).getCost();
        }
        System.out.println("The total cost of all cars of the taxi station is: " + totalcost + "$");
        System.out.println("-----------------------------------------------------------------------------------");

        //Провести сортировку автомобилей парка по расходу топлива.
        List carsSorted = new ArrayList();
        for (Map.Entry entry : taxiStation.entrySet()) {
            carsSorted.add(entry.getValue());
        }
        System.out.println(carsSorted);
        Collections.sort(carsSorted);
        System.out.println(carsSorted);

        System.out.println("-----------------------------------------------------------------------------------");
        //Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости
        int speedFilterMin = 190;
        int speedFilterMax = 240;
        for (Map.Entry entry : taxiStation.entrySet()) {
            int carSpeed = taxiStation.get(entry.getKey()).getSpeed();
            if (carSpeed >= speedFilterMin && carSpeed <= speedFilterMax) {
                System.out.println(entry);
            }
        }
    }
}
