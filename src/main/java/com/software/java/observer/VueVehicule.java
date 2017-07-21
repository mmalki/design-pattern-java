package com.software.java.observer;

public class VueVehicule implements Observateur {

	protected Vehicule vehicule;
    private String nameObs;
	protected String texte = "";

	public VueVehicule(Vehicule vehicule, String nameObs) {
		super();
		this.vehicule = vehicule;
		this.nameObs = nameObs;
		this.vehicule.ajoute(this);
		metAJourTexte();
	}

	protected void metAJourTexte() {
		texte = "Description " + vehicule.getDescription() + " Prix : " + vehicule.getPrix();
	}

	@Override
	public void actualise() {
		// TODO Auto-generated method stub
		 metAJourTexte();
		 redessine();

	}
	
	public void redessine(){
		System.out.println(" ----Nom Observer ---- " + nameObs);
		System.out.println(texte);
	}

	public String getNameObs() {
		return nameObs;
	}

	public void setNameObs(String nameObs) {
		this.nameObs = nameObs;
	}

}
