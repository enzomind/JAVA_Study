package guestbook.model;

public class Message {

	private int id;
	private String studentName;
	private String password;
	private int korScore;
	private int mathScore;
	private int engScore;	
	
	private int summury;
	private double avg;
	
	private String message;
	private int rank;
	
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSummury() {
		return summury;
	}

	public void setSummury(int summury) {
		this.summury = summury;
	}

	public double getAvg() {
		return Double.parseDouble((String.format("%.1f",avg)));
	}

	public void setAvg(double avg) {
		this.avg = Double.parseDouble((String.format("%.1f",avg)));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
		

	public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}

	public boolean matchPassword(String pwd) {
		return password != null && password.equals(pwd);
	}
}