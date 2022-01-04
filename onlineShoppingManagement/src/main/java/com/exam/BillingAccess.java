package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillingAccess {
	Connection con;
	PreparedStatement pst;

	public void doInsert(Billing bil) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement(
					"insert into billing(firstName,lastName,form14,form15,postcode,city,phone,email,form76,total,currentDate,expectedDate) values(?,?,?,?,?,?,?,?,?,?,?,?)");
//			pst.setInt(1, bil.id);
			pst.setString(1, bil.firstName);
			pst.setString(2, bil.lastName);
			pst.setString(3, bil.form14);
			pst.setString(4, bil.form15);
			pst.setString(5, bil.postcode);
			pst.setString(6, bil.city);
			pst.setString(7, bil.phone);
			pst.setString(8, bil.email);
			pst.setString(9, bil.form76);
			pst.setDouble(10, bil.total);
			pst.setDate(11, new java.sql.Date(System.currentTimeMillis()));
			pst.setDate(12, new java.sql.Date(new java.util.Date().getTime() + 10 * 24 * 60 * 60 * 1000));
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public List<Billing> doShow() {
		List<Billing> list = new ArrayList<>();
		Billing bil;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectspring", "root", "root");
			pst = con.prepareStatement("select * from billing");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				bil = new Billing(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDouble(11),rs.getDate(12),rs.getDate(13));
				list.add(bil);
			}

		} catch (Exception e) {

		}
		return list;
	}
	
}
