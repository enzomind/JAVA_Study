package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Employees;

public class EmpDao {
    private Connection conn;
    public Connection connect() throws ClassNotFoundException, SQLException {
    	conn = DBconn.getConnection();
		return conn;
    }
    public Employees getEmp(int id) throws SQLException {
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	ps = conn.prepareStatement(
    			"select employee_id, first_name, salary, email from employees where employee_id = ?");
    	ps.setInt(1, id);
    	rs = ps.executeQuery();
    	if (rs.next()) {
    		int employee_id = rs.getInt("employee_id");
    		String first_name = rs.getString("first_name");
    		int salary = rs.getInt("salary");
    		String email = rs.getString("email");
    		Employees emp = new Employees(employee_id, first_name, salary, email);
    		return emp;
    	}
    	return null;
    	
    }
    public int selectMin() throws SQLException {
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	ps = conn.prepareStatement(
    			"select min(employee_id) from employees");
    	rs = ps.executeQuery();
    	if (rs.next()) {
    		int min = rs.getInt(1);
    		return min;
    	}
    	return 0;
    }

    public int selectMax() throws SQLException {
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	ps = conn.prepareStatement(
    			"select max(employee_id) from employees");
    	rs = ps.executeQuery();
    	if (rs.next()) {
    		int max = rs.getInt(1);
    		return max;
    	}
    	return 0;
    }
    
    public int input(Employees emp) throws SQLException {
    	//
		return 0;
    	
    }
    public int modify(Employees emp) throws SQLException {
    	//
		return 0;
    	
    }
    public int remove(Employees emp) throws SQLException {
    	//
		return 0;
    	
    }

}
