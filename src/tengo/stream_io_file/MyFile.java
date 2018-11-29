package tengo.stream_io_file;

import java.io.*;

import org.junit.Test;

/*总结java里面的文件套路就是,所有文件都应该先初始化成一个File对象，然后再做相应的操作*/
public class MyFile {

	/*
	 * 通过二进制流的方式写入文件，这样做有可能导致问题是，如果不指定读取的编码，那么读出来的内容有可能是乱码
	 */
	@Test
	public void write() throws IOException {
		// 创建一个输出流，用于把我们的内容写入到指定的文件中,第二个bool参数是代表是否仅拼接在文本后面
		OutputStream f = new FileOutputStream("C:/1.txt");
		String str = "你好！~~~很高兴遇到你~~~";

		// 使用未知的编码写入（有可能是本机默认的编码）
		f.write(str.getBytes());

		// 使用指定的编码写入，这样后面就一定能通过指定的编码读出来
		f.write(str.getBytes("UTF-8"));
		f.close();
	}

	/*
	 * 通过二进制流的方式读取文件里面的内容,这样做有可能导致读出来的内容是乱码
	 */
	@Test
	public void read() throws IOException {
		InputStream in = new FileInputStream("C:/1.txt");
		String str = new String();

		// 一个个字符地读
		int c = in.read();
		while (c > 0) {
			str += (char) c;// 把读到的字符拼接到结果中
			c = in.read();// 然后继续读下一个
		}
		in.close();
		System.out.println("从文本中读到的数据为：" + str);
	}

	/*
	 * 通过OutputStreamWriter的方式写入文本内容到文件，这样做可以指定写入的编码。 其步骤为:1.创建文件对象,2.创建输出流,3.
	 * 创建OutputStreamWriter并写入文本到文件
	 */
	@Test
	public void write2() throws IOException {
		File f = new File("C:/1.txt");
		OutputStream out = new FileOutputStream(f);
		OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
		writer.append("你好！~~~很高兴遇到你~~~");
		writer.close();
		out.close();
	}

	/*
	 * 通过InputStreamReader的方式读取文本里面的内容, 这样有个好处就是可以自己指定读取的编码,
	 * 其步骤为:1.创建文件对象,2.创建输入流,3.创建InputStreamReader并读取文本
	 */
	@Test
	public void read2() throws IOException {
		File f = new File("C:/1.txt");
		InputStream in = new FileInputStream(f);
		InputStreamReader reader = new InputStreamReader(in, "UTF-8");

		StringBuffer sb = new StringBuffer();

		// 当reader为ready的状态下,说明还没读完,可以继续读,这跟inputStream还是有点区别的
		while (reader.ready()) {
			// 转成char加到StringBuffer对象中
			sb.append((char) reader.read());
		}

		reader.close();
		in.close();
		System.out.println("从文本中读到的数据为：" + sb);
	}

	/*
	 * 创建文件夹
	 * mkdir()方法创建一个文件夹，成功则返回true，失败则返回false。失败表明File对象指定的路径已经存在，或者由于整个路径还不存在，
	 * 该文件夹不能被创建。 mkdirs()方法创建一个文件夹和它的所有父文件夹。
	 */
	@Test
	public void createDir() {
		String dirname = "d:/tmp/java/";
		File file = new File(dirname);
		// 创建目录
		file.mkdirs();
	}

	/* 遍历文件夹下的所有文件，并且判断其目录下所有的文件是不是文件夹 */
	@Test
	public void dirList() {
		String dirname = "d:/";
		File file = new File(dirname);
		if (file.isDirectory()) {
			System.out.println("准备遍历目录 " + dirname);
			// 获取文件夹下所有文件的名称列表（得到的文件名称不包含完整路径，仅仅是本文件名称），注意，获取的仅仅是文件名
			String s[] = file.list();
			for (int i = 0; i < s.length; i++) {
				File f = new File(dirname + "/" + s[i]);
				if (f.isDirectory()) {
					System.out.println(s[i] + " 是一个目录");
				} else {
					System.out.println(s[i] + " 是一个文件");
				}
			}
		} else {
			System.out.println(dirname + " 不是一个目录");
		}
	}

	@Test
	public void delDir() {
		File dir = new File("/tmp/java/");
		deleteFolder(dir);
	}

	/* 递归遍历子项删除文件夹以及文件夹下面的所有文件 */
	public static void deleteFolder(File dir) {
		// 获取文件夹下面的所有文件列表，注意，返回的列表是一个个File的对象，而不是名称
		File[] files = dir.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					// 如果是文件夹的话，那么就递归调用本方法删除文件夹下的所有文件
					deleteFolder(f);
				} else {
					// 如果是文件的话，那么就直接删除了
					f.delete();
				}
			}
		}
	}
}
