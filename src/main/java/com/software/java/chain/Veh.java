package com.software.java.chain;
/**
 * 
 * @author Mohammed.MALKI
 *
 */
public class Veh  extends ObjetBase{
	
	private String desc;
	
	public Veh(Modele v){
		super(v);	
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


}
