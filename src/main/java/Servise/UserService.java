package Servise;

import Dao.UserDao;
import Model.User;

import java.util.List;

public class UserService implements Service {

    UserDao dao = new UserDao();

    @Override
    public void removeAll() {

        int count = dao.removeAll();
        if (count != 0) {
            System.out.println("Remove " + count + " items");
        } else {
            System.out.println("There is not any item in the base");

        }

    }

    @Override
    public void removeUser(int id) {
        int count = dao.removeUser(id);
        if (count == 0)
            System.out.println("This user is not in the base");
        else {
            System.out.println("The user is removed successfilly");
        }
    }

    @Override
    public void removeUserByName(String name) {
        int count = dao.removeUserByName(name);
        if (count == 0)
            System.out.println("This user is not in the base");
        else {
            System.out.println("The user is removed successfilly");
        }
    }

    @Override
    public void addUser(User user) {

        boolean add = true;

        List<User> list = dao.getAllUsers();

        if (list.size() != 0) {
            for (User us : list) {
                if (us.equals(user)) {
                    add = false;
                    System.out.println("This user is in this base");
                    break;
                }
            }
        }

        if (add) {
            dao.insertUser(user);
        }

    }

    @Override
    public void updateUser(User user) {
        int count = dao.updateUser(user);
        if (count == 0) {
            System.out.println("This user is not in the base");
        } else {
            System.out.println("The user is updeted successfilly");
        }
    }

    @Override
    public User getUser(int id) {
        return dao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = dao.getAllUsers();
        if (list == null) {
            System.out.println("There is not any item in the base");
        }
        return list;
    }
}
