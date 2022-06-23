package notepad;

import java.util.*;

public class Gugudan {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1 ; i<10 ; i++) {
			int result = N * i;
			System.out.println(N + " * " + i  + " = " + result);
		}
	}
	
}
