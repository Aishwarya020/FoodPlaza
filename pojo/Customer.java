package com.foodplaza.pojo;

public class Customer {
    private int custid;
    private String custname;
    private String custemailid;
    private String password;
    private String address;
    private String contactno;
    
    
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustemailid() {
		return custemailid;
	}
	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public Customer( String custname, String custemailid, String password, String address,
			String contactno) {
		super();
		
		this.custname = custname;
		this.custemailid = custemailid;
		this.password = password;
		this.address = address;
		this.contactno = contactno;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custemailid=" + custemailid + ", password="
				+ password + ", address=" + address + ", contactno=" + contactno + "]";
	}
	public Customer(int custid, String custname, String custemailid, String password, String address,
			String contactno) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.custemailid = custemailid;
		this.password = password;
		this.address = address;
		this.contactno = contactno;
	}
	
	
	
    
    
}
