package tengo.path;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Demo1 {

	/*
	 * 获取class执行所在目录的路径，如果在windows里面就是bin目录下这个类对应的物理路径。
	 * 
	 * 但是不知道为啥，获取到的路径前面会有一个“/”
	 */
	@Test
	public void test1() throws IOException {
		String path = this.getClass().getResource("").getPath();
		System.out.println(path);
	}

	/* 获取当前项目所在路径的根目录 */
	@Test
	public void test2() throws IOException {
		// 先new一个文件夹，这个文件夹的路径不写，那么就映射到了项目的根目录下
		File directory = new File("");
		// 然后再获取这个啥都没有的文件夹（其实就是根路径）的物理路径即可
		String courseFile = directory.getCanonicalPath();
		System.out.println(courseFile);

	}

	/* 这种方式获取到的路径前面同样也会有一个“/” */
	@Test
	public void test3() throws IOException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		System.out.println(path);
	}
}
