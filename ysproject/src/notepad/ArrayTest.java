package notepad;

import java.util.*;

public class ArrayTest {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] a = {10,20,30,50,100};
		int temp = 0;
		
		for(int i=0; i<a.length; i++) {
			temp = temp+ a[i];
			System.out.print(temp);
		}
			
		System.out.println();
		System.out.print("temp 총 값은 : " + temp);
	}

}
