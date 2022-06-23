package teamProject;


public class Average implements Calculation{
	
	public int [] countSNum(School[] school) {
		int [] sNum = {0,0,0};
		for (int i = 0; i < school.length; i++) {
			if (school[i].getName().equals("seoul")) {
				sNum[0]++;
			} else if (school[i].getName().equals("yonsei")) {
				sNum[1]++;
			} else if (school[i].getName().equals("korea")) {
				sNum[2]++;
			}
		}
		return sNum;
	}

	@Override
	public double [] executeSchool(School[] school) {
		Sum sum = new Sum();	
		double [] avgArr = {0,0,0};
		for(int i = 0 ;i<countSNum(school).length;i++) {
			avgArr[i] = sum.executeSchool(school)[i] / countSNum(school)[i];
		}
		
		return avgArr;
	}

	

}
