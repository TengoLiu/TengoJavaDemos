package tengo.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/*Date类型的相关应用*/
public class MyDate {

	/* 时间的简单格式化 */
	@Test
	public void test1() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS。\n y年。\n M月。\n d日。\n H时。\n m分。\n s秒。\n S毫秒。\n现在时段：a。 \n当前星期：E。\n本年中第D天。\n时区z。\n本月中第W周。\n本年度第w周。\n");
		System.out.println("现在是:" + format.format(date));
	}

	/* 时间的比较，大于0表示比传入的值大，小于0表示比传入的值小，等于0代表时间相等 */
	@Test
	public void test2() {
		System.out.println("比较时间小于: " + new Date(2018, 1, 1).compareTo(new Date(2019, 1, 1)));
		System.out.println("比较时间等于: " + new Date(2019, 1, 1).compareTo(new Date(2019, 1, 1)));
		System.out.println("比较时间大于: " + new Date(2020, 1, 1).compareTo(new Date(2019, 1, 1)));
	}

	/*
	 * 使用时间戳来生成时间,基于1970年1月1日 注意，我这里写的是long类型的数字，因此在数字后面加了个l
	 */
	@Test
	public void test3() {
		Date date = new Date(1542958839797l);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		System.out.println("时间戳对应的时间为:" + format.format(date));
	}

	/* 将字符串按照时间格式化转成时间 */
	@Test
	public void test4() {
		String dateStr = "2018-11-23 16:22:33:236";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

		try {
			Date date = format.parse(dateStr);
			System.out.println("从字符串转化成的时间为:" + format.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/* 计算时间间隔，一般先转化成毫秒数，然后再相减得出 */
	@Test
	public void test5() {
		Date date1 = new Date(2018, 11, 26);
		Date date2 = new Date(2018, 11, 1);
		long diff = date1.getTime() - date2.getTime();
		System.out.println("两个时间的差值(毫秒数)为:" + diff);
	}
	
	/*
	 * 如果一个时间需要同时输出多种格式的话，如果用SimpleDateFormat的话，就会不方便了，可以想象：
	 * SimpleDateFormat format1=xxx
	 * SimpleDateFormat format2=xxx
	 * SimpleDateFormat format3=xxx
	 * ...
	 * 难道我们要定义N个格式么？
	 * 当然不用。在JAVA里面有相应的格式化的方法的
	 * 用String的格式化
	 * 其中 String.fomat（fomat,args）里面参数里面的%t表示格式化的是一个date类型，
	 * F代表格式化时间对应的格式
	 * 转  换  符                                         说    明                                                               示    例
     * 	 c          包括全部日期和时间信息                               星期六 十月 27 14:21:20 CST 2007
	 *   F          "年-月-日"格式					  2007-10-27
	 *   D			"月/日/年"格式					  10/27/07
	 *   r			"HH:MM:SS PM"格式（12时制）		  02:25:51 下午	
	 *   T			"HH:MM:SS"格式（24时制）		  14:28:16
	 *   R			"HH:MM"格式（24时制）			  14:28
	 * */
	@Test
	public void test6() {
		Date date = new Date();

		// 仅输出一个格式化
		System.out.println(String.format("年-月-日格式：%tF", date));
		System.out.println(String.format("时:分:秒格式：%tT", date));

		/*
		 * 如果要输出多个格式化的话，那么做法就有一些不同了。
		 * 可以利用一个格式化字符串指出要被格式化的参数的索引。
		 * 索引必须紧跟在%后面，而且必须以$结束。例如：*/
		System.out.println(String.format("%1$s：%2$tF %2$tT", "the date is", date));
		System.out.println(String.format("%1$s：%2$tD %2$tr %2$tR", "the date is", date));
	}

}
