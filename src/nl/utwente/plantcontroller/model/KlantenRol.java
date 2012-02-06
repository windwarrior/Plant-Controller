package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.List;

import nl.utwente.plantcontroller.auth.AccountRechten;
import nl.utwente.plantcontroller.auth.KlantRechten;

public class KlantenRol extends GebruikersRol {
    private KlantRechten rechten;
    private String naam;
    private String adres;
    private List<Bestelling> bestellingen = new ArrayList<Bestelling>();
            
    public KlantenRol(String naam, String adres){
        this.naam = naam;
        this.adres = adres;
        this.rechten = new KlantRechten();
    }
	
	public void plaatsBestelling(Bestelling b) {};
	public List<Bestelling> getBestellingen() {
	    
	    return bestellingen;
	};
	
	
	public String toString(){
	    return naam;
	}

    public String getAdres() {
        return adres;
    }

    @Override
    public AccountRechten getAccountRechten() {
        // TODO Auto-generated method stub
        return rechten;
    }

}
