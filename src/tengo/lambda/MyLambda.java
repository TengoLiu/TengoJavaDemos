package tengo.lambda;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class MyLambda implements MsgInterface {

	/*
	 * 定义一个接口，并且接口里面仅仅包含一方法，这就相当于是委托了。 如果定义超过1个方法的话，会报错。
	 * 这不禁引起我的一点反思。以前做android的时候，经常会看到各种匿名方法，特别是添加点击监听器的时候。
	 * 当时是先让一个类继承某个Lisnter类的接口，然后接口里面会有一个处理点击的方法，然后在那个方法里面写点击处理的逻辑
	 */
	interface DelegateSum {
		int sum(int a, int b);
	}

	@Test
	public void test1() {
		// 创建一个委托的实例，将Lambda表达式绑定到接口里面的方法去
		DelegateSum delegate1 = (a, b) -> {
			return a + b;
		};
		System.out.println(delegate1.sum(1, 2));

	}

	/* 定义一个自定义的比较器 ,这个比较器继承Comparator接口，并且啥都没写，对比的逻辑在调用的时候动态传入 */
	interface MyCompare extends Comparator<Integer> {
	}

	@Test
	public void test2() {
		/*
		 * 通过lambda表达式注入一个对比的方法，由于参数和返回值跟接口里面的compare方法一致，因此会自动注入
		 */
		MyCompare delegate2 = (a, b) -> {
			// 我这里把比较器对比的代码反过来写了，因此后面排序之后本来应该正向排序的会变成逆向排序
			return b - a;
		};

		List<Integer> data = new ArrayList<Integer>();
		data.add(10);
		data.add(6);
		data.add(77);
		data.add(55);
		data.add(3);
		data.add(87);

		// 然后使用自定义的比较器进行比较
		data.sort(delegate2);

		// 当然也可以这么写
		data.sort((a, b) -> {
			// 我这里把比较器对比的代码反过来写了，因此后面排序之后本来应该正向排序的会变成逆向排序
			return b - a;
		});

		for (Integer integer : data) {
			System.err.print(integer + " ");
		}

		// 后面通过查询，发现还有这种写法，其实这跟我上面的写法是差不多的
		Collections.sort(data, (a, b) -> {
			// 我这里把比较器对比的代码反过来写了，因此后面排序之后本来应该正向排序的会变成逆向排序
			return b - a;
		});
	}

	/* 实现接口的方法 */
	@Override
	public void showMsg() {
		// TODO Auto-generated method stub
		System.out.println("传统方式提示有消息的方法：有消息啦~~~~~");
	}

	/*
	 * 这个例子我结合我自己以往的经验，对比了Lambda表达式注入构建匿名对象与以前方式的差别， 这个例子是通过我以前做 Android
	 * 的时候得出来的经验以及目前学到的内容结合而成的
	 */
	@Test
	public void test3() {
		/*
		 * 如果使用以前那套接口以及实现类的方法，一般来说是这样：先让某个实体类Class(为了偷懒，这里使用了当前的这个类)
		 * 实现某个接口Interface， 然后在那个类Class实现接口需要的方法， 然后调用实现了该接口Interface的对象的某个方法
		 */
		MsgInterface msgHelper = this;
		// 调用发消息的方法
		this.showMsg();

		/* 使用lambda的话，可以绕过实现类，直接将待实现的方法注入到一个实现了接口的匿名类里面，然后再调用这个实现了接口的匿名类下面的方法 */
		MsgInterface msgHelperDel = () -> {
			System.out.println("使用lambda注入的发消息方法：有新的消息啦~~~~~");
		};
		// 传统方式调用发消息的方法
		msgHelperDel.showMsg();

		// 接下来对比两个实现类的类型

		// 首先打印当前类的类型，意料之中:
		// class tengo.lambda.MyLambda
		System.out.println(this.getClass());
		// 然后再打印一下这个匿名类的类型:
		// class tengo.lambda.MyLambda$$Lambda$1/1490180672（不同机器结果或许会不同）
		// 由于这个MsgInterface接口实现类的对象仅仅是通过注入方法生成的一个匿名类的对象，因此可以看到，这个对象的类名是一串莫名其妙的字符
		System.out.println(msgHelperDel.getClass());

		// 再定义一个匿名类并注入方法
		MsgInterface msgHelperDel2 = () -> {
			System.out.println("使用lambda注入的发消息方法222：有新的消息啦222~~~~~");
		};
		msgHelperDel2.showMsg();

		// 然后再打印一下这个匿名类的类型:
		// class
		// tengo.lambda.MyLambda$$Lambda$2/1143839598（不同机器结果或许会不同，但这个类名跟上面的类名肯定是不一样的）
		// 由于这个对象还是实现了接口MsgInterface的匿名类的对象，由此可以看到，系统又给我们生成了一个莫名其妙的类名
		System.out.println(msgHelperDel2.getClass());
	}
}
