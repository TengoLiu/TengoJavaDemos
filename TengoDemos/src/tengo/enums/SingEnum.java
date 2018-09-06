package tengo.enums;

public class SingEnum {

}

/*
 * 定义一个枚举，这个枚举只有一个值
 * 别人也不可能说再定义别的A，
 * 那么EnumA类型的对象就只有A一个
 * 这就用单态设计模式定义了一个类
 * */
enum EnumA{//class
	A;//Object
}