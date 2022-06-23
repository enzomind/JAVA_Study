package teamProject;

public class Sort {
	double max = 0;
	String firstSchool;
	Factorypattern fp = new Factorypattern();
	Calculation cc;

	// DB����Ʈ
	void prnDB(School[] school) {
		System.out.println("�б���\t�л��̸�\t����1\t����2\t����3\t����\t���");
		for (int i = 0; i < school.length; i++) {
			System.out.println(school[i].getName() + "\t" + school[i].getStudentName() + "\t" + school[i].getSubScore1()
					+ "\t" + school[i].getSubScore2() + "\t" + school[i].getSubScore3() + "\t" + school[i].getSum()
					+ "\t" + school[i].getAvg());
		}
	}

	// ����б� ����
	public void avgSort(School[] school) {
		

		firstSchool = ReturnSchoolName(school);
		cc = fp.selectConstructor(2);
		double max = cc.executeSchool(school)[0];

		for (int i = 0; i < 3; i++) {
			if (max < cc.executeSchool(school)[i]) {
				max = cc.executeSchool(school)[i];
			}
		}
		if (firstSchool == null)
			System.out.println("����! 3���� ���� �������ּ���");
		else if (max == cc.executeSchool(school)[0])
			System.out.println("��� �б� : ������б�");
		else if (max == cc.executeSchool(school)[1])
			System.out.println("��� �б� : �������б�");
		else if (max == cc.executeSchool(school)[2])
			System.out.println("��� �б� : ������б�");
	}

	// �б��̸����� ����
	public void schoolNameSort(School[] school) {
		School[] tmp = new School[1];

		for (int i = 1; i < school.length; i++) {
			for (int j = 0; j < school.length - i; j++) {
				if (school[j].getName().compareTo(school[j + 1].getName()) > 0) {
					tmp[0] = school[j];
					school[j] = school[j + 1];
					school[j + 1] = tmp[0];
				}
			}
		}
		prnDB(school);
	}

	// �б��̸����� ����
	public void schoolsNameSort(School[] school) {
		School[] tmp = new School[1];

		for (int i = 1; i < school.length; i++) {
			for (int j = 0; j < school.length - i; j++) {
				if (school[j].getStudentName().compareTo(school[j + 1].getStudentName()) > 0) {
					tmp[0] = school[j];
					school[j] = school[j + 1];
					school[j + 1] = tmp[0];
				}
			}
		}
		prnDB(school);
	}

	//��������� ���� ���� �б��̸� ���ڿ��� ���
	public String ReturnSchoolName(School[] school) {
		cc = fp.selectConstructor(2);
		double max[] = {cc.executeSchool(school)[0],cc.executeSchool(school)[1],cc.executeSchool(school)[2]};
		if (max[0] == cc.executeSchool(school)[0])
			return "seoul";
		else if (max[1] == cc.executeSchool(school)[1])
			return "yonsei";
		return "korea";
	}

	
	public void schoolAvgPrn(School[] school) {
		cc = fp.selectConstructor(2);
		System.out.println("seoul: " + cc.executeSchool(school)[0]);
		System.out.println("yonsei: " + cc.executeSchool(school)[1]);
		System.out.println("korea: " + cc.executeSchool(school)[2]);
	}

	// �л��̸����� ����
	public void studentNameSort(School[] school) {
		School[] tmp = new School[1];

		for (int i = 1; i < school.length; i++) {
			for (int j = 0; j < school.length - i; j++) {
				if (school[j].getStudentName().compareTo(school[j + 1].getStudentName()) > 0) {
					tmp[0] = school[j];
					school[j] = school[j + 1];
					school[j + 1] = tmp[0];
				}
			}
		}
		prnDB(school);
	}

	// ���� ������ ���� ������ ����
	public void sumSort(School[] school) {
		School[] tmp = new School[1];

		for (int i = 1; i < school.length; i++) {
			for (int j = 0; j < school.length - i; j++) {
				if (school[j].getSum() < school[j + 1].getSum()) {
					tmp[0] = school[j];
					school[j] = school[j + 1];
					school[j + 1] = tmp[0];
				}
			}
		}
		prnDB(school);
	}
}
