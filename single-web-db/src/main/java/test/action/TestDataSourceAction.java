package test.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/test")
@Action("testDataSource")
@Result(name="suc",location="/test/ds_test.jsp")
public class TestDataSourceAction extends ActionSupport{
	
	private String sql;
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("sql="+sql);
		
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
		
		List<Map<String,Object>> list=null;
		Map<String,Object> map=null;
		
		try(
				Connection conn=ds.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				){
			ResultSetMetaData md=rs.getMetaData();
			list=new ArrayList<>();
			while(rs.next()) {
				map=new HashMap<>();
				int count=md.getColumnCount();
				for(int i=1;i<=count;i++) {
					map.put(md.getColumnName(i),rs.getObject(i));
				}
				list.add(map);
			}
			
			for(Map m:list) {
				System.out.println(m);
			}
			
		}catch(Exception e) {
			throw new SQLException();
		}
		
		return "suc";
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public String toString() {
		return "TestDataSourceAction [sql=" + sql + "]";
	}
	
}
