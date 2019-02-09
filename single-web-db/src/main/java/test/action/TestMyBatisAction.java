package test.action;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import test.mybatis.TestMapper;

@Namespace("/test")
@Action("testMyBatis")
@Result(name="suc",location="/test/test_mybatis.jsp")
public class TestMyBatisAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
		SqlSessionFactory ssf=null;
		SqlSession s=null;
		
		Reader r=Resources.getResourceAsReader("mybatis-config.xml");
		ssf=new SqlSessionFactoryBuilder().build(r);
		r.close();
		ssf.getConfiguration().addMapper(TestMapper.class);
		s=ssf.openSession();
		
//		Object o=(Object)s.selectOne("getVersion");
//		ServletActionContext.getRequest().setAttribute("obj",o);
		
		List<String> list=s.selectList("getNames");
		
		ServletActionContext.getRequest().setAttribute("list",list);
		
		s.rollback();
		s.close();
		
		System.out.println("mybatis test ok");
		
		return "suc";
	}

}
