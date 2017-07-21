package com.software.java;

import java.util.HashMap;

public class Singleton<K,V> {
	
	public static String name;
	private final static  Singleton instance = new Singleton(name);

	private Singleton(String name){
		
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			return new Singleton(name);
		}
		return instance;
	}
	
	public static <K,V>  HashMap<K,V> newMap(){
		return new HashMap<K,V>();
	}
	


}
