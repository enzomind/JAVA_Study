package notepad;

import java.util.*;

public class Notepad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		
		String H = sc.next(); 
		String M = sc.next();
		
	
		int hour = Integer.parseInt(H);
		int min = Integer.parseInt(M);
		
		
		
		
		/*
		int H = sc.nextInt();
		int M = sc.nextInt();
		*/
	

		if (min >= 45) {
			System.out.print(hour + " " + (min-45));
		}else if (min < 45 && hour == 0) {
			System.out.print((hour = 23) + " " + (min+15));
		}else if (min < 45) {
			System.out.print((hour-1) + " " +(min+15));
		}

	}
}
