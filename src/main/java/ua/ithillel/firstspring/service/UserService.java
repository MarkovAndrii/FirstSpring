package ua.ithillel.firstspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.firstspring.entity.User;
import ua.ithillel.firstspring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User geById(Integer id) {
        return userRepository.geById(id);
    }

    public User getByEmailAndPhone(String email, Long phone) {
        return userRepository.getByEmailAndPhone(email, phone);
    }

    public User getByFilter(String name, String surname, String email) {
        return userRepository.getByFilter(name, surname, email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        return userRepository.update(id, user);
    }

    public Integer delete(Integer id) {
        return userRepository.delete(id);
    }
}
