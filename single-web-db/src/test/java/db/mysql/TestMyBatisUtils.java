package db.mysql;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import test.mybatis.TestMapper;
import utils.MyBatisUtils;

public class TestMyBatisUtils {
	
	@Test
	public void test() {
		SqlSession s=MyBatisUtils.getSqlSession();
		System.out.println((String)s.selectOne("getNameById2",103));
		s.close();
	}

}
