package test.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
	
	@Select("select version()")
	public Object getVersion();
	
	@Select("select t.customerName from customers t")
	public List<String> getNames();

}
