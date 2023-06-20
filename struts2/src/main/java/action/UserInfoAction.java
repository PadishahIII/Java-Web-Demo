package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.LoginModel;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

@Namespace("/")
@ResultPath("/")
public class UserInfoAction extends ActionSupport implements ModelDriven {
    private String username = "";
    LoginModel loginModel = new LoginModel();


    @Action(value = "userinfo", results = {@Result(name = "success", location = "uesrinfo.jsp"),
            @Result(name = "login", location = "login.jsp"),
            @Result(name = "error", location = "login.jsp")})
    public String execute() {
        System.out.println("UserInfoAction.execute");
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getModel() {
        return loginModel;
    }
}
