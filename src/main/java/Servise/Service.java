package Servise;

import Model.User;

import java.util.List;

public interface Service {
    void removeAll();

    void removeUser(int id);

    void removeUserByName(String name);

    void addUser(User user);

    void updateUser(User user);

    User getUser(int id);

    List<User> getAllUsers();


}
