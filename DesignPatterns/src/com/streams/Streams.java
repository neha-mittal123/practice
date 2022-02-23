package com.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		List<List<String>> list=Arrays.asList(
				Arrays.asList("abc","def"),
				Arrays.asList("lmn","pqr"),
				Arrays.asList("xyz","ghi"));
		
		List<String> flattenList=list.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(flattenList);
		
		int count=(int) flattenList.stream().filter(name->name.startsWith("a")).count();
		System.out.println(count);
		

	}

}
