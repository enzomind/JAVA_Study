package teamProject;

public class Factorypattern {
	
	public Calculation selectConstructor(int num) {
		
		if(num ==1)
		{
			return new Sum();
		}else if(num==2) {
			return new Average();
		}
		
		return null;
	}
}
