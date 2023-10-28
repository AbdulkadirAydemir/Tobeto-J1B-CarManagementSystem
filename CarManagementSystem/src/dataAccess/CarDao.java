package dataAccess;

import entities.Car;
import java.util.ArrayList;
import java.util.List;

public class CarDao implements ICarDao {

    private final List<Car> cars;

    public CarDao() {
        cars = new ArrayList<>();
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public Car getById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public void update(Car car) {
        for (Car existingCar : cars) {
            if (existingCar.getId() == car.getId()) {
                existingCar.setBrand(car.getBrand());
                existingCar.setModel(car.getModel());
                existingCar.setYear(car.getYear());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        Car carToDelete = null;
        for (Car car : cars) {
            if (car.getId() == id) {
                carToDelete = car;
                break;
            }
        }
        if (carToDelete != null) {
            cars.remove(carToDelete);
        }
    }
}
