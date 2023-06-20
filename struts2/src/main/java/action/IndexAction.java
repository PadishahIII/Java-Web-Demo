package action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

@Namespace("/")
@ResultPath("/")
public class IndexAction extends ActionSupport {
    @Action(value = "index", results = {@Result(name = "success", location = "index.jsp")})
    public String execute() {
        return SUCCESS;
    }
}
