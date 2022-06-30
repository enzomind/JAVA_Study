package project_220628;



import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {

	//로그인 기능
	public Board login(SqlSession ses, Board board) {
		Board result = ses.selectOne("teamproject.login", board);
		return result;
	}
	

	
	//게시판 기능
	public int insertListDao(SqlSession ses, Board board) {
		int result = ses.insert("teamproject.insert", board);

		return result;
	}

	public List<Board> selectListDao(SqlSession ses) {
		List<Board> result = ses.selectList("teamproject.selectList");

		return result;
	}


	public List<Board> detailDao(SqlSession ses, Board board) {
		List<Board> result = ses.selectList("teamproject.detail",board);
		return result;
	}

	public int modifyDao(SqlSession ses, Board board) {
		int result = ses.update("teamproject.modify", board);

		return result;
	}
	
	public int deleteDao(SqlSession ses, Board board) {
		int result = ses.delete("teamproject.delete", board);
		
		return result;
	}
	
	public int deleteSecureDao(SqlSession ses, Board board) {
		int result = ses.delete("teamproject.deleteSecure", board);

		return result;
	}
	
}

