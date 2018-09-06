package tengo.javabean;

/*
 * 这个类就是一个JavaBean
 * 这个Bean里面有3个字段id、name、age;
 * 有4个属性 id、name、age、Ab
 * 属性不由字段决定，而是由Get和Set对外开发的值来决定
 * Ab虽然没有字段支撑，但是由于是get或者Set方法，所以也算是一个属性
 * */
public class Person {
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAb() {
		return "";
	}

}
