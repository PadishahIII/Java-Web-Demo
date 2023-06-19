package dao.Impl;

import bean.UserBean;
import dao.UserDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private static DataSource dataSource;
    private static UserDaoImpl INSTANCE;

    private UserDaoImpl() throws NamingException {
        if (dataSource == null) {
            Context context = new InitialContext();
            context = (Context) context.lookup("java:/comp/env");
            dataSource = (DataSource) context.lookup("jdbc/user");
        } else {

        }
    }

    public static UserDaoImpl getInstance() throws NamingException {
        if (INSTANCE == null) {
            INSTANCE = new UserDaoImpl();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }

    public UserBean find(String username) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "select username,password from user where username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username2 = resultSet.getString(1);
                String password = resultSet.getString(2);
                return new UserBean(username2, password);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
