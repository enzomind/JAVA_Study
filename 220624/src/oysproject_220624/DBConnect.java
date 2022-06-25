package oysproject_220624;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//두번째로 코딩

//각 클래스별 공통으로 사용하는 DB 연결부를 클래스로 만듬

public class DBConnect {
	private static Connection conn = null;
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//url포함 아래 변수들을 수정못하게 final로 처리
		final String id = "c##hr";
		final String pw = "hr";
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		conn = DriverManager.getConnection(url, id, pw);
				
		return conn;
		//해당 클래스 객체 호출 시, conn을 불러 사용할 수 있게 함.		
	}
}

