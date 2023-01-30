package ua.ithillel.firstspring.repository;

import org.springframework.stereotype.Repository;
import ua.ithillel.firstspring.entity.Car;

import java.util.List;

@Repository
public class CarRepository {

    public List<Car> getAll() {
        return List.of(
                new Car("Toyota", "Camry", 2020),
                new Car("Honda", "Accord", 2021),
                new Car("Nissan", "Maxima", 2016)
        );
    }
}
