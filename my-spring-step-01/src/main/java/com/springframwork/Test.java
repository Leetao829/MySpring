package com.springframwork;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.HashMap;
import java.util.Map;

class Person{
	private Map<String,String> map = new HashMap<>();

	public static int x;
	public void put(){
		map.put("1","2");
	}


}
class Woman extends Person{

}
public class Test {


	public static void main(String[] args) {
		//System.setProperty("java.vm.name", "Java HotSpot(TM)");
		System.out.println(ObjectSizeCalculator.getObjectSize(4));
		System.out.println(ObjectSizeCalculator.getObjectSize('a'));
		System.out.println(ObjectSizeCalculator.getObjectSize(4L));
		System.out.println(ObjectSizeCalculator.getObjectSize(new Person()));
		Woman woman = new Woman();
		woman.put();
		System.out.println(ObjectSizeCalculator.getObjectSize(woman));
	}

}
