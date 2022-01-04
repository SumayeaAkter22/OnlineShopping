package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductAccess {
	Connection con;
	PreparedStatement pst;
	public void doInsert(Product product) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("insert into Product values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, product.id);
			pst.setString(2, product.name);
			pst.setString(3, product.category);
			pst.setDouble(4, product.price);
			pst.setDouble(5, product.weight);
			pst.setString(6, product.description);
			pst.setString(7, product.imageName);
			pst.setInt(8, product.stock);
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public void doDelete(Product ct) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("delete from Product where id=" + ct.id);

			pst.executeUpdate();

			System.out.println("delete");
		} catch (Exception e) {

		}
	}
	
	public List<Product> doShow() {
		List<Product> list = new ArrayList<>();
		Product cg;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("select * from Product");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cg = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				list.add(cg);
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	public List<Product> productByCategory(String category) {
		List<Product> list = new ArrayList<>();
		Product cg;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("select * from Product where category=?");
			pst.setString(1, category);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cg = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				list.add(cg);
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	public Product productId(int id) {
		List<Product> list = new ArrayList<>();
		Product cg;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("select * from Product where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cg = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				list.add(cg);
			}

		} catch (Exception e) {

		}
		return list.get(0);
		
		
	}
	
	
	public List<Product> doShowLowQuantity() {
		List<Product> list = new ArrayList<>();
		Product cg;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("select * from Product where stock < 5");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cg = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				list.add(cg);
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	public List<Product> doShowHighQuantity() {
		List<Product> list = new ArrayList<>();
		Product cg;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("select * from Product where stock > 15");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cg = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				list.add(cg);
			}

		} catch (Exception e) {

		}
		return list;
	}
}
