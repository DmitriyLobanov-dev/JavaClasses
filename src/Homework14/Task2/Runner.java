package Homework14.Task2;

import java.util.*;

/**
 * Пункт назначения, Номер поезда, Время отправления,
 * Число мест (общих, купе, плацкарт, люкс).
 * Создать список объектов. Вывести:
 * a) список поездов, следующих до заданного пункта
 * назначения;
 * b) список поездов, следующих до заданного пункта
 * назначения и отправляющихся после заданного часа;
 * c) список поездов, отправляющихся из одного пункта
 * назначения в другой.
 */

public class Runner {

    public static void main(String[] args) {

        DepartureTime timeToSearchAfter;
        String destinationToFilter;
        String pointOfDepartureToFilter;


        Train tr1 = new Train(1,new DepartureTime(18,50), 500, "CutieLand", "DudeLand");
        Train tr2 = new Train(2,new DepartureTime(13,45), 450, "CutieLand", "DudeLand");
        Train tr3 = new Train(2,new DepartureTime(17,30), 490, "DudeLand", "AwesomeLand");
        Train tr4 = new Train(2,new DepartureTime(19,10), 300, "DudeLand", "AwesomeLand");

        Set<Train> sourceTrainList = new HashSet<>();
        sourceTrainList.add(tr1);
        sourceTrainList.add(tr2);
        sourceTrainList.add(tr3);
        sourceTrainList.add(tr4);

        Set<Train> filteredTrainList = new HashSet<>();

        System.out.println("------------------------------------------------------------------------");

        // вывести список поездов, следующих до заданного пункта назначения
        destinationToFilter = "CutieLand";
        for (Train el : sourceTrainList) {
            if (el.getDestination().equals(destinationToFilter)) {
                filteredTrainList.add(el);
            }
        }

        System.out.println("The trains depart to " + destinationToFilter + " are: " + "\n" + filteredTrainList);

        filteredTrainList.clear();
        System.out.println("________________________________________________________________________");

        // вывести список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа
        destinationToFilter = "CutieLand";
        timeToSearchAfter = new DepartureTime(15, 50);
        for (Train el : sourceTrainList) {
            if (el.getDestination().equals(destinationToFilter) && el.getDepartureTime().compareTo(timeToSearchAfter) <= 0) {
                filteredTrainList.add(el);
            }
        }

        System.out.println("The trains depart to " + destinationToFilter + " after " + timeToSearchAfter.getHours() + ":" +
                timeToSearchAfter.getMinutes() + " are: " + "\n" + filteredTrainList);

        filteredTrainList.clear();
        System.out.println("________________________________________________________________________");


        // вывести список поездов, отправляющихся из одного пункта назначения в другой
        destinationToFilter = "DudeLand";
        pointOfDepartureToFilter = "AwesomeLand";

        for (Train el: sourceTrainList) {
            if (el.getDestination().equals(destinationToFilter) && el.getPointOfDeparture().equals(pointOfDepartureToFilter)) {
                filteredTrainList.add(el);
            }
        }

        System.out.println("The trains depart from" + pointOfDepartureToFilter + " to " + destinationToFilter  + " are: " + "\n" + filteredTrainList);

        filteredTrainList.clear();
        System.out.println("________________________________________________________________________");

    }

}
