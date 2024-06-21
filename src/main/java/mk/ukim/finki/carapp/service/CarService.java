package mk.ukim.finki.carapp.service;

import mk.ukim.finki.carapp.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car createCar(String make, String model, int power, int topSpeed);
    Car getCarById(Long id);
    Car updateCar(Long id, String make, String model, int power, int topSpeed);
    void deleteCarById(Long id);
}
