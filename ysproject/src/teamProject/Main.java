package teamProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static int lineNum(File file) throws FileNotFoundException {
		// School �迭 ���� -> ���� �����ͺ��̽��� �߰��Ѵٸ� �迭�� ũ�⵵ ����������ϴ� ����߻�
		// ũ�⸦ ���Ƿ� ũ�������� �����͸� �޾ƿ��� �������� ������Ʈ ���� �߻� //�ذ�
		// ���Ϸκ��� ������ �޾ƿ���
		Scanner sc = new Scanner(file);
		int count = 0;
		while (sc.hasNext()) {
			sc.nextLine();
			count++;
		}
		sc.close();
		return count;
	}

	public static void main(String[] args) {
		try {
			// �� ����ΰ� �ȵǴ��� �𸣰���
			File file = new File("C:\\JavaProgramming\\source\\teamProject\\src\\teamProject\\scoreDB.txt");
			School[] school = new School[lineNum(file)];
			Scanner inFile = new Scanner(file);
			Sort s = new Sort();
			int i = 0;
			while (inFile.hasNext()) {
				// ������ �����͸� �迭�� ����
				school[i] = new School();
				school[i].setName(inFile.next());
				school[i].setStudentName(inFile.next());
				school[i].setSubScore1(inFile.nextInt());
				school[i].setSubScore2(inFile.nextInt());
				school[i].setSubScore3(inFile.nextInt());
				i++;
			}

			for (i = 0; i < school.length; i++) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\n", school[i].getName(), school[i].getStudentName(),
						school[i].getSubScore1(), school[i].getSubScore2(), school[i].getSubScore3());
			}
			// �ܼ�â�� ����ϱ�
			boolean isStart = true;
			Scanner sc = new Scanner(System.in);

			while (isStart) {
				System.out.println("----------------------------------------------");
				System.out.println("1.��Ȳ | 2.��������Ʈ | 3.��ո���Ʈ | 4.����б� | 5.���� ");
				System.out.println("----------------------------------------------");
				System.out.print("�����ϼ��� >> ");
				int select = sc.nextInt();

				if (select == 1) {
					// �����ͺ��̽� ���
					System.out.println("���� �����ͺ��̽��� �ִ� �������Դϴ�.");
					s.prnDB(school);
				} else if (select == 2) {
					// ��������Ʈ ������ �б��̸����� �Ұ��� ���������� �Ұ��� ����
					System.out.println("------------------------------------------");
					System.out.println("� ������ �����ұ��?  	1.�б��̸��� | 2.������ | 3.�л��̸���");
					System.out.println("------------------------------------------");
					System.out.print("�����ϼ��� >> ");
					int selectSort = sc.nextInt();
					if (selectSort == 1) {
						// �б��̸��� ����
						s.schoolNameSort(school);
					} else if (selectSort == 2) {
						// ������ ����
						s.sumSort(school);
					} else if (selectSort == 3) {
						// �л��̸��� ����
						s.schoolsNameSort(school);
					}
				} else if (select == 3) {
					// �б��� ��ո���Ʈ ���
					s.schoolAvgPrn(school);
				} else if (select == 4) {
					// ��� 1���б� ���
					s.avgSort(school);
				} else if (select == 5) {
					isStart = false;
				}
			}
			System.out.println("�ý����� �����մϴ�.");
		} catch (FileNotFoundException e) {
			System.out.println("������ �����ϴ�.");
		}
	}
}
