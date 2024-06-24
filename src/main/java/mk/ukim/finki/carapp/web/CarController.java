package mk.ukim.finki.carapp.web;

import mk.ukim.finki.carapp.model.Car;
import mk.ukim.finki.carapp.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    //Test commit
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car.getMake(), car.getModel(), car.getPower(), car.getTopSpeed());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id,
                                         @RequestBody Car car) {
        Car updatedCar = carService.updateCar(id, car.getMake(), car.getModel(), car.getPower(), car.getTopSpeed());
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }
}
