package tengo.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/* 
 * 一个对象跟数据库行之间的映射转换类,用于将数据库原数据转化成对象Object
 * 这应该是早期还没有用到反射reflect的时候创造出来的设计模式吧
 * 等到有了反射之后，其实就可以直接传入一个类型以及行数据，然后就可以用反射来创建对象了，就不会说一个表有一个Mapper了，代码量极大
 *  */
public class StudentMapper implements RowMapper<Student> {
	// 一个将数据行转化成对象的映射方法
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		return student;
	}
}
