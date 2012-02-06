package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.List;

import nl.utwente.plantcontroller.util.SerialProvider;

public class Onderdeel {
	private double prijs;
    private String naam;
	protected List<Integer> vooraadIds = new ArrayList<Integer>();
	public Onderdeel(double prijs, int vooraad, String naam){
	    this.prijs = prijs;
	    this.naam = naam;
	    
	    for(int i = 0; i < vooraad; i++){
	        vooraadIds.add(SerialProvider.getNextSerial());
	    }
	}
	
	/**
	 * Verkrijg de prijs van dit onderdeel
	 * @return
	 */
    public double getPrijs() {
        return prijs;
    }
    
    /**
     * Verkrijg de vooraad van dit onderdeel
     * @return
     */
    public int getVooraad(){
        return vooraadIds.size();
    }
    
    /**
     * Verkrijg een string representatie van dit onderdeel
     */
    public String toString(){
        return naam;
    }
    
    public void voegVooraadToe(int hoeveelheid){
        for(int i = 0; i<hoeveelheid; i++){
            vooraadIds.add(SerialProvider.getNextSerial());
        }
    }

    /**
     * Zet de vooraad van dit product op een bepaalde waarde
     * @param vooraad
     * @return
     */
    public void setVooraad(int nieuweVooraad){
        if(nieuweVooraad > vooraadIds.size()){
            int hoeveelheid = nieuweVooraad - vooraadIds.size();
            voegVooraadToe(hoeveelheid);
        }else if(nieuweVooraad < vooraadIds.size()){
            int hoeveelheid = vooraadIds.size() - nieuweVooraad < 0 ? 0 : vooraadIds.size() - nieuweVooraad;
            verwijderVooraad(hoeveelheid);
        }
    }
    
    /**
     * Verwijder vooraad uit het systeem
     * @param n
     */
    public void verwijderVooraad(int n) {
        int p = n > vooraadIds.size() ?  vooraadIds.size() : n;
        for(int i = p-1; i >= 0; i--){
            vooraadIds.remove(i);
        }
    }
    
    
}
