package notepad;

import java.util.*;

public class MathRandom {

	public static void main(String[] args) {

		/*
		int var1 = (int) (Math.random() * 6) + 1;
		int var2 = (int) (Math.random() * 6) + 1;
		int var3 = (int) (Math.random() * 6) + 1;
		*/
		
		Scanner sc = new Scanner(System.in);
		int var1 = sc.nextInt();
		int var2 = sc.nextInt();
		int var3 = sc.nextInt();

		
		int result = 0;

		if (var1 == var2 && var2 == var3) {
			result = 10000 + var1 * 1000;
		} else if (var1 == var2 && var1 != var3) {
			result = 1000 + var1 * 100;
		} else if (var2 == var3 && var1 != var2) {
			result = 1000 + var2 * 100;
		} else if (var1 == var3 && var1 != var2) {
			result = 1000 + var1 * 100;
		}
		
		
		if (var1 != var2 && var1 != var3 && var2 != var3) {
			if (var1 > var2 && var1 > var3) {
				result = var1 * 100;
			} else if (var2 > var3 && var2 > var1) {
				result = var2 * 100;
			} else if (var3 > var2 && var3 > var1) {
				result = var3 * 100;
			}
		}

		System.out.print(result);

	}
}