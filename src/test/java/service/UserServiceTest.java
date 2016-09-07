package service;

import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by z673413 on 2016/8/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void findUserTest() {
        List<User> users = userService.findUser("admin", "a");
        assertEquals("Colin", users.get(0).getName());
    }

    @Test
    public void addUserTest() {
        User user = new User();
        user.setId("test");
        user.setName("xxx");
        user.setPassword("x");
        user.setType(0);
        user.setDiscount(1.0);
        userService.addUser(user);
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setId("test");
        user.setName("xxx");
        user.setPassword("xxx");
        user.setType(0);
        user.setDiscount(1.0);
        userService.updateUser(user);
    }

    @Test
    public void deleteUserTest() {
        User user = new User();
        user.setId("test");
        userService.deleteUser(user);
    }

}