import java.awt.List;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		EmpDao ed = new EmpDao();
		ed.connect();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴출력");
		System.out.println("----------");
		//ed.connect();
		System.out.print("입력>");
		int num = sc.nextInt();
		switch(num) {
		case 1:  
			
			System.out.print("번호 입력>");
			int number = sc.nextInt();
			System.out.print("이름 입력>");
			String name = sc.next();
			
			Emp emp = new Emp(number, name);
			
			ed.input(emp);
			

			break;
			
		case 4:
			for(Emp emp4 : ed.lists()) {
				System.out.println(emp4.number);
				System.out.println(emp4.name);
			}
			
			break;
		
		}

	}

}




