package ua.ithillel.firstspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Long phone;
}

