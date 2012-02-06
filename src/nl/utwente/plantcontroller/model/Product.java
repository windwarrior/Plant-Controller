package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Product extends Onderdeel {
		private Map<Onderdeel, Integer> samenstelling;
		private long productieduur;
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
		    for(Iterator<Integer> it = vooraadIds.iterator(); it.hasNext() && vooraadUitTeleveren.size() < aantal;){
		        vooraadUitTeleveren.add(it.next());
                it.remove();
            }
		    if(aantal - vooraadUitTeleveren.size() > 0){
		        nogTeVoldoen.add(b);
		    }
		    
		    return vooraadUitTeleveren;
		}
		
		@Override
		public synchronized void voegVooraadToe(int amount){
		    super.voegVooraadToe(amount);
		    for(BestelItem best : nogTeVoldoen){
                if(best.getHoeveelheidTeWeinig() > 0){
                    for(Iterator<Integer> it = vooraadIds.iterator(); it.hasNext() && best.getHoeveelheidTeWeinig() != 0;){
                        best.addNewBestelItem(it.next());
                        it.remove();
                    }
                }
            }
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
