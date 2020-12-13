package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import resource.R;

public class RatingDAO implements R {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";
	
	public List<RatingDTO> myList(String id) {

		List<RatingDTO> list = null;

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

			String sql = "SELECT M.ID AS MOVIE_ID, M.TITLE AS TITLE, M.TYPE AS TYPE, M.RUNTIME AS RUNTIME, M.START_DATE AS START_DATE, M.END_DATE AS END_DATE, M.RATING AS MOVIE_RATING"+
						", R.RATING AS MY_RATING, R.COMMENTS AS COMMENTS, G.NAME AS GENRE, RATEUSER, SUMOFRATING FROM MOVIE M, RATING R, ACCOUNT A, GENRE G WHERE G.ID = M.GENRE_ID AND R.M_ID = M.ID AND R.U_ID = A.ID AND A.USERNAME = '"+id+"' ORDER BY MOVIE_ID";
			rs = stmt.executeQuery(sql);
			
			System.out.println(sql);

			if (rs != null) {
				
				list = new ArrayList<RatingDTO>();
				while (rs.next()) {
					RatingDTO dto = new RatingDTO();
					
					dto.setMovie_id((rs.getInt("MOVIE_ID")));
					dto.setMovie_title((rs.getString("TITLE")));
					dto.setMovie_type((rs.getString("TYPE")));
					dto.setMovie_runtime(rs.getInt("RUNTIME"));
					dto.setMovie_start_date((rs.getString("START_DATE")));
					dto.setMovie_end_date((rs.getString("END_DATE")));
					dto.setMovie_rating((rs.getDouble("MOVIE_RATING")));
					dto.setMy_rating(rs.getDouble("MY_RATING"));
					dto.setMovie_genre(rs.getString("GENRE"));
					dto.setMy_comments(rs.getString("COMMENTS"));
					
					dto.setMovie_rating((double)rs.getDouble("SUMOFRATING")/(double)rs.getDouble("RATEUSER"));
					
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
	
	public RatingDTO Rating_info(String username, int movie_id) {

		RatingDTO dto = null;

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

			String sql = "SELECT M.ID AS MOVIE_ID, M.TITLE AS TITLE, M.TYPE AS TYPE, M.RUNTIME AS RUNTIME, M.START_DATE AS START_DATE, M.END_DATE AS END_DATE, M.RATING AS MOVIE_RATING"+
						", R.RATING AS MY_RATING, R.COMMENTS AS COMMENTS, G.NAME AS GENRE, RATEUSER, SUMOFRATING FROM MOVIE M, RATING R, ACCOUNT A, GENRE G WHERE G.ID = M.GENRE_ID AND R.M_ID = M.ID AND R.U_ID = A.ID AND A.USERNAME = '"+username+"' AND M.ID = "+movie_id+"";
			rs = stmt.executeQuery(sql);
			

			if (rs != null) {
				dto = new RatingDTO();
				while (rs.next()) {
					
					dto.setMovie_id((rs.getInt("MOVIE_ID")));
					dto.setMovie_title((rs.getString("TITLE")));
					dto.setMovie_type((rs.getString("TYPE")));
					dto.setMovie_runtime(rs.getInt("RUNTIME"));
					dto.setMovie_start_date((rs.getString("START_DATE")));
					dto.setMovie_end_date((rs.getString("END_DATE")));
					dto.setMovie_rating((rs.getDouble("MOVIE_RATING")));
					dto.setMy_rating(rs.getDouble("MY_RATING"));
					dto.setMovie_genre(rs.getString("GENRE"));
					dto.setMy_comments(rs.getString("COMMENTS"));
					
					dto.setMovie_rating((double)rs.getDouble("SUMOFRATING")/(double)rs.getDouble("RATEUSER"));
				}
			}
			con.close();
			rs.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
		return dto;
	}
	
	public List<RatingDTO> AllList() {

		List<RatingDTO> list = null;

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

			String sql = "SELECT A.USERNAME AS USERNAME, M.ID AS MOVIE_ID, M.TITLE AS TITLE, M.TYPE AS TYPE, M.RUNTIME AS RUNTIME, M.START_DATE AS START_DATE, M.END_DATE AS END_DATE, M.RATING AS MOVIE_RATING"+
						", R.RATING AS MY_RATING, R.COMMENTS AS COMMENTS, G.NAME AS GENRE, RATEUSER, SUMOFRATING FROM MOVIE M, RATING R, ACCOUNT A, GENRE G WHERE G.ID = M.GENRE_ID AND R.M_ID = M.ID AND R.U_ID = A.ID ORDER BY A.ID, M.ID";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				
				list = new ArrayList<RatingDTO>();
				while (rs.next()) {
					RatingDTO dto = new RatingDTO();
					
					dto.setMovie_id((rs.getInt("MOVIE_ID")));
					dto.setAccount_username((rs.getString("USERNAME")));
					dto.setMovie_title((rs.getString("TITLE")));
					dto.setMovie_type((rs.getString("TYPE")));
					dto.setMovie_runtime(rs.getInt("RUNTIME"));
					dto.setMovie_start_date((rs.getString("START_DATE")));
					dto.setMovie_end_date((rs.getString("END_DATE")));
					dto.setMovie_rating((rs.getDouble("MOVIE_RATING")));
					dto.setMy_rating(rs.getDouble("MY_RATING"));
					dto.setMovie_genre(rs.getString("GENRE"));
					dto.setMy_comments(rs.getString("COMMENTS"));
					
					dto.setMovie_rating((double)rs.getDouble("SUMOFRATING")/(double)rs.getDouble("RATEUSER"));
					
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
	
	public boolean insertRate(int user_id, int movie_id, int rating, String comments) {

		Connection con = null;
		Statement stmt = null;
		boolean success_flag = false;
		
		
		if(comments.replaceAll(" ", "").equals("")) {
			comments = "null";
		}
		else {
			comments = "'"+comments+"'";
		}

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
			
			String sql = "INSERT INTO RATING VALUES ("+movie_id+", "+user_id+", "+rating+", "+comments+")";
			
			
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
