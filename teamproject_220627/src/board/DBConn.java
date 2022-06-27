package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection conn = null;
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//url포함 아래 변수들을 수정못하게 final로 처리
		final String id = "c##hr";
		final String pw = "hr";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		conn = DriverManager.getConnection(url, id, pw);
				
		return conn;
		
	}
}

