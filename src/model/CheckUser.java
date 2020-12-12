package model;

import java.sql.*;

import resource.R;


public class CheckUser implements R {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";

	public boolean Exist(String id, String pw) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "";
		boolean exist_flag = false;

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

			sql = "SELECT TYPE FROM ACCOUNT WHERE USERNAME = '"+ id + "' AND PASSWORD = '"+pw+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.last();
			if(rs.getRow()>0) {
				exist_flag = true;
				
				req.put("user_type", rs.getString("TYPE"));
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}

		return exist_flag;
	}
}
