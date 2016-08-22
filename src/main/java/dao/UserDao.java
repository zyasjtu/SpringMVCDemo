package dao;

import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by z673413 on 2016/8/19.
 */
@Repository
public interface UserDao {
    void addUser(User user);

    void deleteUser(String id);

    void updateUser(User user);

    List<User> findUser(String id, String password);
}
