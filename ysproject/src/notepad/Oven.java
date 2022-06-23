package notepad;

import java.util.*;

public class Oven {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		
		int A = scan.nextInt(); // 시
		int Atemp;
		
		int B = scan.nextInt(); // 분
		int Btemp;
		
		int C = scan.nextInt(); //필요한 분
		
		
		
		if(C >= 60) {
			Atemp = C / 60;
			A = A + Atemp;
			
			Btemp = C % 60;
			B = B + Btemp;
	
			if(B >= 60) {
				B = B - 60;
				A++;
				
			}
			if (A >= 24) {
				A = A - 24;
			}	
			
		}else if(C < 60) {
			B = B + C;
			
			if (B >= 60) {
				B = B - 60;
				A++;
				if (A >= 24) {
					A = A - 24;
				}
			}
		}
			
		System.out.println(A + " " + B);
	
	}

}
