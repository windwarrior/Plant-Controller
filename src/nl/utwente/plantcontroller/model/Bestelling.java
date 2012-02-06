package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.List;

import nl.utwente.plantcontroller.util.SerialProvider;

public class Bestelling {

	private KlantenRol geplaatstDoor;

	private List<BestelItem> bestelItems = new ArrayList<BestelItem>();

	private int id;
	
	public Bestelling(KlantenRol k){
	    this.geplaatstDoor = k;
	    this.id = SerialProvider.getNextSerial();
	}
	
	/**
	 * Verkrijg de KlantenRol waardoor deze bestelling geplaatst is
	 * @return
	 */
	public KlantenRol getKlant(){
	    return geplaatstDoor;
	}
	
	/**
	 * Voeg een BestelItem toe aan deze Bestelling
	 * @param bi
	 */
	public void addProduct(BestelItem bi) {
	    bestelItems.add(bi);
	}
	
	/**
	 * Verkrijg de totale prijs van deze Bestelling
	 * @return
	 */
	public double getTotaalprijs() {
	    double prijs = 0.0;
		for(BestelItem bi : bestelItems){
		    prijs += bi.getPrijs();
		}
		return prijs;
	}
	
	/**
	 * Verkrijg de status van  deze Bestelling
	 * @return
	 */
	public Status getStatus(){
	    for(BestelItem bi : bestelItems){
	        if(bi.getHoeveelheidTeWeinig() > 0){
	            return Status.WACHTEN_OP_PRODUCTEN;
	        }
	    }
	    return Status.KLAAR;
	}
	
	/**
	 * Verkrijg het ID van deze bestelling
	 * @return
	 */
	public int getId(){
	    return id;
	}
	
	/**
	 * Verkrijg een string representatie van dit product
	 */
	public String toString(){
	    String result = "";
	    for(BestelItem b : bestelItems){
	        result += b.toString() + " ";
	    }
	    return result;
	}
	
	public List<BestelItem> getBestelItems(){
	    return bestelItems;
	}
	
}
