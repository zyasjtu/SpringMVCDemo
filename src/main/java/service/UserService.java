package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by z673413 on 2016/7/26.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user.getId(), user.getName(), user.getPassword(),
                user.getEmail(), user.getAddress(), user.getBirthday(),
                user.getType(), user.getDiscount());
    }

    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user.getId(), user.getName(), user.getPassword(),
                user.getEmail(), user.getAddress(), user.getBirthday(),
                user.getType(), user.getDiscount());
    }

    public User findUser(String id, String password) {
        return userDao.findUser(id, password);
    }
}
