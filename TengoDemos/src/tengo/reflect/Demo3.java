package tengo.reflect;

import java.lang.reflect.Field;

import org.junit.Test;


//反射字段
public class Demo3 {

	Class class1;

	public Demo3() throws Exception {
		class1 = Class.forName("tengo.reflect.Person");
	}

	// 反射字段：public
	@Test
	public void test1() throws Exception {
		Person person = new Person();
		Field field = class1.getField("name");
		// 获取字段的值
		Object name = field.get(person);

		// 获取字段的类型
		Class type = field.getType();

		if (type.equals("String")) {
			// 获取字段的值
			String value = (String) field.get(person);
			System.out.println(value);

			// 给字段设置值
			field.set(person, "new name");

			System.out.println(person.name);
		}

	}

	// 反射字段：private
	@Test
	public void test2() throws Exception {
		Person person = new Person();
		Field field = class1.getDeclaredField("password");

		// 暴力破解,以便无耻地获取密码
		field.setAccessible(true);

		System.out.println(field.get(person));
	}

	// 反射字段：static private
	@Test
	public void test3() throws Exception {
		Person person = new Person();
		Field field = class1.getDeclaredField("age2");

		// 暴力破解,以便无耻地获取密码
		field.setAccessible(true);

		// 明明是静态的，还要传个对象过去，无语了......
		System.out.println(field.get(person));
	}
}
