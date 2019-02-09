package test.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/test")
@Action("testReq")
@Result(name="suc",location="/test/test_aware.jsp")
public class TestReqAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private String name;
	
	/* Only setter is needed. */
	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;

	@Override
	public String execute() throws Exception {
		
		System.out.println("Name="+name);
		System.out.println(servletRequest.getCharacterEncoding());
		System.out.println(servletRequest.getContentType());
		System.out.println();
		System.out.println(servletResponse.getCharacterEncoding());
		System.out.println(servletResponse.getContentType());
		servletResponse.setCharacterEncoding("UTF-8");
		servletResponse.setContentType("text/html;charset=UTF-8");
		System.out.println(servletResponse.getCharacterEncoding());
		System.out.println(servletResponse.getContentType());
		
		PrintWriter out=servletResponse.getWriter();
		out.println("<h1>RESP TEST</h1>");
		out.println("<p>"+name+"</p>");
		out.flush();
		
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public HttpServletRequest getServletRequest() {
//		return servletRequest;
//	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

//	public HttpServletResponse getServletResponse() {
//		return servletResponse;
//	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

}
