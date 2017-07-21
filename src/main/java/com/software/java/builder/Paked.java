package com.software.java.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paked {
	
	private List<Item> items;
	private final float cost;
	
	public static PakedBuilder builder(){
		return new PakedBuilder();
	}
	
	
	public static class PakedBuilder implements Builder<Paked>{
		
		private List<Item> items = new ArrayList<>();
		private float cost = 0;

		@Override
		public Paked build() {
			// TODO Auto-generated method stub
			return new Paked(this);
		}
		
		public PakedBuilder addItem(Item item){
			this.items.add(item);
			calculeCost(item.price());
			return this;
		}
		private void calculeCost(float costItem){
			this.cost += costItem;
		}
		
	}

	private Paked(PakedBuilder pakedBuilder) {
		// TODO Auto-generated constructor stub
		this.items = Collections.unmodifiableList(new ArrayList<>(pakedBuilder.items));
		this.cost = pakedBuilder.cost;
	}

	public List<Item> getItems() {
		return items;
	}

	public float getCost() {
		return cost;
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}
	
	public String affiche(){
		String res="";
		for (Item item : items) {
			res += "Item  Name : "+item.name() + ", Price : "+ item.price() + "\n";
		}
		
		
		res += "Total Cost ="+ this.cost; 
		return res;
		
	}


}
