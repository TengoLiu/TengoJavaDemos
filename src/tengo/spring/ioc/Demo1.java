package tengo.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/*
 * 这个demo主要介绍spring 的ioc容器,也就是包含了所有bean的容器。
 * 所有要使用的对象都可以通过它来获取,不在需要人为的new。
 * 这就是程序猿把对象的控制权转交给框架，即控制反转。然后就可以通过xml轻松地控制加载那些类。
 * 通过容器拿到对象之后，就可以随意地调用对象所拥有的方法 。
 * */
public class Demo1 {

	/*
	 * 1.本例子示范了通过xmd文件来加载某个继承了指定接口（拥有特定方法）的类，然后通过接口引用来调用其内在的方法,
	 * 2.通过接口的约束，可以通过xml随便替换实现类，这样如果要切换实现类的话，就非常简单了，修改灵活 。 当然，真实的应用场景里
	 * getBean("helloWorld"); 中的bean名（helloWorld）可能是定的，但是变的是xml文件中bean映射的class。
	 * 3.此处类代码里面写好了继承关系，但其实也可以通过xml来定义继承关系的。
	 */
	@Test
	public void test1() {
		// 通过运行路径来获取bean文件，然后生成一个bean容器
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		// 加载bean文件中的helloworld类,并且用接口接收该对象
		IHelloWorld helloWorld = (IHelloWorld) context.getBean("helloWorld");
		// 调用向世界问好的方法
		helloWorld.getMessage();

		// 加载bean文件中的helloChinese类,并且用接口接收该对象
		IHelloWorld helloChinese = (IHelloWorld) context.getBean("helloChinese");
		// 调用向中国人问好的方法
		helloChinese.getMessage();

		// 加载bean文件中的helloJapanse类,并且用接口接收该对象
		IHelloWorld helloJapanse = (IHelloWorld) context.getBean("helloJapanse");
		// 调用向日本人问好的方法
		helloJapanse.getMessage();
	}

	/*
	 * 第一步利用框架提供的 XmlBeanFactory() API 去生成工厂 bean 以及利用 ClassPathResource() API
	 * 去加载在路径 CLASSPATH 下可用的 bean 配置文件。XmlBeanFactory() API
	 * 负责创建并初始化所有的对象，即在配置文件中提到的 bean。
	 * 
	 * 第二步利用第一步生成的 bean 工厂对象的 getBean() 方法得到所需要的 bean。 这个方法通过配置文件中的 bean ID
	 * 来返回一个真正的对象，该对象最后可以用于实际的对象。一旦得到这个对象，你就可以利用这个对象来调用任何方法。 然鹅，这种方式好像已经被弃用了？
	 */
	@Test
	public void test2() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		obj.getMessage();
	}

	/*
	 * 第一步生成工厂对象。加载完指定路径下 bean 配置文件后，利用框架提供的 FileSystemXmlApplicationContext API
	 * 去生成工厂 bean。FileSystemXmlApplicationContext 负责生成和初始化所有的对象，比如，所有在 XML bean
	 * 配置文件中的 bean。
	 * 
	 * 第二步利用第一步生成的上下文中的 getBean() 方法得到所需要的 bean。 这个方法通过配置文件中的 bean ID
	 * 来返回一个真正的对象。一旦得到这个对象，就可以利用这个对象来调用任何方法。
	 */
	@Test
	public void test3() {
		/*
		 * 通过具体的物理路径加载上下文,获取一个bean容器。当然,也可以通过代码来获取实际路径,然后加载容器。
		 * 这一招跟上面的ClassPathXmlApplicationContext有点区别，上面那招要求文件是编译在项目路径里面的;
		 * 而这一招不需要，只要对应物理路径上面有这个文件就可以了。
		 */
		ApplicationContext context = new FileSystemXmlApplicationContext("d:\\Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}
}
