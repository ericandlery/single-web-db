package db.mysql;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

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
		
		Reader r=Resources.getResourceAsReader("mybatis-junit-config.xml");
		ssf=new SqlSessionFactoryBuilder().build(r);
		r.close();
		ssf.getConfiguration().addMapper(TestMapper.class);
		s=ssf.openSession();
		
		System.out.println((Object)s.selectOne("getVersion"));
		
		List<String> list=s.selectList("getNames");
		System.out.println(list);
		
		System.out.println((String)s.selectOne("getNameById",103));
		System.out.println((String)s.selectOne("getNameById2",103));
		
//		ResultSet rs=s.getConnection().prepareStatement("select version()").executeQuery();
//		while(rs.next()) {
//			System.out.println(rs.getObject(1));
//		}
		
		s.rollback();
//		rs.close();
		s.close();
		
	}

}
