package tengo.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;

import tengo.jdbc.bean.Person;

public class Demo {

	private static Connection getConn() {
		/*驱动的包名*/
		// String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.1.187:3306/tengo";
		String username = "root";
		String password = "123456";
		Connection conn = null;
		try {
			/*此处由于我已经把mysql的jar包给buildpath了，因此没啥必要写这个*/
			// Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private static void query() {
		Connection conn = getConn();
		String sql = "select * from persons";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println("");
			}
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static int delete(int id) {
		Connection conn = getConn();
		int i = 0;
		String sql = "delete from persons where id>" + id;
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	private static int update(Person person) {
		Connection conn = getConn();
		int i = 0;
		String sql = "update persons set name=? where id=" + person.getId();
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1,  person.getName());
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	private static int insert(Person person) {
		Connection conn = getConn();
		int i = 0;
		String sql = "insert into persons (Name) values(?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, person.getName());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Test
	public void test1() {
		getConn();
		query();
		Person person = new Person();
		person.name = "陈总";
		insert(person);
		update(person);
		delete(5);
		query();
	}
}
