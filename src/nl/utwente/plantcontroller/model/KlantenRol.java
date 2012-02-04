package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.List;

public class KlantenRol extends Gebruikersrol {
    public KlantenRol(String naam, String adres){
        this.naam = naam;
        this.adres = adres;
    }
    
	private List bestellingen = new ArrayList();
	private String naam;
	private String adres;
	public void plaatsBestelling(Bestelling b) {};
	public void getBestellingen() {};
}
