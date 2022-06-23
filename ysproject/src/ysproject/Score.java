package ysproject;

public class Score {

	int sKor;
	int sMath;
	int sEng;
	int temp;
	double result;

	//오버로드 생성자]
	Score(int sKor, int sMath, int sEng) { //생성자 Score에서 매개변수(파라미터) sKor, sMath, sEng를 받아옴.
		this.sKor = sKor;
		this.sMath = sMath;
		this.sEng = sEng;
	}
	
	int plusmethod(int a) { //plusmethod라는 메서드
		int result = sKor + sMath + sEng;
		this.temp = result;
		//System.out.println("총점은 " + temp + "점입니다.");
		return temp;
	}

	void avgmethod() {
		double avg = (double) temp / 3;
		this.result = avg;
		//System.out.println("평균점수는 " + result + "점입니다."); 
		return;
	}

	boolean resultmethod() {
		if (result < 60.0) {
			System.out.println("평균 점수 60점 미만으로 불합격입니다.");
			return false;
		}
		if (sKor <= 40) {
			System.out.println("국어 점수 과락으로 불합격입니다.");
			return false;
		}
		if (sMath <= 40) {
			System.out.println("수학 점수 과락으로 불합격입니다.");
			return false;
		}
		if (sEng <= 40) {
			System.out.println("영어 점수 과락으로 불합격입니다.");
			return false;
		} else {
			System.out.println("합격입니다.");
			return true;
		}

	}

}
