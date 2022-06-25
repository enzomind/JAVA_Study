package teampj;

import java.sql.SQLException;
import java.util.Scanner;

public class DBView {

	public void View() throws SQLException {
	
		Processing pcs = new Processing();
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int j = 0;
		
		for(Common com : pcs.ListView()) {
			System.out.printf("%s\t%d\t%d\t%d\t", com.name, com.kor, com.math, com.eng);
			System.out.printf("%d\t",(com.kor+com.math+com.eng));
			double temp = (double)(com.kor+com.math+com.eng)/3;
			System.out.printf("%2.1f\n",temp);	
		
			i++;
		
			if(i%5==0) {
				j++;
				System.out.println("====================================================");
				System.out.println("\t\t\t\t\t" + j + "페이지\n\n\n");
				System.out.println("다음 페이지 조회를 위해 Enter를 눌러주세요.");
				String choice = sc.nextLine();
			
					if(choice.length() == 0) {
						System.out.println("====================================================");
				
						continue;
					}
//					else if () {} // 엔터키가 아닌 키 방지용인데 구현 못하겠음;
					
			}
		}
		
		Home home = new Home();
		home.Choice(j);
		
	}
}
