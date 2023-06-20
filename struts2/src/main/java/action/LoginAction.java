package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.LoginModel;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import service.Impl.LoginServiceImpl;
import service.LoginService;

import javax.naming.NamingException;
import java.util.Map;

@Namespace("/")
@ResultPath("/")
public class LoginAction extends ActionSupport implements ModelDriven, SessionAware {
    private LoginService service;
    LoginModel loginModel = new LoginModel();
    private SessionMap<String, Object> sessionMap;

    public LoginAction() throws NamingException {
        service = LoginServiceImpl.getInstance();
    }

    @Action(value = "login", results = {@Result(name = "success", location = "userinfo.jsp"),
            @Result(name = "login", location = "login.jsp"),
            @Result(name = "error", location = "login.jsp")})
    public String execute() {
        System.out.println("LoginAction.execute");
        javax.servlet.http.HttpServletRequest request = ServletActionContext.getRequest();
        String method = request.getMethod();
        if (method.toLowerCase().equals("get")) {
            loginModel.setMsg("");
            return "login";
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (service.check(username, password)) {
                sessionMap.put("username", username);
                loginModel.setMsg("");
                return SUCCESS;
            } else {
                loginModel.setMsg("用户名或密码错误");
                return ERROR;
            }
        }
    }


    public Object getModel() {
        System.out.println("LoginAction.getModel");
        return loginModel;
    }

    public void setSession(Map<String, Object> map) {
        System.out.println("LoginAction.setSession");
        sessionMap = (SessionMap<String, Object>) map;
    }
}
