package test.mybatis;

public class TestSelectProvider {
	
	public String getNameById() {
		return "select t.customerName from customers t where t.customernumber=#{id}";
	}

}
