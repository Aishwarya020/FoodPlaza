package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.foodplaza.utility.DBUtility;


public class LoginDaoImpl implements LoginDao {
	static Connection con = DBUtility.connection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = null;

	@Override
	public boolean userLogin(String email, String pass) {

		try {
			query = "select * from Customer20829 where custemailid=? and custpassword=?";
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean userChangePass(String email, String pass) {
		try {
			query = "update Customer20829 set custpassword =? where custemailid=?";
			ps = con.prepareStatement(query);
			ps.setString(1, pass);
			ps.setString(2, email);
			int row = ps.executeUpdate();
			if (row > 0) {
				return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean adminLogin(String email, String pass) {
		try {
			query = "select * from Admin20829 where admn_email=? and admn_password=?";
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	
	public static void main(String[] args) {
		System.out.println("login dao");
		LoginDaoImpl daoImpl = new LoginDaoImpl();
		
		boolean userLogin = daoImpl.userLogin("iamaish2012@gmail.com", "abcd");
		System.out.println("userLogin :" + userLogin);

		boolean adminLogin = daoImpl.adminLogin("squadinfotech@gmail.com", "c0d3r123");
		System.out.println("adminLogin :" + adminLogin);

		boolean adminPassword = daoImpl.adminChangePass("squadinfotech@gmail.com", "squad");
		System.out.println("adminPassword :" + adminPassword);

		boolean UserPassword = daoImpl.userChangePass("iamaish2012@gmail.com", "squad");
		System.out.println("UserPassword :" + UserPassword);

	}

}
