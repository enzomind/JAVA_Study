package nullexam;

public class NullCustomer extends Customer {

	@Override
	public boolean isNil() {
		return true;
	}

	@Override
	public String getName() {
		return "��ϵ� ���� �ƴմϴ�";
	}
   
}
