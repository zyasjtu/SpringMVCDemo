package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by z673413 on 2016/8/19.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public List<User> findUser(String id, String password) {
        return userDao.findUser(id, password);
    }
}
