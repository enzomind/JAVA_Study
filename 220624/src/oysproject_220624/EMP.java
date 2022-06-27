package oysproject_220624;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//fxml 구성 후, 네번째로 코딩 시작

public class EMP {
	
//	private int number;
//	private String name;
	
	private IntegerProperty number;
	private StringProperty name;
	
	
	
	EMP(int number, String name) { //두개 들어올 때
		this.number = new SimpleIntegerProperty(number);
		this.name =  new SimpleStringProperty(name);
	}
	
	
	public IntegerProperty getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number.set(number);
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);;
	}
	
	
//	public int getNumber() {
//		return number;
//	}
//	
//	
//
//	public void setNumber(int number) {
//		this.number = number;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
////
//	EMP(int number, String name) { //두개 들어올 때
//		this.number = number;
//		this.name = name;
//	}
	

}
