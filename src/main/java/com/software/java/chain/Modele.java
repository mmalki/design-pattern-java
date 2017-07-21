package com.software.java.chain;
/**
 * 
 * @author Mohammed.MALKI
 *
 */
public class Modele extends ObjetBase {
	private String desc;
	
	public Modele(Marque marqueVide){
		super(marqueVide);	
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
