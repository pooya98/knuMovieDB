package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO {
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";
	
	public List<DirectorDTO> get_list() {

		List<DirectorDTO> list = null;

		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Success!");
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

			String sql = "SELECT ID, NAME, BIRTH, SEX FROM DIRECTOR ORDER BY ID";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				
				list = new ArrayList<DirectorDTO>();
				while (rs.next()) {
					DirectorDTO dto = new DirectorDTO();
					
					dto.setId(rs.getInt("ID"));
					dto.setName(rs.getString("NAME"));
					dto.setBirth(rs.getString("BIRTH"));
					dto.setSex(rs.getString("SEX"));
					
					list.add(dto);
				}
			}
			con.close();
			rs.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
		return list;
	}
	
	public boolean update_produce(int movie_id, int dir_id, boolean was_null) {
		Connection con = null;
		Statement stmt = null;
		boolean success_flag = false;
		String sql;

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

			if(was_null == false) {
				sql = "UPDATE PRODUCED_BY SET D_ID = "+dir_id+" WHERE M_ID = "+movie_id;
			}
			else
			{
				sql = "INSERT INTO PRODUCED_BY VALUES ("+movie_id+", "+dir_id+")";
			}
			
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
