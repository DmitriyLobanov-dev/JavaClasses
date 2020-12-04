package Homework14.Task2;

import java.sql.Time;
import java.util.Objects;

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

public class Train {

    private int trainID;
    private DepartureTime departureTime;
    private int capacity;
    private String destination;
    private String pointOfDeparture;

    public Train(int trainID, DepartureTime departureTime, int capacity, String destination, String pointOfDeparture) {
        this.trainID = trainID;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.destination = destination;
        this.pointOfDeparture = pointOfDeparture;
    }

    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }

    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DepartureTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPointOfDeparture() {
        return pointOfDeparture;
    }

    public void setPointOfDeparture(String pointOfDeparture) {
        this.pointOfDeparture = pointOfDeparture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainID == train.trainID &&
                capacity == train.capacity &&
                Objects.equals(departureTime, train.departureTime) &&
                Objects.equals(destination, train.destination) &&
                Objects.equals(pointOfDeparture, train.pointOfDeparture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainID, departureTime, capacity, destination, pointOfDeparture);
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainID=" + trainID +
                ", departureTime=" + departureTime +
                ", capacity=" + capacity +
                ", destination='" + destination + '\'' +
                ", pointOfDeparture='" + pointOfDeparture + '\'' +
                '}';
    }
}
