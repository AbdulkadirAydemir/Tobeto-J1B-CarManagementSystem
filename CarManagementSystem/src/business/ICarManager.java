package business;

import entities.Car;
import java.util.List;

public interface ICarManager {

    List<Car> getAllCars();
    Car getCarById(int id);
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int id);
}
