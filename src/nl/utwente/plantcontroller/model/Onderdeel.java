package nl.utwente.plantcontroller.model;

public class Onderdeel {
	private double prijs;
	protected int vooraad;
    private String naam;
	
	public Onderdeel(double prijs, int vooraad, String naam){
	    this.prijs = prijs;
	    this.vooraad = vooraad;
	    this.naam = naam;
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
        return vooraad;
    }
    
    /**
     * Verkrijg een string representatie van dit onderdeel
     */
    public String toString(){
        return naam;
    }

    /**
     * Zet de vooraad van dit product op een bepaalde waarde
     * @param vooraad
     * @return
     */
    public boolean setVooraad(int vooraad){
        if(this.vooraad < 0) return false;
        this.vooraad = vooraad;
        return true;
    }
    
    
}
