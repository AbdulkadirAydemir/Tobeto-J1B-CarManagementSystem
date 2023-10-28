package dataAccess;

import entities.Car;
import java.util.List;

public interface ICarDao {

    List<Car> getAll();
    Car getById(int id);
    void add(Car car);
    void update(Car car);
    void delete(int id);
}
