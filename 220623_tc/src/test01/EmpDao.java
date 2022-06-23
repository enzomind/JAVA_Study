package test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDao {
    private Connection conn;
    public Connection connect() throws ClassNotFoundException, SQLException {
    	conn = DBconn.getConnection();
		return conn;
    }
    public int input(Emp emp) throws SQLException {
    	PreparedStatement ps = null;
    	String sql = "insert into ex3 (exam_num, exam_name) values (?,?)";
    	ps = conn.prepareStatement(sql);
    	ps.setInt(1, emp.number);
    	ps.setString(2, emp.name);
    	int ret = ps.executeUpdate();
		return ret;
    	
    }
    public int modify(Emp emp) throws SQLException {
    	PreparedStatement ps = null;
    	String sql = "update ex3 set exam_name = ? where exam_num = ?";
    	ps = conn.prepareStatement(sql);
    	ps.setString(1, emp.name);
    	ps.setInt(2, emp.number);
    	int ret = ps.executeUpdate();
		return ret;
		
    }
    public int remove(Emp emp) throws SQLException {
    	PreparedStatement ps = null;
    	String sql = "delete from ex3 where exam_num = ?";
    	ps = conn.prepareStatement(sql);
    	ps.setInt(1, emp.number);
    	int ret = ps.executeUpdate();
		return ret;
    	
    }
    public Emp getEmp(int number) throws SQLException {
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	ps = conn.prepareStatement(
    			"select exam_num, exam_name from ex3 where exam_num = ?");
    	ps.setInt(1, number);
    	rs = ps.executeQuery();
    	if (rs.next()) {
    		int exam_num = rs.getInt("exam_num");
    		String exam_name = rs.getString("exam_name");
        	Emp emp = new Emp(exam_num, exam_name);
    		return emp;
    	}
    	return new Emp(number, "번호");
   
    }
    
    public ArrayList<Emp> lists() throws SQLException {
    	ResultSet rs = null;
    	Statement state = conn.createStatement();
    	rs = state.executeQuery("select * from ex3");
    	ArrayList<Emp> list = new ArrayList<Emp>();
    	while(rs.next()) {
    		int number = rs.getInt("exam_num");
    		String name = rs.getString("exam_name");
    		
    		list.add(new Emp(number, name));
    	}
		return list;
    	
    }
}











