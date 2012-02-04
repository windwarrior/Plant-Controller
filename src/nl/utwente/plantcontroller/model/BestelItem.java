package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.List;

public class BestelItem {
    
	private Product product;
	private int aantal;
	private List<Integer> gereserveerd = new ArrayList<Integer>();
	
	public BestelItem(Product product, int aantal){
	    this.product = product;
	    this.aantal = aantal;
	}
	
	public void addNewBestelItem(int serial){
	    gereserveerd.add(serial);
	}

    public double getPrijs() {
        return product.getPrijs() * aantal;
    }
}
