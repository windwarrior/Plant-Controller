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
	
    /**
     * Plaats een bestelling b bij deze KlantRol
     * @param b
     */
	public void plaatsBestelling(Bestelling b) {
	    bestellingen.add(b);	    
	};
	
	/**
	 * Verkrijg alle bestellingen die deze klant geplaatst heeft
	 * @return
	 */
	public List<Bestelling> getBestellingen() {
	    return bestellingen;
	};
	
	/**
	 * Verkrijg een string representatie van deze klant
	 */
	public String toString(){
	    return naam;
	}
	
	/**
	 * Verkrijg het adres van deze persoon
	 * @return
	 */
    public String getAdres() {
        return adres;
    }

    @Override
    public AccountRechten getAccountRechten() {
        return rechten;
    }

}
