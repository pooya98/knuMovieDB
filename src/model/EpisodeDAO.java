package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EpisodeDAO {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";

	public List<EpisodeDTO> get_list(int id) {

		List<EpisodeDTO> list = null;

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

			String sql = "SELECT M.TITLE AS TITLE, E.S_NUMBER AS SEASON, E.E_NUMBER AS EPINUM, E.E_RUNTIME AS E_RUNTIME, E.E_TITLE AS E_TITLE FROM EPISODE E, MOVIE M WHERE M.ID = E.M_ID AND M.ID ="+id+" ORDER BY E.S_NUMBER, E.E_NUMBER";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				
				list = new ArrayList<EpisodeDTO>();
				while (rs.next()) {
					EpisodeDTO dto = new EpisodeDTO();
					
					dto.setMovie_title(rs.getString("TITLE"));
					dto.setSeason((rs.getInt("SEASON")));
					dto.setEpisodeRuntime(rs.getInt("E_RUNTIME"));
					dto.setEpisodeNum(rs.getInt("EPINUM"));
					dto.setEpisodeTitle(rs.getString("E_TITLE"));
					
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
	
	
	public boolean insert_episode(int movie_id, int season_num, int episode_num, String episode_title, int episode_runtime) {

		Connection con = null;
		Statement stmt = null;
		boolean success_flag = false;

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
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		            ResultSet.CONCUR_UPDATABLE);
			
			String sql = "INSERT INTO EPISODE VALUES ("+movie_id+", "+season_num+", "+episode_num+", '"+episode_title+"', "+episode_runtime+ ")";
			
			
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
	
	public boolean dropEpisode(int movie_id, int season_num, int episode_num) {
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

			String sql = "DELETE FROM EPISODE WHERE M_ID = "+movie_id+" AND S_NUMBER = "+season_num+" AND E_NUMBER = "+episode_num;

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
