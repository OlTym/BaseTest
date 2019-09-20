import Model.User;
import Servise.Service;
import Servise.UserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Service userServise = new UserService();

        System.out.println("Clear the base");
        userServise.removeAll();
        List<User> list = userServise.getAllUsers();
        System.out.println("Users list\n" + list);
        System.out.println("===============================================");

        System.out.println("Add users into the base");
        userServise.addUser(new User("Alex", 22));
        userServise.addUser(new User("Mary", 32));
        userServise.addUser(new User("Tom", 25));
        userServise.addUser(new User("Vlad", 27));
        userServise.addUser(new User("Ben", 20));
        userServise.addUser(new User("Cindy", 35));

        list = userServise.getAllUsers();
        System.out.println("Users list\n" + list);
        System.out.println("===============================================");

        System.out.println("Get user id=" + list.get(2).getID());
        User user = userServise.getUser(list.get(2).getID());
        System.out.println("Users list\n" + list);
        System.out.println("===============================================");

        System.out.println("Update user named " + user.getName());
        user.setAge(user.getAge() + 5);
        userServise.updateUser(user);
        list = userServise.getAllUsers();
        System.out.println("Users list\n" + list);
        System.out.println("===============================================");

        System.out.println("Remove user by id=" + list.get(0).getID() + " named " + list.get(0).getName());
        userServise.removeUser(list.get(0).getID());
        list = userServise.getAllUsers();
        System.out.println("Users list\n" + list);
        System.out.println("===============================================");

        System.out.println("Remove user named " + list.get(3).getName());
        userServise.removeUserByName(list.get(3).getName());
        list = userServise.getAllUsers();
        System.out.println("Users list\n" + list);

    }


}
