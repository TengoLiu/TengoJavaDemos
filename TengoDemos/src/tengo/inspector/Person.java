package tengo.inspector;

//这样封装了字段成为属性的类就称为javabean，一般用来封装数据
//字段只有设置了get和set方法之后这个bean才有了属性，字段对外提供了get或者set之后，这个字段才能称之为属性
//然而就算沒有字段作为支撑，只要有了get或者set，那也算是多了一个属性
//目前这个类居然有5个属性！因为所有类都继承于Object，而Object里面有个方法叫getClass！所以也算一个
public class Person {
	public Person() {

	}

	public String name = "aaa"; // 字段
	private String password = "111111";
	private static int age = 1;

	//这个没有字段支撑，但是也算是一个属性
	public String getAb() {
		return null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getAge() {
		return age;
	}

	public static void setAge(int age2) {
		Person.age = age2;
	}

}
