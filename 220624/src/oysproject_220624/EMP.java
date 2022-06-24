package oysproject_220624;

//fxml 구성 후, 네번째로 코딩 시작

public class EMP {
	int number;
	String name;
	
	EMP(int number) { //하나만 들어올 때
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	EMP(int number, String name) { //두개 들어올 때
		this.number = number;
		this.name = name;
	}
}
