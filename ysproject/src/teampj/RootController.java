package teampj;

import java.sql.SQLException;
import java.util.Scanner;

public class RootController {

	public void control(int j) throws SQLException {
		
		DAO dao = new DAO();
		Scanner scan = new Scanner(System.in);		
		
		System.out.println("====================================================");
		System.out.println("\t\t\t\t\t" + (j+1)+ "페이지\n\n");
		
		System.out.println("==========================================================");
		System.out.printf("|원하시는 메뉴의 번호를 입력해 주세요. 1.조회  2.등록  3.수정  4.삭제 |\n");
		System.out.println("==========================================================");
		
		System.out.printf("번호 입력 : ");
		int cnum = scan.nextInt();

//		if(cnum == 1) {
//			
//		}
		
		switch (cnum) {
		case 1:	
			
			dao.selectDB();
			
			break;
			
		case 2:
			System.out.printf("\n\n\n");
			
			
			dao.insertDB();
			
			break;
		}
	}

}