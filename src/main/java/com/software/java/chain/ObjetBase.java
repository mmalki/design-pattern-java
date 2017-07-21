package com.software.java.chain;
/**
 * 
 * @author Mohammed.MALKI
 *
 */
public abstract class ObjetBase {
	
	ObjetBase suivant;
	
	public abstract String getDescription();
	
	public  String getDefaultDescription(){
		return "Ceci est une description par defaut";
	}
	
	public  String donneDescription(){
		String res = this.getDescription();
		
		if(res != null){
			return res;
		}else if(suivant != null){
			return suivant.donneDescription();
		}else {
		    return getDefaultDescription();
		}

	}

	public ObjetBase(ObjetBase suivant) {
		super();
		this.suivant = suivant;
	}


}
