package mk.ukim.finki.carapp.web;

import mk.ukim.finki.carapp.model.Car;
import mk.ukim.finki.carapp.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return this.carService.createCar(car.getMake(), car.getModel(), car.getPower(), car.getTopSpeed());
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id,
                         @RequestBody Car car) {
        return carService.updateCar(id, car.getMake(), car.getModel(), car.getPower(), car.getTopSpeed());
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }
}
