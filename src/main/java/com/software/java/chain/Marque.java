package com.software.java.chain;
/**
 * 
 * @author Mohammed.MALKI
 *
 */
public class Marque extends ObjetBase {
	

	private String desc;

	public Marque(ObjetBase suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
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
