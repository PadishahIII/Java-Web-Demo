package dao;

import bean.UserBean;

public interface UserDao {
    public UserBean find(String username);
}