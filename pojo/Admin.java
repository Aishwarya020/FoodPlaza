package com.foodplaza.pojo;

public class Admin {
private int adminId;
private String email;
private String pass;
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}



public Admin() {
	super();
}
public Admin(String email, String pass) {
	super();
	this.email = email;
	this.pass = pass;
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", email=" + email + ", pass=" + pass + "]";
}

}
