package project_220628;

import java.util.Scanner;

public class Login {

	boolean count;

	public String login() {
		BoardService service = new BoardService();
		Scanner sc = new Scanner(System.in);

		System.out.print("ID >> ");
		String mid = sc.nextLine();

		System.out.print("PW >> ");
		String mpw = sc.nextLine();

		Board board = new Board(mid, mpw);

		if (service.login(board) != null) {
			System.out.printf("\n로그인이 완료되었습니다.\n\n");
			count = true;
		} else {
			System.out.println("ID나 PW를 다시 확인하여 주십시오.");
			login();
			count = true;
		}

		return mid;

	}
}
