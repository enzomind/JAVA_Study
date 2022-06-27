package board;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EMP {

	
	private StringProperty mid; //아이디
	private StringProperty pw;  //패스워드
	
	private IntegerProperty btype //게시글 유형 (1:공지사항 / 2:FAQ / 3:자유게시판)
	private IntegerProperty bno; //게시글번호
	private StringProperty title; //게시글 타이틀
	private StringProperty contents; //게시글 내용

}
