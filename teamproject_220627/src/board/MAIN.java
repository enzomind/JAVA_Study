package board;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//-DBConn : 드라이버 로딩 및 각 클래스에서 conn 객체 생성
//-DBDAO : 테이블 내 컬럼 조회, 수정, 삭제, 입력 기능 구현 
//-EMP :  호출 시, 값 리턴 목적
//-RootContoller : 사용자의 액션에 따라 각 클래스 호출하는 분기처리 기능 구현

public class MAIN extends Application {

	public static void main(String[] args) {
		launch(args); //
	}

	@Override
	public void start(Stage prs) throws Exception {
		
		Parent Oysexe = FXMLLoader.load(getClass().getResource("재권님 만드신 fxml파일명.fxml"));
		
		Scene scene = new Scene(Oysexe);
		
		prs.setTitle("고객지원센터");
		//primarystage 풀로 네이밍쓰기 싫어서 위에 매개 객체를 prs로 바꿈
		prs.setScene(scene);
		prs.show();
		
		
		
	}

}
