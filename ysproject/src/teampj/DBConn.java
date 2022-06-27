package teampj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  // mysql
	static final String DB_URL = "jdbc:mysql://localhost:3306/teampj_db?useSSL=false"; 
	static final String USERNAME = "root"; 
	static final String PASSWORD = "clwmtkfkd"; 
	
	static Connection conn = null;
	
	public static Connection MYSQLDBC() throws SQLException {
		
	
		try {
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); 
			
			if (conn != null) {
			return conn;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL Exception 에러 : " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
}