package Interceptor;

import action.UserInfoAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import model.LoginModel;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.SessionMap;

public class LoginAuthenticationInterceptor implements Interceptor {
    public void destroy() {

    }

    public void init() {

    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Interceptor");
        SessionMap<String, Object> sessionMap = (SessionMap<String, Object>) actionInvocation.getInvocationContext().getSession();
        UserInfoAction action = (UserInfoAction) actionInvocation.getAction();
        String username = (String) sessionMap.get("username");

        if (username == null) {
            return "login";
        } else {
            LoginModel model = (LoginModel) action.getModel();
            model.setUsername(username);
            model.setMsg("");
            actionInvocation.invoke();
            return null;
        }
    }
}
