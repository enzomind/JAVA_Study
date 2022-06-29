package project_220628;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {

	public int insertListDao(SqlSession ses, Board board) {
		int result = ses.insert("teamproject.insertMapper", board);

		return result;
	}

	public List<Board> selectListDao(SqlSession ses) {
		List<Board> result = ses.selectList("teamproject.selectlistMapper");

		return result;
	}


	public List<Board> showDetail(SqlSession ses, Board board) {
		List<Board> result = ses.selectList("teamproject.showDetailMapper",board);
		return result;
	}

}

