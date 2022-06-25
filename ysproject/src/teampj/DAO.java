package teampj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DAO extends DBConn {
	
	int i = 0;
	int j = 0;
	Scanner sc = new Scanner(System.in);
	PreparedStatement ps = null;
	
	
	public ArrayList<Common> start() throws SQLException {

		conn = DBConn.MYSQLDBC();

		System.out.println("====================================================");
		System.out.printf("REPORT MANAGEMENT SYSTEM\n");

		String sql = "select * from";
		System.out.println("====================================================");
		System.out.printf("학번\t이름\t국어\t수학\t영어\t총점\t평균\n");
		System.out.println("====================================================");

		ResultSet rs = null;
		Statement stmt = conn.createStatement(); 
		rs = stmt.executeQuery("SELECT * FROM member");
		
		ArrayList<Common> list = new ArrayList<Common>();

		while (rs.next()) {
			int number = rs.getInt("number");
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int math = rs.getInt("math");
			int eng = rs.getInt("eng");
			
			list.add(new Common(number, name, kor, math, eng));
		}
		return list;
	}
	
	public void selectDB() throws SQLException {
	
		for(Common com : start()) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t", com.no, com.name, com.kor, com.math, com.eng);
			System.out.printf("%d\t",(com.kor+com.math+com.eng));
			double temp = (double)(com.kor+com.math+com.eng)/3;
			System.out.printf("%2.1f\n",temp);	
			i++;
			
			if(i%5==0) {
				System.out.println("====================================================");
				System.out.println("\t\t\t\t\t" + (++j) + "페이지\n\n\n");
				System.out.println("다음 페이지 조회를 위해 Enter를 눌러주세요.");
				String choice = sc.nextLine();
			
					if(choice.length() == 0) {
						System.out.println("====================================================");
	
						continue;
					}
//					else if () {} // 엔터키가 아닌 키 방지용인데 구현 못하겠음;
			}
		}
		
		RootController rc = new RootController();
		rc.control(j);	
	}
	
	public void insertDB() throws SQLException {

		Scanner sc = new Scanner(System.in);
		conn = DBConn.MYSQLDBC();
		String sql = "insert into member(name, kor, math, eng) values(?,?,?,?)";
		
		System.out.println("=============================================");
		System.out.println("새로운 학생의 성적을 등록합니다. ");
		System.out.println("=============================================");
		
		
		while(true) {
		
		try {
			
			ps = conn.prepareStatement(sql);
			System.out.print("이름을 입력하세요 >> ");
			ps.setString(1, sc.nextLine());
			System.out.print("국어 점수를 입력하세요 >> ");
			ps.setInt(2, sc.nextInt());
			System.out.print("수학 점수를 입력하세요 >> ");
			ps.setInt(3, sc.nextInt());
			System.out.print("영어 점수를 입력하세요 >> ");
			ps.setInt(4, sc.nextInt());
			
			int rowCount = ps.executeUpdate();
			
			if(rowCount == 1) {
				System.out.println("등록이 정상적으로 완료되었습니다.");
//				System.out.print("계속 등록하시려면 'YES'를, 그만하시려면 'NO'를 입력해 주세요.");
//				String choose = sc.next();
//				if(choose.equals("YES")) {
//					continue;
//				}
			}else {
				break;
			}
			
		}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("업데이트 실패. 다시 시도하여 주십시오.");
		}
		
		ps.close();
		conn.close();
		
		
		DAO dao = new DAO();
		dao.selectDB();
		
		}
	}
	
}
