package tengo.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor2 {

	private SpellChecker spellChecker;

	// 定义构造函数自动装配，这样在xml文件里面就不需要写property等连接的配置了，框架会自动找属性名跟bean名对应的bean来填充
	@Autowired
	public TextEditor2(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
