package teampj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class DBInsert extends ConnectDB{

	PreparedStatement ps = null;
	

	public void Insert() throws SQLException {

		Scanner sc = new Scanner(System.in);
		conn = ConnectDB.MYSQLDBC();
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
		
		
		DBView ac = new DBView();
		ac.View();
		}
	}

}
