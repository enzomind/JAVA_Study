package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import guestbook.model.Message;
import jdbc.JdbcUtil;


public class MessageDao {
	
	int sum;
	double avg; 
	
	private static MessageDao messageDao = new MessageDao();

	public static MessageDao getInstance() {
		return messageDao;
	}

	private MessageDao() {
	}

	public int insert(Connection conn, Message message) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			
			pstmt = conn.prepareStatement("insert into student "
					+ "(student_name, password, korscore, mathscore, engscore, summury, avg, message) values (?, ?, ?, ?, ?, ?, round(?,2) , ?)");
			pstmt.setString(1, message.getStudentName());
			pstmt.setString(2, message.getPassword());
			pstmt.setLong(3, message.getKorScore());
			pstmt.setLong(4, message.getMathScore());
			pstmt.setLong(5, message.getEngScore());
			pstmt.setLong(6, sum = message.getKorScore() + message.getMathScore() + message.getEngScore());
			pstmt.setDouble(7, avg = (double) sum / 3.0);
			pstmt.setString(8, message.getMessage());
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public Message select(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return makeMessageFromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("id"));
		message.setStudentName(rs.getString("student_name"));
		message.setPassword(rs.getString("password"));
		message.setKorScore(rs.getInt("korscore"));
		message.setMathScore(rs.getInt("mathscore"));
		message.setEngScore(rs.getInt("engscore"));

		message.setSummury(rs.getInt("summury"));
		message.setAvg(rs.getDouble("avg"));
		
		message.setMessage(rs.getString("message"));
		return message;
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from student");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from student " + "order by id desc limit ?, ?");
			pstmt.setInt(1, firstRow - 1);
			pstmt.setInt(2, endRow - firstRow + 1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Message> messageList = new ArrayList<Message>();
				do {
					messageList.add(makeMessageFromResultSet(rs));
				} while (rs.next());
				return messageList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int delete(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from student where id = ?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public int modify(Connection conn, Message message) throws SQLException {
		PreparedStatement pstmt = null;
			
		try {
			pstmt = conn.prepareStatement("UPDATE student SET "
				+ "student_name = ?, korscore=?, mathscore=?, engscore=?, summury=?, avg=?, message=? where id = ?");
			
			pstmt.setString(1, message.getStudentName());
			pstmt.setLong(2, message.getKorScore());
			pstmt.setLong(3, message.getMathScore());
			pstmt.setLong(4, message.getEngScore());
			pstmt.setLong(5, sum = message.getKorScore() + message.getMathScore() + message.getEngScore());
			pstmt.setDouble(6, (double)sum / 3);
			pstmt.setString(7, message.getMessage());
			pstmt.setInt(8, message.getId());
			return pstmt.executeUpdate();
		
		} finally {
			JdbcUtil.close(pstmt);
		}
		
	}

}
