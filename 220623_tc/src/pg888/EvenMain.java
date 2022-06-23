package pg888;

public class EvenMain {

	public static void main(String[] ar) {
		
		setOnAction(new EventHandler() {
			
			@Override
			public void handle(int event) {
				aaa();
			}

			private void aaa() {
				System.out.println("aaa");
			}
		});
		
	}
	
	static void setOnAction(EventHandler event) {
		event.handle(10);
	}
	
}
