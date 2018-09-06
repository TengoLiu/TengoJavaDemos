package tengo.reflect;

import java.lang.reflect.Constructor;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//根据中文名称加载一个类
			Class c= Class.forName("tengo.reflect.Person");
		    
			//通过一个实例来获取该实例的类
			Class c2=new Person().getClass();
			
			//通过类来获取该类
			Class c3= Person.class;
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
