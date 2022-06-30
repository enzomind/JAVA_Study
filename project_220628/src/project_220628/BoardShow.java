package project_220628;

import java.util.Scanner;

public class BoardShow {
	
	BoardService bds = new BoardService();
	BoardDetail detail = new BoardDetail();
	Scanner sc = new Scanner(System.in);
	
	public void show() {
		
		System.out.println("자유게시판 조회 =====================");

		System.out.printf("%s\t%s\t%s\t\t%s\t\t%s\n", "번호", "작성자", "제목", "내용", "작성일자");
		for (Board boardshow : bds.selectBoardData()) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", boardshow.bno, boardshow.mid, boardshow.title,
					boardshow.wcontents.substring(0, 11), boardshow.wdate);
		}
		
		
		System.out.printf("\n\n\n%s", "상세 조회할 게시글 번호를 입력하세요. >> ");
		detail.datail();
	}
}
