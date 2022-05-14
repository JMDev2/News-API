package interfaces;

import models.User;

import java.util.List;

public interface UserDao {
//    CREATE
    void addUser(User user);

//    READ
    List<User> getAllUsers();
    User getUsersById(int id);

//        SPECIFUSER
    User findById(int id);


//    UPDATE
//    DELETE
    void deleteUser(int id);


}
