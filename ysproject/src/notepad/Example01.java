package notepad;

import java.util.*;

public class Example01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		for(int i=0; i<=N ; i++) {
			
				
			result = result + i ;
		}
		
		System.out.println(result);
	
	}
}
