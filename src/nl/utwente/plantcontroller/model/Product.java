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
		
		public Product(Map<Onderdeel, Integer> samenstelling, long productieduur){
		    this.samenstelling = samenstelling;
		    this.productieduur = productieduur;
		}
		
		public List<Integer> bestelProduct(int aantal){
		    List<Integer> vooraadUitTeleveren = new ArrayList<Integer>();
		    for(int i = 0; i < serienummers.size() && i < aantal; i++){
		        vooraadUitTeleveren.add(serienummers.get(i));
		        serienummers.remove(i);
		    }
		    teLeveren += aantal - vooraadUitTeleveren.size();
		    
		    return vooraadUitTeleveren;
		}
		
		public void updateVooraad(int amount){
		    for(int i = 0; i < amount; i++){
		        serienummers.add(SerialProvider.getNextSerial());
		    }
		}
		
		public int getVooraad(){
		    return serienummers.size();
		}
		
		public long getProductieDuur(){
		    return productieduur;
		}
		
		public Map<Onderdeel, Integer> getSamenstelling(){
		    return samenstelling;
		}
}
