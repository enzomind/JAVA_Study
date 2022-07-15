package dto;

public class Employees {

	private int employee_id;
	private String first_name;
	private int salary;
	private String email;
	
	public Employees(int employee_id, String first_name, int salary, String email) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.salary = salary;
		this.email = email;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
