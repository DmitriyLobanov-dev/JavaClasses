package Homework14.Task3;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static int IDCounter = 0;

    private Integer ID;
    private int speed;
    private double fuelConsumption;
    private int cost;
    private String modelYear;
    private CarClass carClass;

    public Car(int speed, double fuelConsumption, int cost, String modelYear, CarClass carClass) {
        this.ID = IDCounter + 1;
        setSpeed(speed);
        setFuelConsumption(fuelConsumption);
        setCost(cost);
        this.modelYear = modelYear;
        this.carClass = carClass;
        IDCounter++;
    }

    public static int getIDCounter() {
        return IDCounter;
    }

    public Integer getID() {
        return ID;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) throws IllegalArgumentException {
        //добавить выброс эксепшена при отриц. значении
        if (speed <= 0) {
            throw new IllegalArgumentException("Invalid speed value");
        } else {
            this.speed = speed;
        }
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) throws IllegalArgumentException {
        //добавить выброс эксепшена при отриц. значении:
        if (fuelConsumption <= 0) {
            throw new IllegalArgumentException("Invalid fuel consumption value");
        } else {
            this.fuelConsumption = fuelConsumption;
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        //добавить выброс эксепшена при отриц. значении:
        if (cost <= 0) {
            throw new IllegalArgumentException("Invalid cost value");
        } else {
            this.cost = cost;
        }
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                cost == car.cost &&
                modelYear.equals(car.modelYear) &&
                carClass == car.carClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, fuelConsumption, cost, modelYear, carClass);
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID=" + ID +
                ", speed=" + speed +
                ", fuelConsumption=" + fuelConsumption +
                ", cost=" + cost +
                ", modelYear='" + modelYear + '\'' +
                ", carClass=" + carClass +
                '}';
    }


    @Override
    public int compareTo(Car o) {
        //тут будет некрасиво, т.к. compareTo хочет возвращать int
        double result = this.getFuelConsumption() - o.getFuelConsumption();
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
