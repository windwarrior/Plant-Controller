package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nl.utwente.plantcontroller.util.SerialProvider;

public class Product extends Onderdeel {
		
		private int teLeveren = 0;
		private Map<Onderdeel, Integer> samenstelling;
		private long productieduur;
		private List<Integer> serienummers = new ArrayList<Integer>();
		private List<BestelItem> nogTeVoldoen = new ArrayList<BestelItem>();
        private String naam;
		
		public Product(Map<Onderdeel, Integer> samenstelling, long productieduur, double prijs, int vooraad, String naam){
		    super(prijs, vooraad, naam);
		    this.samenstelling = samenstelling;
		    this.productieduur = productieduur;
		    this.naam = naam;
		}
		
		private Product(double prijs, int vooraad, String naam){
		    super(prijs, vooraad,naam);
		}
		
		public List<Integer> bestelProduct(BestelItem b){
		    int aantal = b.getAantal();
		    List<Integer> vooraadUitTeleveren = new ArrayList<Integer>();
		    for(int i = 0; i < serienummers.size() && i < aantal; i++){
		        vooraadUitTeleveren.add(serienummers.get(i));
		        serienummers.remove(i);
		    }
		    teLeveren += aantal - vooraadUitTeleveren.size();
		    if(aantal - vooraadUitTeleveren.size() > 0){
		        System.out.println("voeg een debiteur toe");
		        nogTeVoldoen.add(b);
		    }
		    return vooraadUitTeleveren;
		}
		
		public synchronized void updateVooraad(int amount){
		    for(int i = 0; i < amount; i++){
		        serienummers.add(SerialProvider.getNextSerial());
		    }
		    
		    for(BestelItem best : nogTeVoldoen){
		        if(best.getHoeveelheidTeWeinig() > 0){
		            int hoeveelheid = best.getHoeveelheidTeWeinig() >= amount ? amount : best.getHoeveelheidTeWeinig();
		            for(int i = 0; i < hoeveelheid; i++){
		                best.addNewBestelItem(serienummers.get(i));
		                serienummers.remove(i);
		            }
		            
		            amount -= hoeveelheid;
		            
		            if(amount == 0) return;
		        }
		    }
		}
		
		public synchronized int getVooraad(){
		    return serienummers.size();
		}
		
		public long getProductieDuur(){
		    return productieduur;
		}
		
		public Map<Onderdeel, Integer> getSamenstelling(){
		    return samenstelling;
		}
}
