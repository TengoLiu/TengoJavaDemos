package tengo.javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo {

	/* 得到Bean的所有属性 */
	@Test
	public void test() throws Exception {
		// 解析一个JavaBean，并且获取这个Bean的信息,第二个参数为去除继承于Object父类的属性
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

		// 获取属性集合
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

		for (PropertyDescriptor item : pds) {
			System.out.println(item.getName());

		}
	}

	/* 操作bean的属性 读 写 */
	@Test
	public void test2() throws Exception {
		// 解析一个JavaBean，并且获取这个Bean的信息,第二个参数为去除继承于Object父类的属性
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

		Person person = new Person();

		/*
		 * 获取age属性，事实上也可以在这里指定get或者set是哪个方法， 避免有些人乱命名get和set(比如getName设置为gettname)
		 * 导致获取不到读写的方法
		 */
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		// 获取age的set方法
		Method setter = pd.getWriteMethod();

		// 调用set方法，对age进行赋值
		setter.invoke(person, 15);
		System.out.println(person.getAge());

		// 获取get方法
		Method getter = pd.getReadMethod();

		System.out.println(getter.invoke(person, null));
	}

	/* 获取要操作的属性的类型 */
	@Test
	public void test3() throws Exception {
		// 解析一个JavaBean，并且获取这个Bean的信息,第二个参数为去除继承于Object父类的属性
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

		Person person = new Person();

		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);

		// 获取属性的类型
		Class type = pd.getPropertyType();

		System.out.println(type);

	}
}
