package tengo.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;


//反射方法并执行
public class Demo4 {
	Class class1;

	public Demo4() throws Exception {
		class1 = Class.forName("tengo.reflect.Person");
	}

	// 取出 run()方法，并执行
	@Test
	public void test1() throws Exception {
		Person person = new Person();
		Method method = class1.getMethod("run", null);

		// 指定一个对象执行方法
		method.invoke(person, null);
	}

	// 取出 run(String name,int password)方法，并执行,别的类同
	@Test
	public void test2() throws Exception {
		Person person = new Person();
		Method method = class1.getMethod("run", String.class, int.class);

		// 指定一个对象执行方法
		method.invoke(person, "tengo", 1);
	}

	// 取出 run(String name,int[] password)方法，并执行,并且得到执行后的参数
	@Test
	public void test3() throws Exception {
		Person person = new Person();
		Method method = class1.getMethod("run", String.class, int[].class);

		// 指定一个对象执行方法,并且获取方法返回的参数
		Object object = method.invoke(person, "tengo", new int[] { 1 });
		Class[] classes = (Class[]) object;
		System.out.println(classes[0]);
	}

	// 取出 private run(InputStream inputStream)方法，并执行,并且得到执行后的参数
	@Test
	public void test4() throws Exception {
		Person person = new Person();
		Method method = class1.getMethod("run", InputStream.class);
		method.setAccessible(true);// 暴力破解
		method.invoke(person, new FileInputStream("c:\\1.txt"));
	}

	// 取出 public static run(int num)方法，并执行
	@Test
	public void test5() throws Exception {
		Method method = class1.getMethod("run", int.class);
		// 静态方法执行不需要对象，當然，就算放一个对象上去，也没啥问题
		method.invoke(null, 1);
	}

	// 取出 public static void main(String[] args)
	@Test
	public void test6() throws Exception {
		Method method = class1.getMethod("main", String[].class);

		/*
		 * 直接去调用那个方法，结果发现报错了 原来是可变参数问题！ jdk 1.4 如果参数传入String[]{"aa","bb"}，那么会寻找
		 * main(String a,String b){} jdk 1.5 可变参数改成了main(String...
		 * a){}，但仍然要兼容JDK1.4，因此当我们传入一个字符串数组的 时候，程序还是会去找 main(String a,String
		 * b){}这个方法而沒有去找我想讓它執行的方法，结果就是发现没有找到这个方法，因而报错了，這應該算是JAVA的一個BUG吧
		 * 
		 */
		//method.invoke(null, new String[] { "1", "2" });

		/* 那么补救方法也是有的如下面两个 */
		//既然你想从拆，那我就故意再包一层让你拆
		method.invoke(null, new Object[] { new String[] { "1", "2" } });

		//或者我把类型强转隐藏了，事实上还是数组
		method.invoke(null, (Object) new String[] { "1", "2" });
	}
}
