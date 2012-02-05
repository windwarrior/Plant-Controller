package nl.utwente.plantcontroller.model;

public class Onderdeel {
	private int besteld;
	private int gereserveerd;
	private double prijs;
	protected int vooraad;
    private String naam;
	
	public Onderdeel(double prijs, int vooraad, String naam){
	    this.prijs = prijs;
	    this.vooraad = vooraad;
	    this.naam = naam;
	}
	
    public double getPrijs() {
        return prijs;
    }
    
    public int getVooraad(){
        return vooraad;
    }
    
    public String toString(){
        return naam;
    }

    
    public void setVooraad(int vooraad){
        if(vooraad < 0) return;
        this.vooraad = vooraad;
    }
    
    
}
