package com.software.java.proxy;

public class Film implements Animation {

	@Override
	public void clic() {
	}

	@Override
	public void dessine() {
		// TODO Auto-generated method stub
		 System.out.print(" Affichage (=|>)"); 

	}
	
	public void charge(){
		 System.out.print("Chargement  du film **  "); 
		
	}
	public void joue(){
		 System.out.print("Lecture du film (|>)"); 
		
	}

}
