package by.maximchikova.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractDAO <K extends Integer, T> {
    Connection connection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/java_lr10?serverTimezone=Europe/Moscow&useSSL=false", "root", "1234");
        return connection;
    }

    public void closeDbConnection() {
        if (connection != null)
        {
            try {
                connection.close();
            }
            catch (SQLException e) {
                System.err.println("Wrong connection" + e);
            }
        }
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}