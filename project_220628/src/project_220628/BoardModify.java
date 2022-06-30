package project_220628;

import java.util.Scanner;

public class BoardModify {

	public void modify(int bno) {
		BoardService bds = new BoardService();
		Scanner sc = new Scanner(System.in);
		Board boardmodify = new Board();

		System.out.println("수정하기 ==================================");

		// 제목 수정
		boardmodify.bno = bno;
		System.out.print("제목을 입력하세요. >> ");
		boardmodify.title = sc.nextLine();

		// 내용 수정
		System.out.print("내용을 입력하세요. >> ");
		boardmodify.wcontents = sc.nextLine();

		int check = bds.modifyBoardData(boardmodify);

		if (check == 1) {
			System.out.printf("%s\n\n","정상적으로 수정되었습니다.");
			BoardShow show = new BoardShow();
			show.show();
		} else {
			System.out.println("Update 에러 발생");
		}

	}

}
