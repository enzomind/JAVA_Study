package teampj;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Processing extends ConnectDB {

	public ArrayList<Common> ListView() throws SQLException {

//		int i = 0; int j = 0;

//		Scanner sc = new Scanner(System.in);
		conn = ConnectDB.MYSQLDBC();

		System.out.println("====================================================");
		System.out.printf("REPORT MANAGEMENT SYSTEM\n");

		String sql = "select * from";
		System.out.println("====================================================");
		System.out.printf("이름\t국어\t수학\t영어\t총점\t평균\n");
		System.out.println("====================================================");

		ResultSet rs = null;
		Statement stmt = conn.createStatement(); // PrepareStatement와 차이가 뭔지 노션에 적어
//		rs = stmt.executeQuery("select name, kor, math, eng, kor+math+eng, (kor+math+eng)/3 from member");
		rs = stmt.executeQuery("SELECT * FROM member");
		
		ArrayList<Common> list = new ArrayList<Common>();

		while (rs.next()) {
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int math = rs.getInt("math");
			int eng = rs.getInt("eng");

			list.add(new Common(name, kor, math, eng));
		}

		return list;

//			while (rs.next()) {			
//				System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\n", rs.getString("name"), rs.getInt(2), rs.getInt("math"), rs.getInt(4), rs.getInt(5), rs.getDouble(6));
//				i++; // 페이지당 레이블을 5개씩 보여주기위한 변수
//				
//				if(i%5==0) {
//					j++;
//					System.out.println("====================================================");
//					System.out.println("\t\t\t\t\t" + j + "페이지\n\n\n");
//					System.out.println("다음 페이지 조회를 위해 Enter를 눌러주세요.");
//					String choice = sc.nextLine();
//					
//					if(choice.length() == 0) {
//						System.out.println("====================================================");
//						
//						continue;
//					}
//				}
//			}
//			Date now = new Date();        
////			String nowTime = now.toString();        
////			System.out.println("DB Connetion Time : " + nowTime); // 서버 기준 현재 시간 보여주는 함수
//			System.out.println("====================================================");
//		} catch (SQLException e) {
//			System.out.println("조회 중에 오류가 발생했습니다.");
//		}
////		

//		conn.close();
//		System.out.println("\t\t\t\t\t" + (j+1)+ "페이지");
//		System.out.printf("원하시는 메뉴의 번호를 입력해 주세요.\n\n");
//		System.out.printf("1.조회\t2.등록\t3.수정\t4.삭제\n");
//		System.out.printf("번호 입력 : ");
//		ActionController ac = new ActionController();
//		ac.Choose();

	}
}
