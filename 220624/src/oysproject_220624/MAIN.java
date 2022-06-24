package oysproject_220624;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//첫번째로 코딩

//MAIN 클래스 만들면서 아래 클래스들을 생성
//-DBConnect : 드라이버 로딩 및 각 클래스에서 conn 객체 생성하여 쓸 수 있도록 하기 위함
//-DBDAO : oysemp 테이블 내 컬럼 조회, 수정, 삭제, 입력 기능 구현 
//-EMP : ArrayList로 조회 기능 구현하기 위해 생성자를 만들어 호출 시, 값 리턴하는 기능 구현
//-RootContoller : 사용자의 액션에 따라 각 클래스 호출하는 중앙처리 기능 구현
//-Oysexe : fxml (fx의 ui 스타일 구성하는 파일)

public class MAIN extends Application {

	public static void main(String[] args) {
		launch(args); //
	}

	@Override
	public void start(Stage prs) throws Exception {
		
		//Parent Oysexe = FXMLLoader.load(getClass().getResource("Oysexe.fxml"));
		Parent Oysexe = FXMLLoader.load(getClass().getResource("Oysexe.fxml"));
		
		Scene s = new Scene(Oysexe);
		
		prs.setTitle("학번 발급 시스템");
		//primarystage 풀로 네이밍쓰기 싫어서 위에 매개 객체를 prs로 바꿈
		prs.setScene(s);
		prs.show();
		
		
		
	}

}
