package tengo.enumsabs;

import org.junit.Test;

public class Demo {
	@Test
	public void test() {
		System.out.println(Grade.A.localValue());
	}
}

/*带抽象方法的枚举*/
enum Grade { 
	A("90-100"){
		public String localValue() {
			return "优";
		}
	}, 
	B("80-89"){
		public String localValue() {
			return "良";
		}
	},
	C("60-79"){
		public String localValue() {
			return "一般";
		}
	}, 
	D("60以下"){
		public String localValue() {
			return "不及格";
		}
	};

	// 假设规定90-100为A，80-89为B，60-79为C，60以下为D
	private String value;// 封装每个对象对应的分数

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	/*
	 * 如果是在外国，那么分数ABCD是没什么问题的，但是如果在中国的话，可能表示分数范围的方式就不一定了
	 * 在中国可能会用优良一般差不及格等来显示等级，那么就不能用上面的getValue方法了
	 * 需要在枚举值决定的时候同时把显示分数的方法也同时规定了
	 * 比如如果是90-100分的话，那么这就需要返回个“优”
	 */
	public abstract String localValue();
}