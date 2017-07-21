package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

import com.software.java.Singleton;
import com.software.java.builder.ChickenBurger;
import com.software.java.builder.Item;
import com.software.java.builder.Paked;
import com.software.java.builder.ProductWithManyConstructorParameters;
import com.software.java.builder.VegBurger;
import com.software.java.chain.Marque;
import com.software.java.chain.Modele;
import com.software.java.chain.ObjetBase;
import com.software.java.chain.Veh;
import com.software.java.observer.Vehicule;
import com.software.java.observer.VueVehicule;
import com.software.java.proxy.Animation;
import com.software.java.proxy.AnimationProxy;


public class TestJava {

	@Test
	public void testSingleton() {

		Singleton s1 = Singleton.getInstance();
		s1.name = "s1";
		Singleton s2 = Singleton.getInstance();
		HashMap<String, Singleton> m = new HashMap<>();
				//Singleton.newMap();

	    assertEquals(s1, s2);
	    assertEquals(s1.name, s2.name);

		
	}
	
	@Test
	public void testBuild(){
		
		ProductWithManyConstructorParameters p = ProductWithManyConstructorParameters.builder("attribut1").withAttribut2("attribut2").build();
		
		assertEquals("attribut1", p.getAt1());

		assertEquals("attribut1", p.getAt1());
	}
	
	@Test
	public void testBuildPacked(){
		
		Item b1 = new ChickenBurger();
		Item b2 = new ChickenBurger();
		Item b3 = new VegBurger();
		
		Paked paked = Paked.builder().addItem(b1).addItem(b2).build();
		paked.addItem(b3);
		assertEquals(2,paked.getItems().size());
		System.out.println(paked.affiche());
		paked = Paked.builder().addItem(b1).addItem(b2).addItem(b3).build();
		
		assertEquals(3,paked.getItems().size());
		System.out.println(paked.affiche());
		
		
		
	}
	
	@Test 
	public void testObserver(){
		
		Vehicule vehicule = new Vehicule();
		new VueVehicule(vehicule, "Obs 1");
		new VueVehicule(vehicule, "Obs 2");
		vehicule.setDescription("Voiture Bmw 318 D");

		assertEquals(vehicule.getObservateurs().size(), 2);		
		new VueVehicule(vehicule, "Obs 3");
		
		vehicule.setPrix(5000);

		assertEquals(vehicule.getObservateurs().size(), 3);
		

	}
	
	@Test
	public void testProxy(){

		List<Animation> animations = Arrays.asList(

				new AnimationProxy("image 1.jpg"), new AnimationProxy("image 2.jpg"), new AnimationProxy("image 3.jpg"),
				new AnimationProxy("image 4.jpg"), new AnimationProxy("image 5.jpg"),
				new AnimationProxy("image 6.jpg"));
		IntStream.range(0, animations.size()).forEach(idx -> {
			if((idx%3) == 0)System.out.println();
			animations.get(idx).dessine();
		});
		
		IntStream.range(0, animations.size()).forEach(idx -> {
			if((idx%3) == 0)System.out.println();
			if(idx == 2) animations.get(idx).clic();
			animations.get(idx).dessine();
		});
		
//		a.dessine();
//		a.clic();
//		a.dessine();
	}
	
	@Test
	public void testChainOfResponsability(){
		
		Marque marqueVide = new Marque(null);
		Marque bmw = new Marque(null);
		bmw.setDesc("Ceci est une marque BMW ");
		
		Modele modeleVide = new Modele(marqueVide);
		Modele modelemarque = new Modele(bmw);
		Modele modeleBmw = new Modele(bmw);
		modeleBmw.setDesc("Ceci est un model Bmw 318D");
		
		Veh vehVide = new Veh(modeleVide);
		Veh vehmarque = new Veh(modelemarque);
		Veh vehModele = new Veh(modeleBmw);
		Veh vehBmw = new Veh(modeleBmw);
		vehBmw.setDesc("Ceci est un Véhicule Bmw 318D avec 9 Cheveaux fiscaux");
		
		System.out.println(vehVide.donneDescription());
		System.out.println(vehmarque.donneDescription());
		System.out.println(vehModele.donneDescription());
		System.out.println(vehBmw.donneDescription());
		
	}
	
	@Test
	public void testList() {

	    List<String> modifiableList = new ArrayList<String>();
	    modifiableList.add("a");

	    System.out.println("modifiableList:"+modifiableList);
	    System.out.println("--");


	    //unModifiableList

	    assertEquals(1, modifiableList.size());

	    List<String> unModifiableList=Collections.unmodifiableList(
	                                        modifiableList);

	    modifiableList.add("b");

	    boolean exceptionThrown=false;
	    try {
	        unModifiableList.add("b");
	        fail("add supported for unModifiableList!!");
	    } catch (UnsupportedOperationException e) {
	        exceptionThrown=true;
	        System.out.println("unModifiableList.add() not supported");
	    }
	    assertTrue(exceptionThrown);

	    System.out.println("modifiableList:"+modifiableList);
	    System.out.println("unModifiableList:"+unModifiableList);

	    assertEquals(2, modifiableList.size());
	    assertEquals(2, unModifiableList.size());
	            System.out.println("--");



	            //immutableList


	    List<String> immutableList=Collections.unmodifiableList(
	                            new ArrayList<String>(modifiableList));

	    modifiableList.add("c");

	    exceptionThrown=false;
	    try {
	        immutableList.add("c");
	        fail("add supported for immutableList!!");
	    } catch (UnsupportedOperationException e) {
	        exceptionThrown=true;
	        System.out.println("immutableList.add() not supported");
	    }
	    assertTrue(exceptionThrown);


	    System.out.println("modifiableList:"+modifiableList);
	    System.out.println("unModifiableList:"+unModifiableList);
	    System.out.println("immutableList:"+immutableList);
	    System.out.println("--");

	    assertEquals(3, modifiableList.size());
	    assertEquals(3, unModifiableList.size());
	    assertEquals(2, immutableList.size());

	}

}
