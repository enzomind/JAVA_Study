package test01;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private TextField txf1;
	@FXML
	private TextField txf2;
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

	}

	public void handle1(ActionEvent e) throws NumberFormatException, SQLException {

		Emp emp = ed.getEmp(Integer.parseInt(txf1.getText()));

		txf1.setText(emp.number + "");
		txf2.setText(emp.name);
	}

	public void handle2(ActionEvent e) throws NumberFormatException, SQLException {

		Emp emp = new Emp(Integer.parseInt(txf1.getText()), txf2.getText());
		int num = ed.modify(emp);
		System.out.println(num + "건 수정");
		
	}

}
