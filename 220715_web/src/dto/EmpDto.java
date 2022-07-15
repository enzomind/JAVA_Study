package dto;

public class EmpDto {

	private int employee_id;
	private String first_name;
	private int salary;
	private String email;

	public void match(Employees emp) {
		employee_id = emp.getEmployee_id();
		first_name = emp.getFirst_name();
		salary = emp.getSalary();
		email = emp.getEmail();
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
