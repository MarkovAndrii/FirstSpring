package ua.ithillel.firstspring.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.ithillel.firstspring.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User(0, "Antony", "Stone", 35, "ant@gmail.com", 114545789055L));
        users.add(new User(1, "Kate", "West", 35, "kate@mail.uk", 123777789168L));
        users.add(new User(2, "John", "Webb", 27, "j007@yahoo.com", 144885554733L));
    }

    public List<User> getAll() {
        return users;
    }

    public User geById(Integer id) {
        return users.get(id);
    }

    public User getByEmailAndPhone(String email, Long phone) {
        for (User user : users) {
            if (user.getEmail().equals(email) & user.getPhone().equals(phone)) {
                return user;
            }
        }
        return null;
    }

    public User getByFilter(String name, String surname, String email) {
        for (User user : users) {
            if (user.getName().equals(name) || user.getSurname().equals(surname) || user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        users.add(user);
        user.setId(users.size()-1);
        return user;
    }

    public User update(Integer id, User user) {
        User changeUser = users.get(id);
        changeUser.setName(user.getName());
        changeUser.setSurname(user.getSurname());
        changeUser.setAge(user.getAge());
        changeUser.setEmail(user.getEmail());
        changeUser.setPhone(user.getPhone());
        return users.get(id);
    }

    public Integer delete(int id) {
        users.remove(id);
        return id;
    }
}
