package test.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/* Notice the Namespace and ResultPath */
@Namespace("/test")
//@Action("test")
@Result(location="test.jsp")
public class TestAction extends ActionSupport{

}
