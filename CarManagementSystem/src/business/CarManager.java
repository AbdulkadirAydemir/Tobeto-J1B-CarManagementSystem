package business;

import dataAccess.CarDao;
import dataAccess.ICarDao;
import entities.Car;

import java.util.List;

public class CarManager implements ICarManager{

    private ICarDao carDao;

    public CarManager() {
        this.carDao = (ICarDao) new CarDao();
    }

    @Override
    public void addCar(Car car) {
        if (car.getYear() > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("Cars from future years cannot be added.");
        }
        carDao.add(car);
    }

    @Override
    public void deleteCar(int id) {
        carDao.delete(id);
    }

    @Override
    public Car getCarById(int id) {
        return carDao.getById(id);
    }

    @Override
    public void updateCar(Car car) {
        carDao.update(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAll();
    }
}
