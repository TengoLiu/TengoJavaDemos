package tengo.reflect;

import java.awt.List;
import java.io.InputStream;

public class Person {

	public String name = "aaa";

	private String password = "111111";

	public static int age = 1;

	private static int age2 = 1;

	public Person() {
		System.out.println("person....");

	}

	public Person(String name) {
		this.name = name;
		System.out.println("person:" + name);

	}

	public Person(String name, int age) {
		Person.age = age;
		System.out.println("person:" + name + ",age:" + Person.age);

	}

	private Person(List list) {
		System.out.println("person:list");
	}

	public void run() {
		System.out.println("run....");
	}

	public void run(String name) {
		System.out.println(name + " run ....name");
	}

	public void run(String name, int password) {
		System.out.println(name + " run....password:" + password);
	}

	/*
	 * 返回一个数组，JAVA还可以这么玩？ 方法名一至但是签名却不一致！
	 */
	public Class[] run(String name, int[] password) {
		System.out.println("run....name+password");
		return new Class[] { String.class };
	}

	// 私有方法
	private void run(InputStream inputStream) {
		System.out.println(name + " run....inputStream");
	}

	// 静态方法
	public static void run(int num) {
		System.out.println(num + " run....");
	}

	// main方法！
	public static void main(String[] args) {
		System.out.println("main!");
	}
}
