package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VersionDAO {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";
	
	public boolean Exist(String movie_id, String version) {

		boolean flag = false;

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

			String sql = "SELECT M.TITLE AS MOVIE_TITLE, V.V_TITLE AS VERSION_TITLE, N.SHORT_NAME AS SHORT_NAME, V.IS_ORIGINAL AS IS_ORIGINAL FROM MOVIE M, VERSION V, NATIONALITY N WHERE N.ID = V.N_ID AND M.ID = V.M_ID AND N.SHORT_NAME = '"+version+"' AND M.ID = "+movie_id;
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				while (rs.next()) {
					flag = true;
				}
			}
			con.close();
			rs.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
		return flag;
	}

	public List<VersionDTO> get_list(int id) {

		List<VersionDTO> list = null;

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

			String sql = "SELECT M.TITLE AS MOVIE_TITLE, V.V_TITLE AS VERSION_TITLE, N.SHORT_NAME AS SHORT_NAME, V.IS_ORIGINAL AS IS_ORIGINAL FROM MOVIE M, VERSION V, NATIONALITY N WHERE N.ID = V.N_ID AND M.ID = V.M_ID AND M.ID = "+id;
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				
				list = new ArrayList<VersionDTO>();
				while (rs.next()) {
					VersionDTO dto = new VersionDTO();
					
					dto.setMovie_title(rs.getString("MOVIE_TITLE"));
					dto.setNationality_short(rs.getString("SHORT_NAME"));
					dto.setIs_original(rs.getString("IS_ORIGINAL"));
					dto.setVersion_title(rs.getString("VERSION_TITLE"));
					
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
	
	
	public boolean insert_version(int movie_id, String version_short, String version_title, String is_original) {

		Connection con = null;
		Statement stmt = null;
		boolean success_flag = false;
		ResultSet rs = null;
		int n_id =0;

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

			String sql = "SELECT ID FROM NATIONALITY WHERE SHORT_NAME ='"+version_short+"'";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				while (rs.next()) {
					n_id = (int)rs.getInt("ID");
				}
			}
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}

		try {
			con.setAutoCommit(false);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		            ResultSet.CONCUR_UPDATABLE);
			
			String sql = "INSERT INTO VERSION VALUES ("+movie_id+", "+n_id+", '"+version_title+"', '"+is_original+ "'"+ ")";
			
			
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
	
	public boolean dropVersion(int movie_id, String short_name) {
		Connection con = null;
		Statement stmt = null;
		boolean success_flag = false;
		ResultSet rs = null;
		int n_id=0;

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

			String sql = "SELECT ID FROM NATIONALITY WHERE SHORT_NAME ='"+short_name+"'";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				while (rs.next()) {
					n_id = (int)rs.getInt("ID");
				}
			}
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}

		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();

			String sql = "DELETE FROM VERSION WHERE M_ID = "+movie_id+" AND N_ID = "+n_id;

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
