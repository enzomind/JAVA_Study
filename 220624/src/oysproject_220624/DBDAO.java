package oysproject_220624;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBDAO {
	private Connection conn;
	String sql = null; //각 메소드의 SQL을 타이핑해야겠음
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Connection connect() throws ClassNotFoundException, SQLException {
		conn = DBConnect.getConn();
		//이제 connect 클래스 호출하면 conn을 리턴해줘서 쿼리 실행 전 필수인 DB접속을 하게 해줄꺼임!
		return conn;
	}
	
	//인풋을 해보자
	public int input(EMP emp) throws SQLException {
		PreparedStatement ps = null;
		String sql = "INSERT INTO oysemp (emp_no, emp_name) values (?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setInt(1, emp.number); 
		ps.setString(2, emp.name);
		
		int result = ps.executeUpdate(); 
//		execute : 테이블 생성, 수정, 삭제 등 데이터베이스 관리 시, 사용 (create - )
//		executeUpdate : 레코드 삽입, 수정, 삭제 등 데이터 조작 시, 사용 (insert, update, delete - )
//		executeQuery : 레코드 조회, 테이블 조회 등 조회 명령어 사용 (select - )
		return result;
	}

//	일단 여까지 작성하고 다시 루트컨트롤러쪽 작성 해보러 출발!
//	다시 루트컨트롤러쪽에서 버튼 이벤트에 대한 메소드 작성하다가 데이터 받아오는 메소드 필요해서 다시 돌아옴!

	public EMP getemp(int number) throws SQLException { //넘버 가져와서 그에 해당하는 데이터 뿌림
		
		sql = "SELECT emp_no, emp_name FROM oysemp WHERE emp_no = ?";
		ps = conn.prepareStatement(sql);
		
		ps.setInt(1, number);
		rs = ps.executeQuery();
		if (rs.next()) { //이 부분을 좀따 리스트뷰에다 적용할 수 있을거같은데?
			int num_data = rs.getInt("emp_no");
			String name_data = rs.getString("emp_name");
			EMP emp = new EMP(num_data, name_data);
			return emp;
		}
		
		return new EMP(number, "name"); //받아온 넘버랑 String 값 던짐
	}

	//데이터 받아오는 메소드 작성했으니 다시 여기까지하고 루트컨트롤러쪽 넘어가자!
	
	public int modify(EMP emp) throws SQLException {
		sql = "UPDATE oysemp SET emp_name = ? where emp_no = ?";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, emp.name);
		ps.setInt(2, emp.number);
		
		int result = ps.executeUpdate();
		return result;
	}
	
	public ArrayList<EMP> select() throws SQLException {
		sql = "SELECT * FROM oysemp";
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		ArrayList<EMP> list = new ArrayList<EMP>();
		
		while(rs.next()) {
			int number = rs.getInt("emp_no");
			String name = rs.getString("emp_name");
			
			list.add(new EMP(number, name));	
		}	
		return list;
		
	}
	
}