package teampj;

import java.sql.SQLException;
import java.util.Scanner;

public class Home {

	public void Choice(int j) throws SQLException {
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("\t\t\t\t\t" + (j+1)+ "페이지");
		System.out.printf("원하시는 메뉴의 번호를 입력해 주세요.\n\n");
		System.out.printf("1.조회\t2.등록\t3.수정\t4.삭제\n");
		System.out.printf("번호 입력 : ");
	
		int choiceNumber = sc.nextInt();

		switch (choiceNumber) {
		case 1:	
			Processing pcs = new Processing();
			pcs.ListView();
			
	
		case 2:
			DBInsert dbi= new DBInsert();
			dbi.Insert();
		}
	}

}