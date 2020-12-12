package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USER_UNIVERSITY = "knumovie";
	public static final String USER_PASSWD = "comp322";

	public List<GenreDTO> list_for_all() {

		List<GenreDTO> list = null;

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

			String sql = "SELECT ID, NAME FROM GENRE ORDER BY NAME";
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				
				list = new ArrayList<GenreDTO>();
				while (rs.next()) {
					GenreDTO dto = new GenreDTO();
					
					dto.setId(rs.getInt("ID"));
					dto.setName(rs.getString("NAME"));
					
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
}
