package Dao;

import Model.User;

import java.util.List;

public interface StorageDao {

    int removeAll();

    int removeUser(int id);

    int removeUserByName(String name);

    void insertUser(User user);

    int updateUser(User user);

    User getUser(int id);

    List<User> getAllUsers();


}
