package tengo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {
	
	/*
	 * 将图片转化成二进制字节
	 * */
	public static byte[] readFileBytes(String path) throws IOException {
		byte[] buffer = null;

		File f = new File(path);
		if (f.exists()) {
			FileInputStream fis = new FileInputStream(f);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000*1000);
			byte[] b = new byte[1000];
			int n = 0;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		}
		return buffer;
	}
}
