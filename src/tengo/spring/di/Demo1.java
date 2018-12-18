package tengo.spring.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
	@Test
	public void test1() {
		// 初始化ioc容器
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		// 这个对象的依赖是通过构造函数注入构建的
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();

		// 这个对象的依赖是通过setter方法注入而构建成的，在代码里面的调用方式没有任何不同，只是xml以及类的定义那边有些许不同而已
		TextEditor2 textEditor2 = (TextEditor2) context.getBean("textEditor2");
		textEditor2.spellCheck();

		// 通过内部bean依赖注入构建而成，其调用也没什么区别
		TextEditor2 textEditor3 = (TextEditor2) context.getBean("textEditor3");
		textEditor3.spellCheck();

		// 测试自动装配byName的bean
		TextEditor2 textEditor4 = (TextEditor2) context.getBean("textEditor4");
		textEditor4.spellCheck();

		// 测试自动装配byType的bean
		TextEditor3 textEditor5 = (TextEditor3) context.getBean("textEditor5");
		textEditor5.spellCheck();

		// 测试通过构造函数自动装配的bean
		TextEditor textEditor6 = (TextEditor) context.getBean("textEditor6");
		textEditor6.spellCheck();
	}

	@Test
	public void test2() {
		// 初始化ioc容器
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		DataBean dataBean = (DataBean) context.getBean("javaCollection");
		System.out.println(dataBean.getAddressList());
		System.out.println(dataBean.getAddressSet());
		System.out.println(dataBean.getAddressMap());
		System.out.println(dataBean.getAddressProp());
	}
}
