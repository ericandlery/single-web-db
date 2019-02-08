package db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class TestMySql {
	
	@Test
	public void test() throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
		
		try(
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC","root","123456");
				PreparedStatement ps=conn.prepareStatement("select * from customers");
				ResultSet rs=ps.executeQuery();
				){
			
			while(rs.next()) {
				System.out.println(rs.getObject(2));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		
	}

}
