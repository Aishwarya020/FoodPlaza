package com.foodplaza.pojo;

public class Order {
	
	private int orderid ;
	private String custemailid , orderdate , orderstatus ;
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	private double totalbill ;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCustemailid() {
		return custemailid;
	}
	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public double getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(double totalbill) {
		this.totalbill = totalbill;
	}
	
	
	public Order(int orderid, String custemailid, String orderdate, String orderstatus, double totalbill) {
		super();
		this.orderid = orderid;
		this.custemailid = custemailid;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.totalbill = totalbill;
	}
	
	
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", custemailid=" + custemailid + ", orderdate=" + orderdate
				+ ", orderstatus=" + orderstatus + ", totalbill=" + totalbill + "]";
	}
	
	
	
	

}
