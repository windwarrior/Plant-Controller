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
	    product.bestelProduct(this);
	}
	
	public void addNewBestelItem(int serial){
	    System.out.println("Voeg thingie toe");
	    gereserveerd.add(serial);
	}

    public double getPrijs() {
        return product.getPrijs() * aantal;
    }
    
    public String toString(){
        return product.toString() + " "  + aantal;
    }
    
    public Product getProduct(){
        return product;
    }
    
    public int getAantal(){
        return aantal;
    }
    
    public int getHoeveelheidTeWeinig(){
        return aantal - gereserveerd.size();
    }
}
