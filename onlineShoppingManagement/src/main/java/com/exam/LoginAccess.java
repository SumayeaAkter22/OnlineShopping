package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginAccess {
	Connection cn;
	PreparedStatement pst;
	public Login findUser(Login log) {
		List<Login> list=new ArrayList<>();
		Login s = new Login();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring","root","root");
			pst=cn.prepareStatement("select * from Login where email=? and password=?");
			pst.setString(1, log.email);
			pst.setString(2, log.password);
			ResultSet rst=pst.executeQuery();
			while(rst.next()) {
				s=new Login(rst.getString(1),rst.getString(2));
				list.add(s);
			
			}

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
			return list.get(0);
		
		
	}


}
