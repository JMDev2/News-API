package Dao;

import models.User;

import java.util.List;

public interface UserDao {
//    CREATE
    void addUser(User user);

//    READ
    List<User> getAllUsers();
    User getUsersById(int id);

//    UPDATE
//    DELETE
    void deleteUser(int id);


}
