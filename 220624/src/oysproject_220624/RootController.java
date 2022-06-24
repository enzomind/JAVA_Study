package oysproject_220624;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

//다섯번째로 코딩
//해당 클래스에서 fxml에서 정의한 ID값들을 가지고 액션 이벤트 설정해주려 함

public class RootController implements Initializable {

	// fxml의 각 텍스트 필드, 버튼 매핑
	@FXML
	private TextField inputnotxf, inputnametxf, modifynotxf, modifynametxf;
	@FXML
	private Button inputbtn, modifybtn, selectbtn;
	@FXML
	private Label resultinfo;

	// 구글링하다가 이렇게 정의해도된단걸 알았따!!!!!!!!!!!!!!!!!!!

	@FXML  //<-꼭 안써도된대
	private TableView<EMP> tb;

	@FXML
	private TableColumn<EMP, Integer> tbno;

	@FXML
	private TableColumn<EMP, String> tbname;

	DBDAO dd;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// 버튼들의 액션이벤트들에 대해 지정 및 예외처리

		dd = new DBDAO();
		try {
			// DBDAO에서 연결쪽 메소드를 작성안해서 그거 먼저 하고와야겠음!! DBDAO 작성하러 출발!!
			// 커넥트랑 인풋까지 작성하고 옴
			dd.connect();
		} catch (Exception ex) {
			ex.printStackTrace(); // 로그 찍기
		}

		inputbtn.setOnAction(e -> {
			try {
				inputaction(e); // 누르면 인풋액션이란 메소드의 기능을 실행할 것!
								// handle 이란걸 일할때도 많이 봤는데 그건 걍 현업가서 정의된 롤 따르자
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		modifybtn.setOnAction(e -> {
			try {
				modifyaction(e); // 얘는 수정기능

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		selectbtn.setOnAction(e -> {
			try {
				selectaction(e); // 얘는 수정기능

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

	public void inputaction(ActionEvent e) throws NumberFormatException, SQLException {
		// 여기 작성할라니깐 DBDAO에서 데이터 가져오는 메소드를 작성안한게 생각남. 코딩하러 출발!
		// getemp 메소드 작성하고 돌아옴. 이제 입력 동작에 대해 정의할 수 있다!

		EMP emp = new EMP(Integer.parseInt(inputnotxf.getText()), inputnametxf.getText());
		dd.input(emp);

		resultinfo.setText("등록이 완료되었습니다.");

		// 여기까지하고 1차 테스트 -> 잘되는거 확인

		// EMP emp = dd.getemp(Integer.parseInt(inputnotxf.getText()));
		//
		// inputnotxf.setText(emp.number);
		//

	}

	public void modifyaction(ActionEvent e) throws SQLException {

		EMP emp = new EMP(Integer.parseInt(modifynotxf.getText()), modifynametxf.getText());
		dd.modify(emp);
		resultinfo.setText("수정이 완료되었습니다.");

	}

	public void selectaction(ActionEvent e) throws SQLException {
		//이제 응용 부분. 리스트뷰에다가 DB 컬럼들을 뿌리려 함. 
		//DBDAO에서 ARRAYLIST를 만들었고 리턴까지 시켜오기때문에 뿌리는 쪽 구현만 하면되는데...
		//테이블의 컬럼 2개에 각각 ID부여(tc1, tc2) 여기따 뿌리면 간단하게될거같음. ㄱㄱ
		
//		for(EMP emp : dd.select()) {
//			//tc1.setText(Integer.parseInt(emp.number));
//			tc2.setText(emp.name);
//		}
////		망했음.이건 테이블뷰의 컬럼명에다 데이터를 넣는 것이었음.
//		한마디로 어레이리스트로 반복문돌려 데이터 뿌려주려면 fxml부터 만져야한다.
//		또는 진짜 그냥 오라클DB와 테이블뷰를 연동시켜 뿌려주든가 해야한다.
//		뭔가 아쉬우니 어레이리스트는 일단 콘솔에 나오게 수정하도록 한다.(?)
		
//		for(EMP emp : dd.select()) {
//			System.out.printf("%d\t%s\n", emp.number, emp.name);
//		}
	
//		구글링했더니 배열을 이용해서 테이블뷰를 구현하는 방법 발견.
//		난 이미 어레이리스트로 반복문만 돌리면 나오니 일부 빼먹으면되지싶다.
//		https://hey79.tistory.com/71 사이트보고 출발
		
//		for(EMP emp : dd.select()) {
//			tableview.setId(emp.name);
//		}
		
//		이렇게해서 될게아님. 젠장 개어려움; 
		
//		찾아보니 TableView를 사용할땐 오브젝트를 포함하는 ObservableList를 작성하고
//		PropertyValueFactory를 사용해 속성을 TableView에 삽입하는 과정을 정의하고 그 후에
//		ArrayList를 루프시켜 각 스트링 객체를 TableView에 삽입시킬수있다고한다. 해보자.
			
//		안된다. 하..

//		TableData vtData = null;
//
//		int nCnt = 10;
//		for (int i = 1; i <= nCnt; i++) {
//			String[] Record = new String[2];
//			
//			Record[i] = "test"; 
//			System.out.println(Record[1]);
//
//			vtData = new TableData(Record);
//			tb.getItems().add(vtData);
//		}
		
//		이건 줄 수만 늘려줌. 분명 무슨 밸류팩토리 머시기를 써야하는 것으로 보여짐.
		
		
		
		//구글에서 아래와 같은 예제 찾음.
		
//		ObservableList<EMP> list = FXCollections.observableArrayList(new EMP(220005, "김미나"), new EMP(220006, "조충범")
//
//		);

//		tbno.setCellValueFactory(new PropertyValueFactory<EMP, Integer>("number"));
//		tbname.setCellValueFactory(new PropertyValueFactory<EMP, String>("name"));
//
//		tb.setItems(list);
		
//		boolean count = true;
		
//		while (count) {
		for(EMP emp : dd.select()) {
			
//			() : 매개 변수 또는 조건 (ex. 휘발?)
//			
//			{} : 지역 (ex. 메소드 or 클래스 or 반복문 등등 )
//			
			ObservableList<EMP> list = FXCollections.observableArrayList(new EMP(emp.number, emp.name));
//			if(dd.select() != null )
//				for(;dd.select().equals(null);)
		
			tbno.setCellValueFactory(new PropertyValueFactory<EMP, Integer>("number"));
			tbname.setCellValueFactory(new PropertyValueFactory<EMP, String>("name"));
			
			tb.setItems(list);
			
//		}
		}
		
		//나오는데는 성공했지만 한줄밖에 안나와서 뭔가 카운트쓰는 부분을 구현해야 할 듯 함.
		

	}

}
