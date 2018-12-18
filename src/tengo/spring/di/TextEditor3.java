package tengo.spring.di;

public class TextEditor3 {
	private SpellChecker spellChecker;

	public TextEditor3() {
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	// 定义一个设置函数，让外界可以给这个内部依赖对象赋值
	public void setSpellChecker2(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
