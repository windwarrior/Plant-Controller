package nl.utwente.plantcontroller.model;

import java.util.List;

import nl.utwente.plantcontroller.util.SerialProvider;

public class Bestelling {

	private KlantenRol geplaatstDoor;

	private List<BestelItem> bestelItems;

	private int id;

	private Status status;
	
	public Bestelling(KlantenRol k){
	    this.geplaatstDoor = k;
	    this.id = SerialProvider.getNextSerial();
	}
	
	public KlantenRol getKlant(){
	    return geplaatstDoor;
	}
	public void addProduct(BestelItem bi) {
	    bestelItems.add(bi);
	}
	
	public double getTotaalprijs() {
	    double prijs = 0.0;
		for(BestelItem bi : bestelItems){
		    prijs += bi.getPrijs();
		}
		return prijs;
	}
	
	public void updateStatus(Status newStatus){
	    this.status = newStatus;
	}
	
	public Status getStatus(){
	    return status;
	}
	
	public int getId(){
	    return id;
	}
	
}
