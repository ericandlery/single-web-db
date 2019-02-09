package test.mybatis;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
	
	@Select("select version()")
	public Object getVersion();

}
