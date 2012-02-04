package nl.utwente.plantcontroller.model;

import java.util.Map.Entry;

public class Productrun {
	
	private Product productsoort;
	private int hoeveelheid;
	
	public Productrun(Product productsoort, int hoeveelheid){
	    this.productsoort = productsoort;
	    this.hoeveelheid = hoeveelheid;
	}
	
	public boolean voldoendeVoorraad(Product p, int n) {
	    for(Entry<Onderdeel, Integer> onderdeel : productsoort.getSamenstelling().entrySet()){
	        if(onderdeel.getKey().getVooraad() < onderdeel.getValue() * n) return false;
	    }
	    return true;
	}
}
