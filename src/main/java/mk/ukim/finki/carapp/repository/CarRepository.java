package mk.ukim.finki.carapp.repository;

import mk.ukim.finki.carapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
