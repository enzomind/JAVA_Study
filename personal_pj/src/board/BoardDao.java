package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	String sql;

	public BoardDao() {

		try {
			String driverName = "oracle.jdbc.driver.OracleDriver";
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "c##hr";
			String dbPW = "hr";

			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

		} catch (ClassNotFoundException e) {
			System.out.println("로그 : DB 드라이브 로딩 실패 : " + e.toString());
		} catch (SQLException sqle) {
			System.out.println("로그 : DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("로그 : 원인모를 에러 발생");
			e.printStackTrace();
		}

	}

	public int login(String mid, String mpw) {

		sql = "SELECT mpw FROM member WHERE mid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(mpw)) {
					return 1; // 비밀번호가 맞으면 1 리턴
				} else
					return 0; // 비밀번호가 맞지 않으면 0 리턴
			}
			return -1; // 이도 저도 아니면 -1

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 근데 이 와중에 DB 오류 발생하면, 걍 대충 가까운 숫자 -2 리턴
	}

	public int join() {
		return 1;
	}

	public ArrayList<Board> getList() throws SQLException {
		ArrayList<Board> list = new ArrayList<Board>();

		sql = "SELECT * FROM board";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			Board bd = new Board();
			bd.setBno(rs.getInt(1));
			bd.setMid(rs.getString(2));
			bd.setTitle(rs.getString(3));
			bd.setWcontents(rs.getString(4));
			bd.setWdate(rs.getString(5));
			list.add(bd);
		}

		return list;
	}
	
	
	public ArrayList<Board> viewDetail(int bno) throws SQLException {
		ArrayList<Board> list = new ArrayList<Board>();
		
		sql = "SELECT * FROM board WHERE bno = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board bd = new Board();
			bd.setBno(rs.getInt(1));
			bd.setMid(rs.getString(2));
			bd.setTitle(rs.getString(3));
			bd.setWcontents(rs.getString(4));
			bd.setWdate(rs.getString(5));
			list.add(bd);
		}
		
		return list;
	}

}
