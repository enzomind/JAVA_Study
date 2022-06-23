package teamProject;

public class School {
	private String name;
	private String studentName;
	private int subScore1;
	private int subScore2;
	private int subScore3;
	private int sum;
	private double avg;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getAvg() {
		avg = (double) sum / 3;
		return avg;
	}

	public void setAvg(double avg) {
		avg = (double) sum / 3;
		this.avg = avg;
	}

	public int getSum() {
		sum = subScore1 + subScore2 + subScore3;
		return sum;
	}

	public void setSum(int sum) {
		sum = subScore1 + subScore2 + subScore3;
		this.sum = sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSubScore1() {
		return subScore1;
	}

	public void setSubScore1(int subScore1) {
		this.subScore1 = subScore1;
	}

	public int getSubScore2() {
		return subScore2;
	}

	public void setSubScore2(int subScore2) {
		this.subScore2 = subScore2;
	}

	public int getSubScore3() {
		return subScore3;
	}

	public void setSubScore3(int subScore3) {
		this.subScore3 = subScore3;
	}
}
