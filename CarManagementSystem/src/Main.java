import business.CarManager;
import dataAccess.ICarDao;
import dataAccess.CarDao;
import entities.Car;

public class Main {
    public static void main(String[] args) {

        ICarDao carDao = (ICarDao) new CarDao();
        CarManager carManager = new CarManager();

        try {
            Car newCar = new Car(1, "Toyota", "Corolla", 2020);
            carManager.addCar(newCar);

            System.out.println("Car added successfully. ID: " + newCar.getId());

            Car retrievedCar = carManager.getCarById(newCar.getId());
            System.out.println("Retrieved Car: " + retrievedCar.getBrand() + " " + retrievedCar.getModel());

            retrievedCar.setModel("Civic");
            carManager.updateCar(retrievedCar);

            System.out.println("Car updated. New Model: " + retrievedCar.getModel());

            carManager.deleteCar(retrievedCar.getId());
            System.out.println("Car deleted.");

            // Listing all cars
            for (Car car : carManager.getAllCars()) {
                System.out.println(car.getBrand() + " " + car.getModel() + " (" + car.getYear() + ")");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}