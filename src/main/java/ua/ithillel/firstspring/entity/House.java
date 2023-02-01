package ua.ithillel.firstspring.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class House {
    private String address;
    private Integer numberOfFloors;
}
