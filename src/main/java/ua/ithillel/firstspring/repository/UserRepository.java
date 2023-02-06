package ua.ithillel.firstspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.ithillel.firstspring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    Integer updateNameById(String name, Integer id);

    User getUserByEmailAndPhone(String email, Long phone);

    @Query("select u.email from User u where u.id =?1")
    String getEmailById(Integer userId);

    User getUserByNameOrSurnameOrEmail(String name, String surname, String email);
}
