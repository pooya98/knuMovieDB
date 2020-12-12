package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import resource.R;

public class InsertUser implements R{
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";

	public boolean idDuplicationCheck() {
		Connection conn = null;
		Statement stmt = null;
		String sql = "";
		
		boolean duplicate_flag = false;
		
		String id = req.get("signUp_id").toString();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Success!");
		} catch (ClassNotFoundException e) {
			System.err.println("error = " + e.getMessage());
			System.exit(1);
		}

		//
		try {
			conn = DriverManager.getConnection(URL, USER_UNIVERSITY, USER_PASSWD);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("Cannot get a connection: " + ex.getMessage());
			System.exit(1);
		}

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		            ResultSet.CONCUR_UPDATABLE);

			sql = "SELECT ID FROM ACCOUNT WHERE USERNAME = '"+ id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.last();
			if(rs.getRow()>0) {
				duplicate_flag = true;
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}

		return duplicate_flag;
	}
	
	public boolean insert_user() {
		Connection conn = null;
		Statement stmt = null;

		String sql = "";
		boolean success_flag = false;
		
		int row_id = 0;
		String id = req.get("signUp_id").toString();
		String pw = req.get("signUp_pw").toString();
		String name = req.get("signUp_name").toString();
		String contact = req.get("signUp_contact").toString();
		String address = req.get("signUp_address").toString();
		String sex = req.get("signUp_sex").toString();
		String birth = req.get("signUp_birth").toString();
		String job = req.get("signUp_job").toString();

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Success!");
		} catch (ClassNotFoundException e) {
			System.err.println("error = " + e.getMessage());
			System.exit(1);
		}

		//
		try {
			conn = DriverManager.getConnection(URL, USER_UNIVERSITY, USER_PASSWD);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("Cannot get a connection: " + ex.getMessage());
			System.exit(1);
		}

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		            ResultSet.CONCUR_UPDATABLE);

			sql = "SELECT ID FROM ACCOUNT ORDER BY ID ASC";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.last();
			if(rs.getRow() == 0) {
				row_id=1;
			}
			else {
				row_id = rs.getInt("ID")+1;
			}
			stmt.close();
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
		
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		            ResultSet.CONCUR_UPDATABLE);
			
			sql = "INSERT INTO ACCOUNT(ID, USERNAME, PASSWORD, NAME, CONTACT, MEMBERSHIP, PAYMENT_DATE, TYPE"
					+", ADDRESS, SEX, BIRTH, JOB)";
			
			sql +=" VALUES(";
			sql += String.valueOf(row_id);
			sql += ", ";
			sql += "'";
			sql += id;
			sql += "'";
			sql += ", ";
			sql += "'";
			sql += pw;
			sql += "'";
			sql += ", ";
			sql += "'";
			sql += name;
			sql += "'";
			sql += ", ";
			sql += "'";
			sql += contact;
			sql += "'";
			sql += ", ";
			sql += "'Basic'";
			sql += ", ";
			sql += "TO_DATE('2020-11-19', 'yyyy-mm-dd')";
			sql += ", ";
			sql += "'U'";
			
			// 
			sql += ", ";
			if(!req.get("signUp_address").toString().replaceAll(" ", "").equals("")) {
				sql += "'";
				sql += address;
				sql += "'";
			}
			else {
				sql += "null";
			}
			sql += ", ";
			if(!req.get("signUp_sex").toString().replaceAll(" ", "").equals("")) {
				sql += "'";
				sql += sex;
				sql += "'";
			}
			else {
				sql += "null";
			}
			sql += ", ";
			if(!req.get("signUp_birth").toString().replaceAll(" ", "").equals("")) {
				sql += "TO_DATE('"+birth+"', 'yyyy-mm-dd')";
			}
			else {
				sql += "null";
			}
			sql += ", ";
			if(!req.get("signUp_job").toString().replaceAll(" ", "").equals("")) {
				sql += "'";
				sql += job;
				sql += "'";
			}
			else {
				sql += "null";
			}
			sql +=") ";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0)
				success_flag = true;

			conn.commit();
			conn.close();
			stmt.close();
		} catch (SQLException ex2) {
			System.out.println(sql);
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}

		return success_flag;
	}
}
