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

/**
 * Created by z673413 on 2016/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUserTest() throws Exception {

    }

    @Test
    public void deleteUserTest() throws Exception {

    }

    @Test
    public void updateUserTest() throws Exception {

    }

    @Test
    public void findUserTest() throws Exception {
        List<User> users = userService.findUser("admin", "a");
    }

}