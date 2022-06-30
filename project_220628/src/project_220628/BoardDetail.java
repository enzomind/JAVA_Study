package project_220628;

import java.util.Scanner;

public class BoardDetail {

	Scanner sc = new Scanner(System.in);
	BoardService bds = new BoardService();
	static int bno;
	static String mid;
	
	public void datail() {

		Board getnumber = new Board(sc.nextInt());

		if (bds.showDetail(getnumber).toString() == "[]") {
			System.out.println("데이터가 존재하지 않습니다.");
		} else {

			System.out.printf("\n\n\n");
			for (Board boarddetail : bds.showDetail(getnumber)) {
				System.out.printf("%s\t%s%d\n", "번호 ", ": ", boarddetail.getBno());
				System.out.printf("%s\t%s%s\n", "제목 ", ": ", boarddetail.getTitle());
				System.out.printf("%s\t%s%s\n", "작성자 ", ": ", boarddetail.getMid());
				System.out.printf("%s\t%s%s\n", "내용 ", ": ", boarddetail.getWcontents());
				// System.out.printf("%s\t%s%s\n\t%s%s\n", "내용 ", ": ",
				// boarddetail.wcontents.substring(0, 30), " ",
				// boarddetail.wcontents.substring(30, 58));

				// out of range 에러가 발생해서 가변적으로 데이터 삽입해서 불러오는걸 잠시 보류함.
				// 테스트해보고싶으면 해당 부분 주석 풀고 아래 테스트 데이터로 테스트해보면 됨.
				//
				// 제목--
				// 질문이 있습니다.
				//
				// 내용--
				// 안녕하세요. 제가 질문이 하나 있는데요. 개인이 인텔리제이 무료버전을 사용하고 싶으면 어떻게 해야하나요?
				
				System.out.printf("%s\t%s%s\n", "작성일자 ", ": ", boarddetail.getWdate().substring(0, 10));
				bno = boarddetail.getBno();
				
			}
			// 선생님께 드릴 질문
			// 1. 인터넷 검색 결과 SQL쿼리가 아닌 자바단에서 substring을 통해 문자열 끊기가 가능하다고 함. but 적은 데이터가
			// 들어왔을때, 너무많은 레인지를 잡게되면 에러가 남. 방법이 없는지?

		}
		
		System.out.print("해당 게시글을 수정하시려면 1을, 삭제하시려면 2를, 돌아가시려면 3을 입력해주세요. >> ");

		
		switch (sc.nextInt()) {
		
		case 1 :
			BoardModify modify = new BoardModify();
			modify.modify(bno);
			break;
			
//		case 2 :
//			BoardDelete delete = new BoardDelete();
//			delete.delete(bno);
//			break;
			
		case 2 : 
			BoardDeleteSecure secure = new BoardDeleteSecure();
			secure.deleteSecure(bno, Main.mid);
			break;
			
		
		case 3 :
			BoardShow show = new BoardShow();
			show.show();		
			
		
		
		}

	}

}
