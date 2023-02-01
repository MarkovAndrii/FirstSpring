package ua.ithillel.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.firstspring.entity.User;
import ua.ithillel.firstspring.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    @RequestMapping(path = "/all", method = RequestMethod.GET)
    //example query - GET: http://localhost:8080/users
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    //example query - GET: http://localhost:8080/users/1
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.geById(id);
    }

    //example query - GET: http://localhost:8080/users/j007@yahoo.com/144885554733
    @GetMapping("/{email}/{phone}")
    public User getByEmailAndPhone(
            @PathVariable String email,
            @PathVariable Long phone
    ) {
        return userService.getByEmailAndPhone(email, phone);
    }

    //example query - GET: http://localhost:8080/users/filter?name=John&surname=West&email=ant@gmail.com
    @GetMapping("/filter")
    public User getByFilter(
            @RequestParam String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email
    ) {
        return userService.getByFilter(name, surname, email);
    }

    //example query - POST: http://localhost:8080/users
    //    body:
    //    {
    //        "name":"Tom",
    //        "surname":"Wasowsky",
    //        "age":"20",
    //        "email":"tw@mail.uk"
    //    }
    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    //example query - PUT: http://localhost:8080/users/0
    //    body:
    //    {
    //        "name": "Victory",
    //            "surname": "Richardson",
    //            "age": "25",
    //            "email": "vr@mail.uk",
    //            "phone": "11543815777"
    //    }
    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    //example query - DELETE: http://localhost:8080/users?id=2
    @DeleteMapping
    public Integer delete(@RequestParam Integer id){
        return userService.delete(id);
    }
}
