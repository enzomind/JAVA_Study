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
    	
    	String sql = "insert into ex3(exam_num, exam_name) values (?,?)";
    	
    	ps = conn.prepareStatement(sql);
    	ps.setInt(1, emp.number);
    	ps.setString(2, emp.name);
    	int ret = ps.executeUpdate();
		return ret;
    	
    }
    public int modify(Emp emp) throws SQLException {
    	//
		return 0;
    	
    }
    public int remove(Emp emp) throws SQLException {
    	PreparedStatement ps = null;
    	String sql = "delete from ex3 where emp_id = ?";
    	ps = conn.prepareStatement(sql);
    	ps.setInt(1, emp.number);
    	int ret = ps.executeUpdate();
		return ret;
    	
    }
    public ArrayList<Emp> lists() throws SQLException {
    	
    	ResultSet rs = null;
    	Statement stmt = conn.createStatement();
    	
    	rs = stmt.executeQuery("select * from ex3");
    	
    	ArrayList<Emp> list = new ArrayList<Emp>();
    	
    	while(rs.next()) {
    		int number = rs.getInt("exam_num");
    		String name = rs.getString("exam_name");
    		
    		list.add(new Emp(number, name));
    	}
		
    	return list;

    }
}











