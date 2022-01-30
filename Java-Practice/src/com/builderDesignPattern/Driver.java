package com.builderDesignPattern;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Driver {

	public static void main(String[] args) {
		Computer computer=new Computer.computerBuilder("abc","16").setKeyboard("keyboard").setOs("MS").build();
		System.out.println(computer);

		ConcurrentHashMap<Integer, String>map=new ConcurrentHashMap<Integer, String>();
		map.put(1, "abc");
		Iterator iterator=map.keySet().iterator();
		while(iterator.hasNext()) {
			System.out.println("before size"+map.size());
			System.out.println(map.get(iterator.next()));
			map.put(2, "def");
			System.out.println("after size"+map.size());
		}
	}

}
