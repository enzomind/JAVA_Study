package board;

import java.util.ArrayList;

public interface BoardInterface {

	
	int input(EMP emp);
	
	public EMP search(int number);
	
	public int modify(EMP emp);
	
	public int delete (EMP emp);
	
	public ArrayList<EMP> select();


}