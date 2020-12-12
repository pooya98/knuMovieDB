package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";
	
	public List<ActorDTO> get_list_this_movie(int id) {

		List<ActorDTO> list = null;

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

			String sql = "SELECT A.BIRTH AS ACTOR_BIRTH, A.NAME AS ACTOR_NAME, A.ID AS ACTOR_ID, A.SEX AS ACTOR_SEX, M.TITLE AS MOVIE_TITLE FROM ACTOR A, PARTICIPATE_IN P, MOVIE M WHERE P.A_ID = A.ID AND P.M_ID = M.ID AND M.ID ="+id+" ORDER BY A.ID";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				list = new ArrayList<ActorDTO>();
				while (rs.next()) {
					ActorDTO dto = new ActorDTO();
					
					dto.setId(rs.getInt("ACTOR_ID"));
					dto.setName(rs.getString("ACTOR_NAME"));
					dto.setBirth(rs.getString("ACTOR_BIRTH"));
					dto.setSex(rs.getString("ACTOR_SEX"));
					dto.setMoive_title(rs.getString("MOVIE_TITLE"));
					
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
	
	public boolean delete_from_movie(int movie_id, int actor_id) {
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

			String sql = "DELETE FROM PARTICIPATE_IN WHERE M_ID = "+movie_id+" AND A_ID = "+actor_id;

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
	
	public List<ActorDTO> get_list_not_exist(int movie_id) {

		List<ActorDTO> list = null;

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

			String sql = "SELECT A.ID AS ACTOR_ID, A.NAME AS ACTOR_NAME, A.BIRTH AS ACTOR_BIRTH, A.SEX AS ACTOR_SEX FROM ACTOR A WHERE NOT EXISTS ( SELECT * FROM  PARTICIPATE_IN WHERE A_ID = A.ID AND M_ID = "+ movie_id+")";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				list = new ArrayList<ActorDTO>();
				while (rs.next()) {
					ActorDTO dto = new ActorDTO();
					
					dto.setId(rs.getInt("ACTOR_ID"));
					dto.setName(rs.getString("ACTOR_NAME"));
					dto.setBirth(rs.getString("ACTOR_BIRTH"));
					dto.setSex(rs.getString("ACTOR_SEX"));
					
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
	
	
	public boolean insert_participate(int movie_id, int actor_id) {
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

			String sql = "INSERT INTO PARTICIPATE_IN VALUES("+movie_id+", "+actor_id+")";

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
