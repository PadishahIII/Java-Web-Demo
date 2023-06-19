package service.Impl;

import bean.UserBean;
import dao.Impl.UserDaoImpl;
import dao.UserDao;
import service.LoginService;
import util.Md5Util;

import javax.naming.NamingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class LoginServiceImpl implements LoginService {
    private UserDao userDao;
    private static LoginServiceImpl INSTANCE;
    private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class.getName());

    private LoginServiceImpl() throws NamingException {
        userDao = UserDaoImpl.getInstance();
    }

    public static LoginServiceImpl getInstance() throws NamingException {
        if (INSTANCE == null) {
            INSTANCE = new LoginServiceImpl();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }

    public boolean check(String username, String password) {
        if (username == null || password == null){
            return false;
        }
        try {
            String passMd5 = Md5Util.getMd5Str(password);
            LOGGER.info(String.format("Password MD5: %s; %s", passMd5, password));
            UserBean userBean = userDao.find(username);
            if (userBean == null) {
                return false;
            } else {
                return passMd5.equals(userBean.password);
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
