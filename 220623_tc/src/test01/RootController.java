package test01;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private TextField txf1;
	@FXML
	private TextField txf2;
	@FXML
	private TextField txf3;
	
	@FXML
	private TextField txf4;
	@FXML
	private TextField txf5;
	
	@FXML
	private TextArea result1;
	@FXML
	private TextArea result2;
	
	@FXML
	private Label result3;
	
	EmpDao ed; // 객체 지정안하고 이렇게만. 여러 군데에서 쓸 용도로 세팅하는 방법인거같음

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ed = new EmpDao(); // 이렇게도 표현이 되넹
		try {
			ed.connect();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		btn1.setOnAction(e -> {
			try {
				handle1(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		btn2.setOnAction(e -> {
			try {
				handle2(e);
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		});

		btn3.setOnAction(e -> {
			try {
				handle3(e);
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		

	}

	public void handle1(ActionEvent e) throws NumberFormatException, SQLException {

		Emp emp = ed.getEmp(Integer.parseInt(txf1.getText()));

		txf1.setText(emp.number + "");
		result1.setText(emp.name);
	}

	public void handle2(ActionEvent e) throws NumberFormatException, SQLException {

		Emp emp = new Emp(Integer.parseInt(txf2.getText()), txf3.getText());
		int num = ed.modify(emp);
		//System.out.println(num + "건 수정");
		result2.setText(num + "건 수정 완료");
		
	}

	public void handle3(ActionEvent e) throws NumberFormatException, SQLException {

		Emp emp = new Emp(Integer.parseInt(txf4.getText()), txf5.getText());
		ed.input(emp);

		result3.setText("등록이 완료되었습니다.");
		
	}
	
}
