package nullexam;

public class RealCustomer extends Customer {

	public RealCustomer(String name) {
		this.name = name;
	}
	@Override
	public boolean isNil() {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

}





