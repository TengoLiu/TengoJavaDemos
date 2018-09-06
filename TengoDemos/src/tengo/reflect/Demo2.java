package tengo.reflect;

import java.awt.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;


//反射构造函数
public class Demo2 {

	// 通过类的具体路径获取类
	Class class1;

	public Demo2() throws Exception {
		class1 = Class.forName("tengo.reflect.Person");
	}

	@Test
	public void test1() throws Exception {

		// 获取不需要构造参数的构造方法，如果想要别的构造函数，就传入需要该类型的参数的类型即可...
		Constructor constructor = class1.getConstructor(null);

		/*
		 * 这里代表调用该类的构造方法来获取一个类的对象，这里获取的是一个对象 但是以后实际用到的时候就是获取一个实现了抽象类的对象了！
		 * 括号里面的参数null，指定通过调用构造参数为null的构造函数来创建实例 2018年2月27日20:28:03
		 */
		Person person = (Person) constructor.newInstance(null);

		// 检验下是否创建类成功了
		System.out.println(person.name);

	}

	@Test
	public void test2() throws Exception, SecurityException {

		Constructor constructor = class1.getConstructor(String.class);

		/* 获取需要传入String类型的构造参数 */
		Person person = (Person) constructor.newInstance("xxxx");

		System.out.println(person.name);
	}

	@Test
	public void test3() throws Exception, SecurityException {

		Constructor constructor = class1.getConstructor(String.class, int.class);

		Person person = (Person) constructor.newInstance("xxxx", 22);

		System.out.println(person.name);
		System.out.println(person.age);
	}

	@Test
	public void test4() throws Exception, SecurityException {

		/* 获取私有类型的构造函数 */
		Constructor constructor4 = class1.getDeclaredConstructor(List.class);

		/* 暴力反射，加了这个方法之后就不会报错,很无语，居然能够破坏类的封闭性！ */
		constructor4.setAccessible(true);

		// 结果发现报错了，原因就是私有方法在外部不能访问！
		Person person4 = (Person) constructor4.newInstance(new List() {
		});

		System.out.println(person4.name);
		System.out.println(person4.age);
	}

	@Test
	public void test5() throws Exception {
		/* 也可以通过类来直接实例化对象，但是只能生成无参构造函数创建对象的对象 */
		Person person5 = (Person) class1.newInstance();
		System.out.println(person5.name);
		System.out.println(person5.age);
	}
}
