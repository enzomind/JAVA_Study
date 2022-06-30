package project_220628;

public class BoardDelete {

	public void delete(int bno) {
		
		BoardService bds = new BoardService();
		Board boarddelete = new Board();

		boarddelete.setBno(bno);

		int check = bds.deleteBoardData(boarddelete);

		if (check == 1) {
			System.out.printf("%s\n\n","정상적으로 삭제되었습니다.");
			BoardShow show = new BoardShow();
			show.show();
		} else {
			System.out.println("Delete 에러 발생");
		}
		
	}
	
}
