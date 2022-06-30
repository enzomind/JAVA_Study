package project_220628;


import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

public class BoardService {
	
	private BoardDao bdao= new BoardDao();
	SqlSession ses = SqlSessionTemplate.getSession(); // SQLSessionTemplate 클래스 내 getSession

	public int insertBoardData(Board board) {
		 
		int result = bdao.insertListDao(ses, board);
		
		if(result>0) {
			ses.commit();
		}else {
			ses.rollback();
		}
		
		ses.close();
		
		return result;
	}
	
	public List<Board> selectBoardData() { //보드 클래스 참조
		List<Board> list = bdao.selectListDao(ses);
		
		return list;
	}
	
	public List<Board> showDetail(Board num) {
		List<Board> list = bdao.showDetailDao(ses, num);
		return list;
	}
	
	public int modifyBoardData(Board board) {
		 
		int result = bdao.modifyDao(ses, board);
		
		if(result>0) {
			ses.commit();
		}else {
			ses.rollback();
		}
		
		ses.close();
		
		return result;
	}
	
	public int deleteBoardData(Board board) {
		
		int result = bdao.deleteDao(ses, board);
		
		if(result>0) {
			ses.commit();
		}else {
			ses.rollback();
		}
		
		ses.close();
		return result;
	}
}
