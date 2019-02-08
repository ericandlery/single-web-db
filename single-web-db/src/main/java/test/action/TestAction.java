package test.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/* Notice the Namespace and ResultPath */
@Namespace("/test")
//@Action("test")
@Result(location="test.jsp")
public class TestAction extends ActionSupport{

}
