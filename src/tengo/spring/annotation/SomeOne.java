package tengo.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SomeOne {

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	// 定义属性自动装配，这样在xml文件里面就不需要写property等连接的配置了，框架会自动找属性名跟bean名对应的bean来填充
	@Autowired
	//由于有很多个类型为Student的bean，此处设置装配student1
	@Qualifier("student1")
	private Student student;

	public SomeOne() {
	}
}
