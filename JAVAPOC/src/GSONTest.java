import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;


public class GSONTest {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		
		
		Customer c= new Customer();
		c.setId(1001);
		c.setName("Kiran");
		Address addr = new Address();
		addr.setHno("2-1");
		addr.setPcode("500082");
		addr.setStreet("HYD");
		c.setAddr(addr);
		
		Company cmpny1 = new Company();
		cmpny1.setId(1233);
		cmpny1.setName("Chemical");
		
		Company cmpny2 = new Company();
		cmpny2.setId(1234);
		cmpny2.setName("Electrical");
		
		List<Company> clist = new ArrayList<>();
		clist.add(cmpny1);
		clist.add(cmpny2);
		c.setCompanyList(clist);
		
		System.out.println(gson.toJson(c));
		

	}

}

class Customer {
	
	int id;
	List<Company> companyList;
	String name;
	Address addr;
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Company> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	
}
class Address{
	String hno;
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	String street;
	String pcode;
}
class Company{
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;
}
