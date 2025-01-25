package project.springboot.dao;


import project.springboot.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    List<User> readAllUser();

    User readUserById(Long id);

    void updateUser(User user);

    void deleteUserById(Long id);

}