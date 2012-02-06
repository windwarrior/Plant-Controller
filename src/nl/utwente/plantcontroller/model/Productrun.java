package nl.utwente.plantcontroller.model;

import java.util.Map.Entry;

public class Productrun {
	
	private Product productsoort;
	private int hoeveelheid;
	
	public Productrun(Product productsoort, int hoeveelheid){
	    this.productsoort = productsoort;
	    this.hoeveelheid = hoeveelheid;
	}
	
	/**
	 * Bekijk of er voldoende vooraad van de onderdelen is om
	 * een productrun te kunnen starten
	 * @param n
	 * @return
	 */
	public boolean voldoendeVoorraad(int n) {
	    for(Entry<Onderdeel, Integer> onderdeel : productsoort.getSamenstelling().entrySet()){
	        if(onderdeel.getKey().getVooraad() < onderdeel.getValue() * n) return false;
	    }
	    return true;
	}
	
	/**
	 * Verkrijg het product dat deze Productrun gaat produceren
	 * @return
	 */
	public Product getProductSoort(){
	    return productsoort;
	}
	
	/**
	 * Verkrijg de hoeveelheid die deze productrun dient te produceren
	 * @return
	 */
    public int getHoeveelheid() {
        return hoeveelheid;
    }
    
    /**
     * Claim een aantal onderdelen voor een bestelling
     * @precondition voldoendeVooraad(n)
     * @param n
     */
    public boolean claimVooraden(int n) {
        if(!voldoendeVoorraad(n)) return false;
        for(Entry<Onderdeel, Integer> onderdeel : productsoort.getSamenstelling().entrySet()){
            Onderdeel o = onderdeel.getKey();
            int hoeveelheid = onderdeel.getValue() * n;
            o.verwijderVooraad(o.getVooraad() - hoeveelheid);
        }
        return true;
    }
}
