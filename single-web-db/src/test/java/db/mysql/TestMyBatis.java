package db.mysql;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import test.mybatis.TestMapper;

public class TestMyBatis {

	@Test
	public void test() throws IOException, SQLException {
		
		SqlSessionFactory ssf=null;
		SqlSession s=null;
		
		Reader r=Resources.getResourceAsReader("mybatis-config.xml");
		ssf=new SqlSessionFactoryBuilder().build(r);
		r.close();
		ssf.getConfiguration().addMapper(TestMapper.class);
		s=ssf.openSession();
		
		System.out.println((Object)s.selectOne("getVersion"));
		
		ResultSet rs=s.getConnection().prepareStatement("select version()").executeQuery();
		while(rs.next()) {
			System.out.println(rs.getObject(1));
		}
		
		s.rollback();
		rs.close();
		s.close();
		
	}

}
