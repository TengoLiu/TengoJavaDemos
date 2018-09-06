package tengo.enums;

import org.junit.Test;

public class Demo {
	@Test
	public void test() {
		print(Grade.A);
		print(Grade.B);
		print(Grade.C);
		print(Grade.D);
	}

	// 必须传Grade，但是又不能自己new Grade，所以只能传规定好的ABCD
	public void print(Grade grade) { // 需要规定这个方法只能传入A、B、C、D
		System.out.println(grade.getValue());
	}

	@Test
	public void test2() {
		System.out.println(Grade.C.name());
		System.out.println(Grade.C.ordinal());

		// 将子浮窗转化为枚举，一般在前台提交数据到后台的时候可能会用到
		// 如果不是规定的字符串的话，那么会报错
		String str = "B";
		// Grade grade=Grade.valueOf(Grade.class,str);
		Grade grade = Grade.valueOf(str);
		System.out.println(grade);

		//遍历枚举里面的所有值
		for (Grade g1 : Grade.values()) {
			System.out.println(g1);
		}
	}
}

/*
 * 而新的方式直接使用枚举即可！ 其实枚举也是一个类！ 枚举也可以定义构造方法，字段，从而封装更多的信息
 */
enum Grade { //
	// A, B, C, D;//Object

	A("90-100"), B("80-89"), C("60-79"), D("60以下");

	// 假设规定90-100为A，80-89为B，60-79为C，60以下为D
	private String value;// 封装每个对象对应的分数

	// 枚举的构造函数必须是私有的，如果是public的话，那么别人就可以随便new出对象了，这样枚举的范围限定性就无用了！
	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

/*
 * JAVA5之前 老的方法是定义一个Grade类，然后隐藏构造方法，使调用者不能随便实例化这这个类 而只能调用这个类里面的动态属性， 从而实现输入值的限定
 */
/*
 * class Grade { // 先把 private Grade() { }
 * 
 * public static final Grade A = new Grade(); public static final Grade B = new
 * Grade(); public static final Grade C = new Grade(); public static final Grade
 * D = new Grade();
 * 
 * }
 */