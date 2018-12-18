package tengo.spring.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	@Test
	public void testRequired() {
		// 初始化ioc容器
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans2.xml");

		// 获取拥有@Required注解属性设置方法的bean，
		Student student = (Student) context.getBean("student");

		// 测试内部属性有自动装配注解@Autowired的bean
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();

		// 测试构造函数有自动装配注解@Autowired的bean
		TextEditor2 textEditor2 = (TextEditor2) context.getBean("textEditor2");
		textEditor2.spellCheck();

		// 测试指定自动装配的bean
		SomeOne someOne = (SomeOne) context.getBean("someOne");
		System.out.println("name:" + someOne.getStudent().getName());
		System.out.println("age:" + someOne.getStudent().getAge());
	}
}
