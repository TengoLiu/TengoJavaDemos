package tengo.generic;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Demo {
	public static void main(String[] args) {
		// JDK1.5之前，集合只能放Object，这也就导致了程序的不安全性，即运行的时候才报错！
		/*
		 * List list=new ArrayList<>(); 
		 * list.add("abc"); 
		 * Integer integer=(Integer) list.get(0);
		 */

		List<String> list = new ArrayList<String>();
		list.add("sss");

		String string = list.get(0);
	}

	@Test
	public void test1() {

		List<String> list = new ArrayList<String>();
		list.add("sss");
		list.add("ddd");
		list.add("xxx");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Test
	public void test2() {
		// 注意，引用不能为基本类型，如int，如果要用的话，必须要写成Integer
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		map.put(3, "ccc");

		// 传统keyset、entryset遍历,后者比较常用
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			int key = entry.getKey();
			String val = entry.getValue();
			System.out.println("key:" + key + ",value:" + val);
		}

		// 或者使用增强for循环
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			int key = entry.getKey();
			String val = entry.getValue();
			System.out.println("key:" + key + ",value:" + val);
		}
	}

	@Test
	public void test3() {
		// 用泛型时，如果两边都用了泛型，那么两边的泛型必须一致！
		// List<String> list = new ArrayList<Object>();
		// List<Object> list = new ArrayList<String>();

		// 但是如果一边用一边不用的话，倒是可以的，这主要是为了让JDK5和5之后的代码能够互相兼容
		// 比如JDK5的人调高级版本的JDK，或者JDK高级版本调用JDK5及以下版本
		List<String> list = new ArrayList();
		List list2 = new ArrayList<String>();

	}
}
