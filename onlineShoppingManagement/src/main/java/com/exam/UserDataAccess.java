package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDataAccess {
	Connection con;
	PreparedStatement pst;

	public void doInsert(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("insert into User values(?,?,?,?,?)");
			pst.setInt(1, user.id);
			pst.setString(2, user.firstName);
			pst.setString(3, user.lastName);
			pst.setString(4, user.email);
			pst.setString(5, user.password);
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public User findUser(User user) {
		List<User> list = new ArrayList<>();
		User s = new User();
		ResultSet rst;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("select * from user where email=? and password=?");
			pst.setString(1, user.email);
			pst.setString(2, user.password);
			rst = pst.executeQuery();
			while (rst.next()) {
				s = new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
				// s=new User(2,"topu","abc","t@gmail.com","123");
				list.add(s);

			}

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

}
