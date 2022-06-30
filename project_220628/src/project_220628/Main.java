package project_220628;

public class Main {

	static String mid ;
	
	public static void main(String[] ar) {

		
		Login login = new Login();
		BoardShow show = new BoardShow();
		BoardInput input = new BoardInput();
		
		mid = login.login();
	
		//게시판 입력 생략하고싶으면 아래 주석처리
//		input.input();
		
		
		show.show();
		
		
	}

}
