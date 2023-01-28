package ua.ithillel.firstspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ithillel.firstspring.controller.CarController;
import ua.ithillel.firstspring.entity.Car;

import java.util.List;

@Component
public class CarBuilder {
    private final CarController carController;

    @Autowired
    public CarBuilder(CarController carController) {
        this.carController = carController;
    }

    public List<Car> getAll() {
        return carController.getAll();
    }
}
