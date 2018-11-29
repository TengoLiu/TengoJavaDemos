package tengo.stream_io_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class MyStream {

	/* 此例获取控制台输入的字符 */
	@Test
	public void test1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;

		System.out.println("请输入字符串.....");

		// 读取输入内容的第一个字符
		i = br.read();

		// 如果没有到底的话，一直读并且打印
		while (i > 0) {// 如果读到-1说明已经读完了
			char c = (char) i;
			System.out.println(c);
			i = br.read();
		}
	}

	/* 获取输入的行 */
	@Test
	public void test2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("请输入字符串行.....");

		// 读取输入内容的第一个字符
		String s = br.readLine();
		System.out.println("输入的行为：" + s);
	}

	/* 将一波内容输出到控制台 */
	@Test
	public void test3() throws IOException {
		System.out.write('a');
		System.out.write('\n');
	}
}
