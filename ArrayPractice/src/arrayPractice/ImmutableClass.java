package arrayPractice;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {
	private final int id;
	private final Map<String,String> map;

	public ImmutableClass(int id, Map<String, String> map) {
		this.id = id;
		Map<String,String> temp=new HashMap<String, String>();
		for(Map.Entry<String, String> entry : map.entrySet()) {
			temp.put(entry.getKey(),entry.getValue());
		}
		this.map = temp;
	}
	public int getId() {
		return id;
	}
	public Map<String, String> getMap() {
		Map<String,String> temp=new HashMap<String, String>();
		for(Map.Entry<String, String> entry : this.map.entrySet()) {
			temp.put(entry.getKey(),entry.getValue());
		}
		return temp;
	}
	public static void main(String[] args) {
		Map<String,String> temp=new HashMap<String, String>();
		temp.put("String","immutable");
		temp.put("wrapper","immutable");
		ImmutableClass s=new ImmutableClass(1, temp);
		System.out.println(s.getId()+" "+s.getMap());
		//s.map.clear();// coz main is in the same class so driver class should be different
		s.getMap().clear();
		System.out.println(s.getId()+" "+s.getMap());

	}

}
