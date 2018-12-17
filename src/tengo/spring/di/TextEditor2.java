package tengo.spring.di;

public class TextEditor2 {
	private SpellChecker spellChecker;

	public TextEditor2() {
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	// 定义一个设置函数，让外界可以给这个内部依赖对象赋值
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
