package com.software.java.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujet {
	
	private List<Observateur> observateurs = new ArrayList<>();
	
	public List<Observateur> getObservateurs() {
		return observateurs;
	}

	public void setObservateurs(List<Observateur> observateurs) {
		this.observateurs = observateurs;
	}

	public void ajoute(Observateur obs){
		observateurs.add(obs);
		
	}
	
	public void retire(Observateur obs){
		observateurs.remove(obs);
	}
	
	public void notifie(){
		observateurs.forEach((a) -> a.actualise() );

	}

}
