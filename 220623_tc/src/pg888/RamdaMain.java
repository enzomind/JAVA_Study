package pg888;

public class RamdaMain {

	public static void main(String[] ar) {
		
		setOnAction(e->bbb(e));

	}
	
	private static void setOnAction(EventHandler event) {
		event.handle(0);
		
	}

	private static Object bbb(int e) {
		System.out.println("bbb");
		return null;
	}


	
}
