package ua.ithillel.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.ithillel.firstspring.entity.Car;
import ua.ithillel.firstspring.service.CarService;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    public List<Car> getAll() {
        return carService.getAll();
    }
}
