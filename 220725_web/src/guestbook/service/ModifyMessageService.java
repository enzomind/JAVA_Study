package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ModifyMessageService {

	private static ModifyMessageService instance = new ModifyMessageService();

	public static ModifyMessageService getInstance() {
		return instance;
	}

	private ModifyMessageService() {
	}

	public void check(int messageId, String password) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			MessageDao messageDao = MessageDao.getInstance();
			Message message = messageDao.select(conn, messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지 없음");
			}
			if (!message.matchPassword(password)) {
				throw new InvalidPassowrdException("bad password");
			}
			
		} catch (SQLException ex) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("DB 접속 실패" + ex.getMessage(), ex);
		} catch (InvalidPassowrdException | MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public void modify(Message message) {
		Connection conn = null;
	
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			messageDao.modify(conn, message);

		
		} catch (SQLException e) {
			throw new ServiceException(
					"메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Message select(int id) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			
			return messageDao.select(conn, id);
			
		}catch (SQLException e) {
			throw new ServiceException(
					"메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
		
	}
	
	
}