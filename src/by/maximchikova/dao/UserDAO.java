package by.maximchikova.dao;

import by.maximchikova.entities.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAO extends AbstractDAO<Integer, User>  {
    private static final String SELECT = "SELECT * FROM users ORDER BY id";
    private static final String SELECT_ONE = "SELECT * FROM users WHERE login=? and password=?";
    private static final String INSERT = "INSERT INTO users(login,password) values (?,?)";

    private User createUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }

    public User findEntity(String login, String password) {
        User user = null;
        try (Connection connection = getDbConnection()) {
            PreparedStatement pst = connection.prepareStatement(SELECT_ONE);
            pst.setString(1,login);
            pst.setString(2,password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user = createUser(rs);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User addEntity(String login, String password) {
        try (Connection connection = getDbConnection()) {
            PreparedStatement pst = connection.prepareStatement(INSERT);
            pst.setString(1,login);
            pst.setString(2,password);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return findEntity(login,password);
    }
}
