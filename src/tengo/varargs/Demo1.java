package tengo.varargs;

import java.util.List;

import org.junit.Test;

import java.util.Arrays;



public class Demo1 {

	public void sum(int... nums) {
		// 可变参数就把它当成数组
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		System.out.println(sum);
	}

	@Test
	public void testSum() {
		// 直接传N个参数
		sum(1, 5, 6, 8, 9, 7, 9, 7, 5);

		// 接收数组也可以
		sum(new int[] { 1, 2, 3, 5, 4, 8, 9 });
	}

	// 可变参数需要注意的问题！
	// public void sum2(int ...nums, int x) {
	// }

	// 如果把可变参数放在最后，就没问题了
	public void sum3(int x, int... nums) {
	}

	@Test
	public void bb() {
		List list = Arrays.asList("1", "2", "3");
		System.out.println(list);

		String arr[] = { "1", "2", "3" };
		list = Arrays.asList(arr);
		System.out.println(list);

		
		int nums[] = { 1, 2, 3, 5 };
		/*结果打印出来的是数组的地址！
		 * 这是因为可变参数一般传递的都是对象类型，而int类型不是对象，所以asList方法就获取了整个数组对象！
		 * */
		list = Arrays.asList(nums);
		System.out.println(list);
		
		//改成使用integer类即可！
		Integer nums2[] = { 1, 2, 3, 5 };
		list = Arrays.asList(nums2);
		System.out.println(list);
	}
}
