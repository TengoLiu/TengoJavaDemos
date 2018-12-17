package tengo.spring.ioc;

public class HelloChinese implements IHelloWorld {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("你传入的消息为 : " + message);
	}
}