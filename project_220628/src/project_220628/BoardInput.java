package project_220628;


import java.util.Scanner;

import project_220628.*;

public class BoardInput {

	public void input() {
		BoardService bds = new BoardService();
		Scanner sc = new Scanner(System.in);
		Board boardinput = new Board();

		System.out.println("3. 자유게시판 글 작성하기 =====================");
		
		// ID (추후 불러오는 것으로 구현)
		boardinput.mid = "oh123";

		// 제목 입력
		System.out.print("제목을 입력하세요. >> ");
		boardinput.title = sc.nextLine();

		// 내용 입력
		System.out.print("내용을 입력하세요. >> ");
		boardinput.wcontents = sc.nextLine();

		// 게시판 유형 자동 지정
		boardinput.div = "any";
	
		int check = bds.insertBoardData(boardinput);
		
		if(check==1) {
			System.out.printf("%s\n\n","정상적으로 저장되었습니다.");
		}else {
			System.out.println("Insert 에러 발생");
		}
//			
	}
	
}
