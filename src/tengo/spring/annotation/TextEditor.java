package tengo.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	// 定义自动装配，这样在xml文件里面就不需要写property等连接的配置了，框架会自动找属性名跟bean名对应的bean来填充
	@Autowired
	private SpellChecker spellChecker;

	public TextEditor() {
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
