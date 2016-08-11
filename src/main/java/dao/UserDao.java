package dao;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by z673413 on 2016/7/26.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(String id, String name, String password,
                        String email, String address, Date birthday,
                        Integer type, Double discount) {
        String sql = " INSERT INTO SpringMVCDemo_User (id,name,password,email,address,birthday,type,discount) "
                   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        jdbcTemplate.update(sql, new Object[]{id, name, password, email, address, birthday, type, discount});
    }

    public void deleteUser(String id) {
        String sql = " DELETE FROM SpringMVCDemo_User WHERE id = ? ";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void updateUser(String id, String name, String password,
                           String email, String address, Date birthday,
                           Integer type, Double discount) {
        String sql = " UPDATE SpringMVCDemo_User SET name = ?, password = ?, email = ?, "
                   + "address = ?, birthday = ?, type = ?, discount = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{name,password,email,address,birthday,type,discount,id});
    }

    public User findUser(final String id, final String password) {
        final User user = new User();
        String sql = " SELECT * FROM SpringMVCDemo_User WHERE id = ? AND password = ? ";
        jdbcTemplate.query(sql, new Object[]{id, password},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));
                        user.setEmail(rs.getString("email"));
                        user.setAddress(rs.getString("address"));
                        user.setBirthday(rs.getDate("birthday"));
                        user.setType(rs.getInt("type"));
                        user.setDiscount(rs.getDouble("discount"));
                    }
                });
        return user;
    }
}
