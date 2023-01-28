package ua.ithillel.firstspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@Component
public class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
}
