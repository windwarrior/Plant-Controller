package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nl.utwente.plantcontroller.util.SerialProvider;

public class Product extends Onderdeel {
		private Map<Onderdeel, Integer> samenstelling;
		private long productieduur;
		private List<Integer> serienummers = new ArrayList<Integer>();
		private List<BestelItem> nogTeVoldoen = new ArrayList<BestelItem>();
		
		public Product(Map<Onderdeel, Integer> samenstelling, long productieduur, double prijs, int vooraad, String naam){
		    super(prijs, vooraad, naam);
		    this.samenstelling = samenstelling;
		    this.productieduur = productieduur;
		}
		
		private Product(double prijs, int vooraad, String naam){
		    super(prijs, vooraad,naam);
		}
		
		/**
		 * Plaats een bestelling
		 * @param b
		 * @return
		 */
		public List<Integer> bestelProduct(BestelItem b){
		    int aantal = b.getAantal();
		    List<Integer> vooraadUitTeleveren = new ArrayList<Integer>();
		    for(int i = 0; i < serienummers.size() && i < aantal; i++){
		        vooraadUitTeleveren.add(serienummers.get(i));
		        serienummers.remove(i);
		    }
		    if(aantal - vooraadUitTeleveren.size() > 0){
		        System.out.println("voeg een debiteur toe");
		        nogTeVoldoen.add(b);
		    }
		    return vooraadUitTeleveren;
		}
		
		/**
		 * Verander de vooraad van dit product,
		 * zodat bestellingen hun vooraad ook kunnen updaten
		 * @param amount
		 */
		public synchronized void updateVooraad(int amount){
		    for(int i = 0; i < amount; i++){
		        serienummers.add(SerialProvider.getNextSerial());
		    }
		    
		    for(BestelItem best : nogTeVoldoen){
		        if(best.getHoeveelheidTeWeinig() > 0){
		            
		            for(int i = 0; i < best.getHoeveelheidTeWeinig() && i < amount; i++){
		                best.addNewBestelItem(serienummers.get(i));
		                serienummers.remove(i);
		            }
		            
		        }
		    }
		    
		    vooraad += amount;
		}
		
		/**
		 * Zet de vooraad van een product op een zeker getal
		 */
		@Override
		public boolean setVooraad(int vooraad){
		    updateVooraad(vooraad);
		    return true;
		}
		
		/**
		 * Verkrijg de vooraad van dit product
		 */
		public synchronized int getVooraad(){
		    return serienummers.size();
		}
		
		/**
		 * Verkrijg de productieduur van dit product
		 * @return
		 */
		public long getProductieDuur(){
		    return productieduur;
		}
		
		/**
		 * Verkrijg een map van alle onderdelen noodzakelijk om dit
		 * product te kunnen maken
		 * @return
		 */
		public Map<Onderdeel, Integer> getSamenstelling(){
		    return samenstelling;
		}
}
