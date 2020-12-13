package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import resource.R;

public class MovieDAO implements R {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";

	public List<MovieDTO> list_for_all() {

		List<MovieDTO> list = null;

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

			String sql = "SELECT M.ID AS MOVIE_ID, M.TITLE AS TITLE, M.TYPE AS TYPE, M.RUNTIME AS RUNTIME, M.START_DATE AS START_DATE, M.END_DATE AS END_DATE, G.NAME AS GENRE_NAME, RATING, RATEUSER, SUMOFRATING FROM MOVIE M, GENRE G WHERE M.GENRE_ID = G.ID ORDER BY M.ID";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				
				list = new ArrayList<MovieDTO>();
				while (rs.next()) {
					MovieDTO dto = new MovieDTO();
					
					dto.setId(rs.getInt("MOVIE_ID"));
					dto.setTitle(rs.getString("TITLE"));
					dto.setType(rs.getString("TYPE"));
					dto.setRuntime(rs.getInt("RUNTIME"));
					dto.setStart_date(rs.getString("START_DATE"));
					dto.setEnd_date(rs.getString("END_DATE"));
					dto.setGenre(rs.getString("GENRE_NAME"));
					dto.setRating(rs.getDouble("RATING"));
					dto.setRateUser(rs.getInt("RATEUSER"));
					dto.setSumOfRating(rs.getDouble("SUMOFRATING"));
					
					double real_rating;
					
					if(rs.getInt("RATEUSER") == 0) {
						real_rating = 0;
					}
					else {
						real_rating = ((double)rs.getDouble("SUMOFRATING")/(double)rs.getInt("RATEUSER"));
					}
					dto.setRating(real_rating);
					
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
	
	public List<MovieDTO> list_for_all_with_director() {

		List<MovieDTO> list = null;

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

			String sql = "SELECT M.ID AS MOVIE_ID, M.TITLE AS TITLE, M.TYPE AS TYPE, M.RUNTIME AS RUNTIME, M.START_DATE AS START_DATE, M.END_DATE AS END_DATE, G.NAME AS GENRE_NAME, RATING, RATEUSER, SUMOFRATING FROM MOVIE M, GENRE G WHERE M.GENRE_ID = G.ID ORDER BY M.ID";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				
				list = new ArrayList<MovieDTO>();
				while (rs.next()) {
					MovieDTO dto = new MovieDTO();
					
					dto.setId(rs.getInt("MOVIE_ID"));
					dto.setTitle(rs.getString("TITLE"));
					dto.setType(rs.getString("TYPE"));
					dto.setRuntime(rs.getInt("RUNTIME"));
					dto.setStart_date(rs.getString("START_DATE"));
					dto.setEnd_date(rs.getString("END_DATE"));
					dto.setGenre(rs.getString("GENRE_NAME"));
					dto.setRating(rs.getDouble("RATING"));
					dto.setRateUser(rs.getInt("RATEUSER"));
					dto.setSumOfRating(rs.getDouble("SUMOFRATING"));
					
					double real_rating;
					
					if(rs.getInt("RATEUSER") == 0) {
						real_rating = 0;
					}
					else {
						real_rating = ((double)rs.getDouble("SUMOFRATING")/(double)rs.getInt("RATEUSER"));
					}
					dto.setRating(real_rating);
					
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
	
	public List<MovieDTO> list_for_title_search(int client_id, String title) {

		List<MovieDTO> list = null;

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

			String sql = "SELECT M.ID AS MOVIE_ID, M.TITLE AS TITLE, M.TYPE AS TYPE, M.RUNTIME AS RUNTIME, M.START_DATE AS START_DATE, M.END_DATE AS END_DATE, G.NAME AS GENRE_NAME, M.RATING AS RATING, RATEUSER, SUMOFRATING "
					+"FROM MOVIE M, GENRE G "
					+"WHERE NOT EXISTS (SELECT * FROM RATING WHERE U_ID= "+client_id+" AND M_ID = M.ID) AND "+"M.GENRE_ID = G.ID AND M.TITLE LIKE '%"+title+"%'";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				list = new ArrayList<MovieDTO>();
				while (rs.next()) {
					MovieDTO dto = new MovieDTO();
					
					dto.setId(rs.getInt("MOVIE_ID"));
					dto.setTitle(rs.getString("TITLE"));
					dto.setType(rs.getString("TYPE"));
					dto.setRuntime(rs.getInt("RUNTIME"));
					dto.setStart_date(rs.getString("START_DATE"));
					dto.setEnd_date(rs.getString("END_DATE"));
					dto.setGenre(rs.getString("GENRE_NAME"));
					dto.setRating(rs.getDouble("RATING"));
					dto.setRateUser(rs.getInt("RATEUSER"));
					dto.setSumOfRating(rs.getDouble("SUMOFRATING"));
					
					double real_rating;
					
					if(rs.getInt("RATEUSER") == 0) {
						real_rating = 0;
					}
					else {
						real_rating = ((double)rs.getDouble("SUMOFRATING")/rs.getInt("RATEUSER"));
					}
					dto.setRating(real_rating);
					
					
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
	
	public List<MovieDTO> list_for_condition_search(int client_id, String type, String genre, String version) {

		List<MovieDTO> list = null;

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

			String sql = "SELECT M.ID AS MOVIE_ID, M.TITLE AS TITLE, M.TYPE AS TYPE, M.RUNTIME AS RUNTIME, M.START_DATE AS START_DATE, M.END_DATE AS END_DATE, G.NAME AS GENRE_NAME, M.RATING AS RATING, RATEUSER, SUMOFRATING, V.V_TITLE AS V_TITLE, N.SHORT_NAME AS SHORT_NAME "
					+"FROM MOVIE M, GENRE G, VERSION V, NATIONALITY N "
					+"WHERE M.GENRE_ID = G.ID AND M.ID = V.M_ID AND V.N_ID = N.ID ";
			
			if(!type.equals("no")) {
				sql = sql+"AND M.TYPE = '"+type+"' ";
			}
			if(!genre.equals("no")) {
				sql = sql+"AND G.NAME = '"+genre+"' ";
			}
			if(!version.equals("no")) {
				sql = sql+"AND N.SHORT_NAME = '"+version+"' ";
			}
			
			
			sql = sql+"AND NOT EXISTS (SELECT * FROM RATING R WHERE U_ID= "+client_id+" AND R.M_ID = M.ID) AND "+"M.GENRE_ID = G.ID";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				list = new ArrayList<MovieDTO>();
				while (rs.next()) {
					MovieDTO dto = new MovieDTO();
					
					dto.setId(rs.getInt("MOVIE_ID"));
					dto.setTitle(rs.getString("V_TITLE"));
					dto.setType(rs.getString("TYPE"));
					dto.setRuntime(rs.getInt("RUNTIME"));
					dto.setStart_date(rs.getString("START_DATE"));
					dto.setEnd_date(rs.getString("END_DATE"));
					dto.setGenre(rs.getString("GENRE_NAME"));
					dto.setRating(rs.getDouble("RATING"));
					dto.setRateUser(rs.getInt("RATEUSER"));
					dto.setSumOfRating(rs.getDouble("SUMOFRATING"));
					dto.setVersion(rs.getString("SHORT_NAME"));
					
					double real_rating;
					
					if(rs.getInt("RATEUSER") == 0) {
						real_rating = 0;
					}
					else {
						real_rating = ((double)rs.getDouble("SUMOFRATING")/rs.getInt("RATEUSER"));
					}
					dto.setRating(real_rating);
					
					
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
	
	public MovieDTO detailInfo(int id) {

		MovieDTO dto = null;

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

			String sql = "SELECT M.ID AS MOVIE_ID, M.TITLE AS TITLE, M.TYPE AS TYPE, M.RUNTIME AS RUNTIME, M.START_DATE AS START_DATE, M.END_DATE AS END_DATE, G.NAME AS GENRE_NAME, M.RATING AS RATING, RATEUSER, SUMOFRATING FROM MOVIE M, GENRE G WHERE M.GENRE_ID = G.ID AND M.ID = "+id;
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				dto = new MovieDTO();
				while (rs.next()) {
					
					dto.setId(rs.getInt("MOVIE_ID"));
					dto.setTitle(rs.getString("TITLE"));
					dto.setType(rs.getString("TYPE"));
					dto.setRuntime(rs.getInt("RUNTIME"));
					dto.setStart_date(rs.getString("START_DATE"));
					dto.setEnd_date(rs.getString("END_DATE"));
					dto.setGenre(rs.getString("GENRE_NAME"));
					dto.setRating(rs.getDouble("RATING"));
					dto.setRateUser(rs.getInt("RATEUSER"));
					dto.setSumOfRating(rs.getDouble("SUMOFRATING"));
					
					double real_rating;
					
					if(rs.getInt("RATEUSER") == 0) {
						real_rating = 0;
					}
					else {
						real_rating = ((double)rs.getDouble("SUMOFRATING")/(double)rs.getDouble("RATEUSER"));
					}
					dto.setRating(real_rating);
					
					
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
	
	
	public void showDirector(int id) {

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

			String sql = "SELECT D.NAME AS NAME FROM PRODUCED_BY P, DIRECTOR D WHERE P.D_ID = D.ID AND P.M_ID = "+id;
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				
				System.out.print(" [제작]      : ");
				
				while (rs.next()) {
					System.out.println(rs.getString("NAME"));
				}
			}
			else {
				System.out.println(" [제작]      : "+"(정보 없음)");
			}
			
			
			con.close();
			rs.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public void showActors(int id) {

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

			String sql = "SELECT A.NAME AS NAME FROM PARTICIPATE_IN P, ACTOR A WHERE P.A_ID = A.ID AND P.M_ID = "+id;
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				System.out.print(" [출연]      : ");
				while (rs.next()) {
					System.out.print(rs.getString("NAME"));
				}
				System.out.println("");
			}
			else {
				System.out.println(" [출연]      : (정보 없음)");
			}
			
			
			con.close();
			rs.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public void showEpisode(int id) {

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

			String sql = "SELECT E_TITLE, S_NUMBER, E_NUMBER, E_RUNTIME FROM EPISODE WHERE M_ID = "+id+" ORDER BY S_NUMBER, E_NUMBER";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				System.out.println(" [에피소드 목록]");
				System.out.println("     -------------------------------------------------------------------------------------------------");
				System.out.println("     | season | episode number |                    episode title                  | episode runtime |");
				System.out.println("     -------------------------------------------------------------------------------------------------");
				
				while (rs.next()) {
					System.out.printf("     |   %2d   |       %2d       | %-50s|       %3d       |\n",rs.getInt("S_NUMBER"), rs.getInt("E_NUMBER"), rs.getString("E_TITLE"), rs.getInt("E_RUNTIME"));
					System.out.println("     -------------------------------------------------------------------------------------------------");
				}
			}
			else {
				System.out.println(" [에피소드 목록]");
				System.out.println("     -------------------------------------------------------------------------------------------------");
				System.out.println("     | season | episode number |                    episode title                  | episode runtime |");
				System.out.println("     -------------------------------------------------------------------------------------------------");
				System.out.println("     |                              정보 없음                                                           |");
				System.out.println("     -------------------------------------------------------------------------------------------------");
				
			}
			
			
			con.close();
			rs.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public void showVersion(int id) {

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

			String sql = "SELECT DISTINCT N.SHORT_NAME AS SHORT_NAME FROM NATIONALITY N, VERSION V WHERE M_ID = "+id;
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				System.out.print(" [영상물 버전] : ");
				
				while (rs.next()) {
					System.out.print("{" +rs.getString("SHORT_NAME")+"} ");
				}
				System.out.println("");
			}
			else {
				System.out.println(" [영상물 버전] : (정보 없음)");
			}
			
			
			con.close();
			rs.close();
			stmt.close();
			
		} catch (SQLException ex2) {
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public boolean insertMovie() {
		Connection conn = null;
		Statement stmt = null;

		String sql = "";
		boolean success_flag = false;
		
		int row_id = 0;
		int genre_id = 0;
		int nationality_id = 0;
		
		String title = req.get("i_title").toString();
		String type = req.get("i_type").toString();
		int runtime = (int)req.get("i_runtime");
		String genre = req.get("i_genre").toString();
		String start_date = req.get("i_start_date").toString();
		String nationality = req.get("i_original_version").toString();


		
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

			sql = "SELECT ID FROM MOVIE ORDER BY ID ASC";
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

			sql = "SELECT ID FROM GENRE WHERE NAME = '"+genre+"' ORDER BY ID ASC";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.last();
			if(rs.getRow() == 0) {
				genre_id = 0;
			}
			else {
				genre_id = rs.getInt("ID");
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

			sql = "SELECT ID FROM NATIONALITY WHERE SHORT_NAME = '"+nationality+"' ORDER BY ID ASC";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.last();
			if(rs.getRow() == 0) {
				nationality_id = 0;
			}
			else {
				nationality_id = rs.getInt("ID");
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
			
			sql = "INSERT INTO MOVIE(ID, TITLE, TYPE, RUNTIME, START_DATE, GENRE_ID)";
			
			sql +=" VALUES(";
			sql += row_id;
			sql += ", ";
			sql += "'";
			sql += title;
			sql += "'";
			sql += ", ";
			sql += "'";
			sql += type;
			sql += "'";
			sql += ", ";
			sql += runtime;
			sql += ", ";
			sql += "TO_DATE('"+start_date+"', 'yyyy-mm-dd')";
			sql += ", ";
			sql += genre_id;
			sql += ")";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0)
				success_flag = true;

		} catch (SQLException ex2) {
			System.out.println(sql);
			System.err.println("sql error = " + ex2.getLocalizedMessage());
			System.exit(1);
		}
		
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		            ResultSet.CONCUR_UPDATABLE);
			
			sql = "INSERT INTO VERSION(M_ID, N_ID, V_TITLE, IS_ORIGINAL)";
			
			sql +=" VALUES(";
			sql += row_id;
			sql += ", ";
			sql += nationality_id;
			sql += ", ";
			sql += "'";
			sql += title;
			sql += "'";
			sql += ", ";
			sql += "'True'";
			sql += ")";
			
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
	
	public boolean dropMovie(int id) {
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

			String sql = "DELETE FROM MOVIE WHERE ID = "+id;

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
