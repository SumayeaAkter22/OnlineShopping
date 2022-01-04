package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryAccess {
	Connection con;
	PreparedStatement pst;

	public void doInsert(Category ct) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("insert into Category values(?,?)");
			pst.setInt(1, ct.id);
			pst.setString(2, ct.name);
			
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public void doDelete(Category ct) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("delete from Category where id=" + ct.id);

			pst.executeUpdate();

			System.out.println("delete");
		} catch (Exception e) {

		}
	}
	public List<Category> doShow() {
		List<Category> list = new ArrayList<>();
		Category cg;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("select * from Category");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cg = new Category(rs.getInt(1),rs.getString(2));
				list.add(cg);
			}

		} catch (Exception e) {

		}
		return list;
	}
	
//	public List<Category> productByName(String name) {
//		List<Category> list = new ArrayList<>();
//		Category cg;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
//			pst = con.prepareStatement("select * from Category where name=?");
//			pst.setString(1, name);
//			ResultSet rs = pst.executeQuery();
//			while (rs.next()) {
//				cg = new Category(rs.getInt(1),rs.getString(2));
//				list.add(cg);
//			}
//
//		} catch (Exception e) {
//
//		}
//		return list;
//	}

}
