package tengo.number;

import org.junit.Test;

/* 从这里,可以延伸出一点东西,就是java里面的比较,==是比较地址,而equals是比较值的内容 */
public class Demo {
	@Test
	public void test1() {
		int i = 100;
		int j = 100;

		// “==”号比较的是对象的地址是否相等,由于两者都是值类型，因此比较是相等的
		System.out.println(i == j);

		/*
		 * Java 会对 -128 ~ 127 的整数进行缓存，所以当定义两个变量初始化值位于 -128 ~ 127 之间时，两个变量使用了同一地址
		 */
		Integer a = 100;
		Integer b = 100;
		// “==”号比较的是对象的地址是否相等
		System.out.println(a == b);
		// equals比较的是对象的内容是否相等
		System.out.println(a.equals(b));

		/*
		 * 当两个 Integer 变量的数值超出 -128 ~ 127 范围时, 变量使用了不同地，老夫惭愧， 基本上是头一次见这样的设定
		 */
		a = 1200;
		b = 1200;
		// “==”号比较的是对象的地址是否相等
		System.out.println(a == b);
		// equals比较的是对象的内容是否相等
		System.out.println(a.equals(b));
	}

	@Test
	public void test2() {
		/**
		 * Integer i1 = 128; // 装箱，相当于 Integer.valueOf(128); int t = i1; //相当于
		 * i1.intValue() 拆箱 System.out.println(t);
		 */

		/**
		 * 对于–128到127（默认是127）之间的值,被装箱后，会被放在内存里进行重用 但是如果超出了这个值,系统会重新new 一个对象
		 */
		Integer i1 = 200;
		Integer i2 = 200;

		/**
		 * 注意 == 与 equals的区别 == 它比较的是对象的地址 equals 比较的是对象的内容
		 */
		if (i1 == i2) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}
}
