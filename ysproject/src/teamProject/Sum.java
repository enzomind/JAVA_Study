package teamProject;

public class Sum implements Calculation {

	@Override
	public double [] executeSchool(School[] school) {
		double [] sumArr = {0,0,0};
		for (int i = 0; i < school.length; i++) {
			String str = school[i].getName();
			switch (str) {
			case "seoul":
				sumArr[0] += school[i].getSum();
				break;
			case "yonsei":
				sumArr[1] += school[i].getSum();
				break;
			case "korea":
				sumArr[2] += school[i].getSum();
				break;
			}
		}
		return sumArr;
	}

}
