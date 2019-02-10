package utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.mybatis.TestMapper;

public class MyBatisUtils {
	
	private static SqlSessionFactory sessionFactory;
	
	private MyBatisUtils() {}
	
	static {
		try {
			Reader reader=Resources.getResourceAsReader("mybatis-junit-config.xml");
			sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			sessionFactory.getConfiguration().addMapper(TestMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new SqlSessionException();
		}		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sessionFactory;
	}
	
	public static SqlSession getSqlSession() {
		return sessionFactory.openSession();
	}

}
