package com.software.java.proxy;

public class AnimationProxy implements Animation {
	
	String photo = "image.jpg";
	Film film;
	
	public  AnimationProxy(String photo) {
		
		this.photo = photo;
	}

	@Override
	public void clic() {
		// TODO Auto-generated method stub
		if(film == null){
			film = new Film();
			film.charge();
		}
		film.joue();

	}

	@Override
	public void dessine() {
		// TODO Auto-generated method stub
		if(film != null){
			film.dessine();
		}else{
			dessine(photo);
		}

	}
	
	public void dessine(String photo) {
		// TODO Auto-generated method stub
		
		 System.out.print(photo+"  ");  

	}

}
