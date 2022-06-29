package project_220628;

import java.util.Scanner;

public class Main {

	public static void main(String[] ar) {

		BoardService bds = new BoardService();
		Scanner sc = new Scanner(System.in);

		// 입력 테스트
		// Board board = new Board();
		// board.mid = "oh123";
		// board.title = "테스트 제목 ";
		// board.wcontents = "자유게시판 내용 테스트";
		// board.div = "fr";
		//
		// int showdata = bds.insertBoardData(board);
		// System.out.println(showdata);

		// new Thread ( ()-> {
		// System.out.println("3. 자유게시판 =====================");
		// }).start();
		// 변수.substring (시작위치,길이)

		System.out.printf("%s\t%s\t%s\t\t%s\t\t%s\n", "번호", "작성자", "제목", "내용", "작성일자");
		for (Board board : bds.selectBoardData()) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", board.bno, board.mid, board.title,
					board.wcontents.substring(0, 11), board.wdate);
		}

		System.out.printf("\n\n\n");

		System.out.printf("상세 조회할 게시글 번호를 입력하세요.");
		int choicenumber = sc.nextInt();

		Board bd = new Board(choicenumber);

		if (bds.showDetail(bd).toString() == "[]") {
			System.out.println("데이터가 존재하지 않습니다.");
		} else {

			for (Board board : bds.showDetail(bd)) {
				System.out.printf("%s\t%s%d\n", "번호 ", ": ", board.bno);
				System.out.printf("%s\t%s%s\n", "제목 ", ": ", board.title);
				System.out.printf("%s\t%s%s\n", "작성자 ", ": ", board.mid);
				System.out.printf("%s\t%s%s\n\n", "내용 ", ": ", board.wcontents);
				System.out.printf("%s\t%s%s\n", "작성일자 ", ": ", board.wdate.substring(0, 10));
			}

		}

	}

}
