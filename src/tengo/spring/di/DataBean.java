package tengo.spring.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 这个bean定义了一堆集合数据，这些数据后面要通过xml文件传入 */
public class DataBean {

	// 一个普通的集合
	List addressList;
	// 去重的集合
	Set addressSet;
	// 键值对集合
	Map addressMap;
	// 由hashtable实现的
	Properties addressProp;

	public List getAddressList() {
		return addressList;
	}

	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}

	public Set getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}

	public Map getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}

	public Properties getAddressProp() {
		return addressProp;
	}

	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}

}
