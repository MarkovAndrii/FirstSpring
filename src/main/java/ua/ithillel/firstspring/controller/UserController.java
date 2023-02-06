package ua.ithillel.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.firstspring.controller.dto.IntegerDto;
import ua.ithillel.firstspring.controller.dto.StringDto;
import ua.ithillel.firstspring.controller.dto.UserDto;
import ua.ithillel.firstspring.controller.mapper.UserMapper;
import ua.ithillel.firstspring.repository.UserRepository;
import ua.ithillel.firstspring.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    //example query - GET: http://localhost:8080/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(
                userService.getAll().stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    //example query - GET: http://localhost:8080/users/1
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userMapper.toDto(userService.geById(id)));
    }

    //example query - GET: http://localhost:8080/email/2
    @GetMapping("/email/{userId}")
    public ResponseEntity<StringDto> getEmailById(@PathVariable Integer userId) {
        return ResponseEntity.ok(new StringDto(userService.getEmailById(userId)));
    }

    //example query - GET: http://localhost:8080/users/jq@gmail.com/142777785467
    @GetMapping("/{email}/{phone}")
    public ResponseEntity<UserDto> getByEmailAndPhone(
            @PathVariable String email,
            @PathVariable Long phone
    ) {
        return ResponseEntity.ok(userMapper.toDto(userService.getByEmailAndPhone(email, phone)));
    }

    //example query - GET: http://localhost:8080/users/filter?name=Nataly&surname=Queen&email=jq@gmail.com
    @GetMapping("/filter")
    public ResponseEntity<UserDto> getByFilter(
            @RequestParam String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(userMapper.toDto(userService.getUserByNameOrSurnameOrEmail(name, surname, email)));
    }

    //example query - POST: http://localhost:8080/users
    //    body:
    //    {
    //            "name": "Jane",
    //            "surname": "Polly",
    //            "age": 23,
    //            "email": "jp@gmail.com",
    //            "phone": 142777785444
    //    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        if (userDto.getName() == null || userDto.getName().isBlank()) {
            return ResponseEntity.badRequest().body(null);
        }
        return new ResponseEntity<>(
                userMapper.toDto(
                        userService.save(
                                userMapper.toEntity(userDto))),
                HttpStatus.CREATED
        );
    }

    //example query - PUT: http://localhost:8080/users
    //    body:
    //    {
    //            "id": 3,
    //            "name": "Victory",
    //            "surname": "Richardson",
    //            "age": "25",
    //            "email": "vr@mail.uk",
    //            "phone": "11543815777"
    //    }
    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                userMapper.toDto(
                        userService.update(userMapper.toEntity(userDto))),
                HttpStatus.ACCEPTED
        );
    }

    //example query - PUT: http://localhost:8080/users/3/Mick
    @PutMapping("/{id}/{name}")
    public ResponseEntity<IntegerDto> updateNameById(
            @PathVariable Integer id,
            @PathVariable String name
    ) {
        if (userRepository.existsById(id)) {
            return ResponseEntity.ok(new IntegerDto(userService.updateNameById(name, id)));
        }
        return ResponseEntity.badRequest().body(null);
    }


    //example query - DELETE: http://localhost:8080/users?id=1
    @DeleteMapping
    public ResponseEntity<IntegerDto> delete(@RequestParam Integer id) {
        return ResponseEntity.ok(new IntegerDto(userService.delete(id)));
    }
}
