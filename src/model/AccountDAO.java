package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import resource.R;

public class AccountDAO implements R {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";

	public void getUserInfo() {

		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// System.out.println("Success!");
		} catch (ClassNotFoundException e) {
			System.err.println("error = " + e.getMessage());
			System.exit(1);
		}

		try {
			con = DriverManager.getConnection(URL, USER_UNIVERSITY, USER_PASSWD);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("Cannot get a connection: " + ex.getMessage());
			System.exit(1);
		}

		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();

			String sql = "SELECT ID, USERNAME, PASSWORD, NAME, TYPE, CONTACT, ADDRESS, SEX, BIRTH, JOB, MEMBERSHIP, PAYMENT_DATE FROM ACCOUNT WHERE USERNAME='"
					+ req.get("id") + "'";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				while (rs.next()) {
					req.put("client_id", rs.getInt("ID"));
					req.put("client_username", rs.getString("USERNAME"));
					req.put("client_password", rs.getString("PASSWORD"));
					req.put("client_name", rs.getString("NAME"));
					req.put("client_type", rs.getString("TYPE"));
					if (rs.getString("CONTACT") != null) {
						req.put("client_contact", rs.getString("CONTACT"));
					} else {
						req.put("client_contact", "정보 없음");
					}
					if (rs.getString("ADDRESS") != null) {
						req.put("client_address", rs.getString("ADDRESS"));
					} else {
						req.put("client_address", "정보 없음");
					}
					if (rs.getString("SEX") != null) {
						req.put("client_sex", rs.getString("SEX"));
					} else {
						req.put("client_sex","정보 없음");
					}
					if (rs.getString("BIRTH") != null) {
						req.put("client_birth", rs.getString("BIRTH"));
					} else {
						req.put("client_birth", "정보 없음");
					}
					if (rs.getString("JOB") != null) {
						req.put("client_job", rs.getString("JOB"));
					} else {
						req.put("client_job", "정보 없음");
					}
					if(rs.getString("TYPE").equals("U")) {
						req.put("client_membership", rs.getString("MEMBERSHIP"));
						req.put("client_payment_date", rs.getString("PAYMENT_DATE"));
					}
				}
			}
			con.close();
			rs.close();
			stmt.close();

		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public boolean modify_password() {
		Connection con = null;
		Statement stmt = null;
		boolean success_flag = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// System.out.println("Success!");
		} catch (ClassNotFoundException e) {
			System.err.println("error = " + e.getMessage());
			System.exit(1);
		}

		try {
			con = DriverManager.getConnection(URL, USER_UNIVERSITY, USER_PASSWD);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("Cannot get a connection: " + ex.getMessage());
			System.exit(1);
		}

		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();

			String sql = "UPDATE ACCOUNT SET PASSWORD = '"+req.get("new_pw").toString()+"' WHERE USERNAME ='"+req.get("client_username").toString()+"'";

			int r = stmt.executeUpdate(sql);
			
			if(r>0)
				success_flag = true;

			con.commit();
			con.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
		
		return success_flag;
	}
	
	public boolean modify_info(String attribute, String value) {
		Connection con = null;
		Statement stmt = null;
		boolean success_flag = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// System.out.println("Success!");
		} catch (ClassNotFoundException e) {
			System.err.println("error = " + e.getMessage());
			System.exit(1);
		}

		try {
			con = DriverManager.getConnection(URL, USER_UNIVERSITY, USER_PASSWD);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("Cannot get a connection: " + ex.getMessage());
			System.exit(1);
		}

		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			
			if(value.equals("(입력없음)")) {
				value = "null";
			}
			else {
				value = "'"+value+"'";
			}

			String sql = "UPDATE ACCOUNT SET "+attribute+" = "+value+" WHERE USERNAME ='"+req.get("client_username").toString()+"'";

			int r = stmt.executeUpdate(sql);
			
			if(r>0)
				success_flag = true;

			con.commit();
			con.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
		
		return success_flag;
	}
	
	public boolean dropAccount() {
		Connection con = null;
		Statement stmt = null;
		boolean success_flag = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// System.out.println("Success!");
		} catch (ClassNotFoundException e) {
			System.err.println("error = " + e.getMessage());
			System.exit(1);
		}

		try {
			con = DriverManager.getConnection(URL, USER_UNIVERSITY, USER_PASSWD);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("Cannot get a connection: " + ex.getMessage());
			System.exit(1);
		}

		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();

			String sql = "DELETE FROM ACCOUNT WHERE USERNAME = '"+req.get("id")+"'";

			int r = stmt.executeUpdate(sql);
			
			if(r>0)
				success_flag = true;

			con.commit();
			con.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
		
		return success_flag;
	}
}