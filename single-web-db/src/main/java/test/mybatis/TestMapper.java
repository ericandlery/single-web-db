package test.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface TestMapper {
	
	@Select("select version()")
	public Object getVersion();
	
	@Select("select t.customerName from customers t")
	public List<String> getNames();
	
	@Select("select t.customerName from customers t where t.customernumber=#{id}")
	public String getNameById(int id);
	
	@SelectProvider(type=TestSelectProvider.class,method="getNameById")
	public String getNameById2(int id);
	
	/* Can't do this. */
//	@Select("select t.customerName from #{} t where t.customernumber=103")
//	public String getNameFromTable(String table);

}
