package nullexam;

public class NullExam {

	public static final String[] names = {"�浿", "����", "ö��" };
	
	public static void main(String[] args) {
		Customer cust1 = getCustomer("ö��");
		System.out.println(cust1.getName());
		
		cust1 = getCustomer("����");
		System.out.println(cust1.getName());

	}

	public static Customer getCustomer(String name) {
		for (String nn : names) {
			if (name.equals(nn)) {
				return new RealCustomer(name);
			}
		}
		return new NullCustomer();
	}
}








