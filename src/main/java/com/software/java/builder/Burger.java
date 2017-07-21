package com.software.java.builder;

public abstract class Burger implements Item {

	@Override
	public Packing Packing() {
		// TODO Auto-generated method stub
		return new Wrapped();
	}
	

}
