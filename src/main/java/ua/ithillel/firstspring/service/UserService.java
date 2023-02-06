package ua.ithillel.firstspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.firstspring.entity.User;
import ua.ithillel.firstspring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    //    private final OldUserRepository userRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User geById(Integer id) {    //version_1
        return userRepository.findById(id).orElseThrow();  //method return Optional
    }

//    public Optional<User> geOptionalById(Integer id) {    //version_2
//        return  userRepository.findById(id);
//    }

    public String getEmailById(Integer userId) {
        return userRepository.getEmailById(userId);
    }

    public User getByEmailAndPhone(String email, Long phone) {
        return userRepository.getUserByEmailAndPhone(email, phone);
    }

    public User getUserByNameOrSurnameOrEmail(String name, String surname, String email) {
        return userRepository.getUserByNameOrSurnameOrEmail(name, surname, email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public Integer updateNameById(String name, Integer id) {
        return userRepository.updateNameById(name, id);
    }

    public Integer delete(Integer id) {
        userRepository.deleteById(id);
        return id;
    }
}
