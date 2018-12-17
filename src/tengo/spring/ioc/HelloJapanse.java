package tengo.spring.ioc;

public class HelloJapanse implements IHelloWorld {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("$^&#%&@%@& : " + message);
	}
}