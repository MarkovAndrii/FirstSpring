package ua.ithillel.firstspring.controller.mapper;

import org.springframework.stereotype.Component;
import ua.ithillel.firstspring.controller.dto.UserDto;
import ua.ithillel.firstspring.entity.User;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAge(),
                userDto.getEmail(),
                userDto.getPhone()
        );
    }
}
