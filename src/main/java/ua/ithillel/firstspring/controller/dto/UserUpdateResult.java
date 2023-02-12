package ua.ithillel.firstspring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateResult {
    private Integer id;
    private String error;

    public UserUpdateResult(Integer id) {
        this.id = id;
    }

    public UserUpdateResult(String error) {
        this.error = error;
    }
}
