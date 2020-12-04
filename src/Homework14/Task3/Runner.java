package Homework14.Task3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3)Таксопарк. Определить иерархию легковых автомобилей.
 * Создать таксопарк. Подсчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу
 * топлива. Найти автомобиль в компании, соответствующий
 * заданному диапазону параметров скорости.
 */

public class Runner {

    public static void main(String[] args) {

        Car car1 = CarCreator.createCar(180, 5.5, 13000, "VW Polo 2020", CarClass.BASE);
        Car car2 = CarCreator.createCar(200, 5.5, 13000, "VW Polo 2020", CarClass.BASE);
        Car car3 = CarCreator.createCar(250, 5.5, 13000, "VW Polo 2020", CarClass.SPORT);
        Car car4 = CarCreator.createCar(220, 5.5, 13000, "VW Polo 2020", CarClass.COMFORT);
        Car car5 = CarCreator.createCar(150, 5.5, 13000, "VW Polo 2020", CarClass.MINIVAN);
        Car car6 = CarCreator.createCar(190, 5.5, 13000, "VW Polo 2020", CarClass.COMFORT);
    }

    Map<Integer, Car> taxiStation = new HashMap();

}
