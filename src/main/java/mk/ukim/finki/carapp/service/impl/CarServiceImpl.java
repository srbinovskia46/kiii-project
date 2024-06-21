package mk.ukim.finki.carapp.service.impl;

import mk.ukim.finki.carapp.model.Car;
import mk.ukim.finki.carapp.model.exceptions.NoCarFoundException;
import mk.ukim.finki.carapp.repository.CarRepository;
import mk.ukim.finki.carapp.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    @Override
    public Car createCar(String make, String model, int power, int topSpeed) {
        Car car = new Car(make, model, power, topSpeed);
        return this.carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        Car car = this.carRepository.findById(id).orElseThrow(NoCarFoundException::new);
        return car;
    }

    @Override
    public Car updateCar(Long id, String make, String model, int power, int topSpeed) {
        Car car = this.carRepository.findById(id).orElseThrow(NoCarFoundException::new);
        car.setMake(make);
        car.setModel(model);
        car.setPower(power);
        car.setTopSpeed(topSpeed);
        return this.carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        this.carRepository.deleteById(id);
    }
}
