package tengo.spring.di;

/*
 * 使用di之后，依赖的对象可以通过构造函数传入
 * */
public class TextEditor {
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}

/*
 * 传统方法，在一个类里面new另外一个类的对象，这样就导致了这个类严重依赖另外一个类：
 * 
 * public class TextEditor {
 * 
 * private SpellChecker spellChecker;
 * 
 * public TextEditor() {
 * 
 * spellChecker = new SpellChecker();
 * 
 * }
 * 
 * }
 */
