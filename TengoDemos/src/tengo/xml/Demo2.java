package tengo.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Demo2 {
	Document document;

	@Test
	public void test() throws Exception, IOException {
		// 1.创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 2.得到DOM解析器
		DocumentBuilder builder = factory.newDocumentBuilder();

		// 3.解析xml文档，得到代表文档的Document
		document = builder.parse("src/tengo/xml/book.xml");

	}

	/* 取得文档里面的某一些节点 */
	@Test
	public void read1() throws Exception {
		// 先调用这个方法，免得document
		test();

		// 读取xml里面所有标签名为“书名”的节点集合,通过节点名称来获取所有元素，当然，也还有别的方式，比如通过id等
		NodeList list = document.getElementsByTagName("书名");

		// 查看文档，可以看到有item这个方法来获取集合里面的元素
		Node node = list.item(1);
		// 然后获取节点里面的文本值
		String name = node.getTextContent();
		System.out.println(name);

	}

	// 遍历DOM文档的所有节点
	@Test
	public void read2() throws Exception {
		// 先调用这个方法，免得document
		test();

		// 首先得到根节点
		Node root = document.getElementsByTagName("书架").item(0);
		list(root);
	}

	// 递归遍历节点
	private void list(Node node) {
		// 判断节点是不是节点，因为如果是空格的话，也会被算作是一个节点，然后输入#text
		if (node instanceof Element) {
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			list(list.item(i));
		}
	}

	// 得到xml文档中标签属性的值： <书名 name="xxx">ASP.NET MVC高级编程</书名>
	@Test
	public void read3() throws Exception {
		// 先调用这个方法，免得document
		test();

		// 得到属性列表，但是这么做的话，后面又要通过下标来取得属性，非常麻烦
		// Node bookname = document.getElementsByTagName("书名").item(0);
		// NamedNodeMap map = bookname.getAttributes();

		// 于是，当我们知道这个节点确实是一个标签的时候，我们可以把这个节点强转成Element,然后用element来直接取属性
		Element bookname = (Element) document.getElementsByTagName("书名").item(0);
		String value = bookname.getAttribute("name");
		System.out.println(value);
	}

}
