package hiber.service;

import hiber.model.Car;
import java.util.List;

public interface CarService {
    void saveCar(Car car);
    List<Car> getAllCars();
}