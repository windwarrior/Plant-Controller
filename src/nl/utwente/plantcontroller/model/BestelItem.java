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
	    List<Integer> productjes = product.bestelProduct(this);
	    for(Integer serial : productjes){
	        addNewBestelItem(serial);
	    }
	}
	
	/**
	 * Verbindt een product met een zekere serial met dit BestelItem
	 * @param serial
	 */
	public void addNewBestelItem(int serial){
	    gereserveerd.add(serial);
	}

	/**
	 * Verkrijgt de totaalprijs van dit BestelItem
	 * @return
	 */
    public double getPrijs() {
        return product.getPrijs() * aantal;
    }
    
    /**
     * Geeft een string representatie van dit product
     */
    public String toString(){
        return product.toString() + " "  + aantal;
    }
    
    /**
     * Verkrijg het product waarover dit BetelItem gaat
     * @return
     */
    public Product getProduct(){
        return product;
    }
    
    /**
     * Verkrijg de hoeveelheid aangevraagde producten
     * @return
     */
    public int getAantal(){
        return aantal;
    }
    
    /**
     * Verkrijg de hoeveelheid producten die nog niet geproduceerd zijn
     * @return
     */
    public int getHoeveelheidTeWeinig(){
        return aantal - gereserveerd.size();
    }
}
