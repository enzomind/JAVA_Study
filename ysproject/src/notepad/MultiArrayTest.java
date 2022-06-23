package notepad;

public class MultiArrayTest {
	public static void main(String[] args) {
		
		int [][] a = {{10,20},{50,60,70}};
		//총 합은 30 + 150 해서 210 나와야 함.
		
		int temp = 0;
		
		//System.out.print(a[1].length);
		
		//System.out.print(a[0][1]);
		
		for(int i=0 ; i<a[0].length;i++) {
			for(int j=0 ; j<a[1].length; j++) {
				
				if(a[i][j] != 0) {
					System.out.println("현재상태 : " + a[i][j]);
					
					temp = temp + a[i][j];
					System.out.println(temp);
				}else {
					System.out.println("오류 감지");
					continue;
				}
				
			}
			
			
		}
		
		System.out.println("temp의 값은 : " + temp);
		
	}
}
