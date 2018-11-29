package tengo.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class MyCalendar {

	/*
	 * 实例化并且设置时间
	 */
	@Test
	public void test1() {
		// 创建实例，默认是当前日期
		Calendar c = Calendar.getInstance();

		System.out.println();
		// 仅仅设置年月日
		c.set(2009, 6 - 1, 12);

		// 设置年月日时分,注意，月份的范围是0-11,如果设置的值超过11，那么就会对11求余，用余数来设置月份
		c.set(2009, 6 - 1, 12, 12, 31);

		// 设置年月日时分秒
		c.set(2009, 6 - 1, 12, 12, 31, 59);

		// 也可以设置单个字段
		c.set(Calendar.YEAR, 2018);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 28);
		// ...

		c = Calendar.getInstance();
		System.out.println("Now is：" + String.format("%1$d-%2$d-%3$d %4$d:%5$d:%6$d:%7$d", // format
				c.get(Calendar.YEAR), // 年份
				c.get(Calendar.MONTH) + 1, // 注意，月份的范围是0-11,因此输出的时候要把取出来的月份+1
				c.get(Calendar.DATE), // 日期
				c.get(Calendar.HOUR_OF_DAY), // 24小时制的小时
				c.get(Calendar.MINUTE), // 分钟
				c.get(Calendar.SECOND), // 秒
				c.get(Calendar.MILLISECOND)));// 毫秒
		System.out.println("时（12小时制）：" + c.get(Calendar.HOUR));
		// 输出星期几，注意，1=周日，2=周一，3=周二...
		// 这个是按照外国人的习惯来设定的，他们一般把周日当做是一周的第一天
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
	}

	/*
	 * Calendar时间的加减
	 */
	@Test
	public void test2() {
		Calendar c = Calendar.getInstance();

		System.out.println("当前时间：" + printCalendar(c));
		c.add(Calendar.YEAR, 10);// 对年份加10
		System.out.println("加了之后：" + printCalendar(c));

		c = Calendar.getInstance();
		System.out.println("当前日期：" + printCalendar(c));
		c.add(Calendar.DATE, 10);// 对日期加10
		System.out.println("加后日期：" + printCalendar(c));
	}

	// 打印Calendar
	public String printCalendar(Calendar c) {
		return String.format("%1$d-%2$d-%3$d %4$d:%5$d:%6$d:%7$d", // format
				c.get(Calendar.YEAR), // 年份
				c.get(Calendar.MONTH) + 1, // 注意，月份的范围是0-11,因此输出的时候要把取出来的月份+1
				c.get(Calendar.DATE), // 日期
				c.get(Calendar.HOUR_OF_DAY), // 24小时制的小时
				c.get(Calendar.MINUTE), // 分钟
				c.get(Calendar.SECOND), // 秒
				c.get(Calendar.MILLISECOND));// 毫秒
	}

	/*
	 * 此处介绍一个Calendar抽象类的具体实现类 这个类返回一个calendar的实例，有一些它自己定义的方法
	 */
	@Test
	public void test3() {
		GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
		System.out.println("2018 是否是闰年：" + calendar.isLeapYear(2018));
		System.out.println("2020 是否是闰年：" + calendar.isLeapYear(2020));
	}
}
