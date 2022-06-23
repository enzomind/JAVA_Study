package ysproject;

import java.util.Scanner;

public class Scorerun {

	public static void main(String[] args) {
		

		System.out.print("학생의 이름을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.print("국어 점수를 입력하세요. : ");
		int Kor = scan.nextInt();
		System.out.print("수학 점수를 입력하세요. : ");
		int Math = scan.nextInt();
		System.out.print("영어 점수를 입력하세요. : ");
		int Eng = scan.nextInt();
		
		Score score = new Score(Kor, Math, Eng); 
		
		score.plusmethod(Kor);
		score.avgmethod();
		score.resultmethod();
		
		System.out.println("총점은 " + score.temp + "점입니다.");
		System.out.println("평균점수는 " + score.result + "점입니다.");
		
	}
}

