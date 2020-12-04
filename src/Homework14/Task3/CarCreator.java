package Homework14.Task3;

public class CarCreator {

    public static Car createCar(int speed, double fuelConsumption, int cost, String modelYear, CarClass carClass){
        return new Car(speed, fuelConsumption, cost, modelYear, carClass);
    }

}
