package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fabriek {
		private List<Gebruiker> gebruikers = new ArrayList<Gebruiker>();
		private List<Bestelling> bestellingen = new ArrayList<Bestelling>();
		private Assemblagelijn[] lijnen;
		private List<Product> productTypen;
		private List<Onderdeel> onderdeelTypen;
		public Fabriek(){
		    lijnen = new Assemblagelijn[10];
		    for(int i = 0; i < 10; i++){
		        lijnen[i] = new Assemblagelijn();
		    }
		    
		    onderdeelTypen = new ArrayList<Onderdeel>();
            onderdeelTypen.add(new Onderdeel(4.7, 40, "Onderdeel 1"));
            onderdeelTypen.add(new Onderdeel(3.5, 17, "Onderdeel 2"));
            onderdeelTypen.add(new Onderdeel(1.0, 35, "Onderdeel 3"));
            onderdeelTypen.add(new Onderdeel(2.7, 96, "Onderdeel 4"));
            onderdeelTypen.add(new Onderdeel(3.1, 10, "Onderdeel 5"));
		    
		    productTypen = new ArrayList<Product>();
		    gebruikers.add(new Gebruiker("admin", "admin", new RootRol()));
		    Map<Onderdeel, Integer> onderdeelMap = new HashMap<Onderdeel, Integer>();
		    onderdeelMap.put(onderdeelTypen.get(0), 4);
		    onderdeelMap.put(onderdeelTypen.get(2), 2);
		    onderdeelMap.put(onderdeelTypen.get(4), 1);
		    productTypen.add(new Product(onderdeelMap,100, 10.0, 4, "product 1"));
		    productTypen.add(new Product(null,100, 17.0, 6, "product 2"));
		    productTypen.add(new Product(null,100, 40.0, 7, "product 3"));
		    
		    
		    
		}
		
		/**
		 * Plaats een bestelling bij deze fabriek
		 * @param b
		 */
		public void bestel(Bestelling b) {
		    bestellingen.add(b);
		};
		
		/**
		 * Voeg een nieuw product toe aan de catalogus van deze fabriek
		 * @param p
		 */
		public void voegProductToe(Product p){
		    productTypen.add(p);
		}
		
		/**
		 * Voeg een gebruiker toe aan deze fabriek, geeft true als het toevoegen
		 * gelukt is
		 * @param inlognaam
		 * @param wachtwoord
		 * @param rol
		 * @return
		 */
		public boolean voegGebruikerToe(String inlognaam, String wachtwoord, GebruikersRol rol){
		    for(Gebruiker g: gebruikers){
		        if(g.getInlogNaam().equalsIgnoreCase(inlognaam)){
		            return false;
		        }
		    }
		    gebruikers.add(new Gebruiker(inlognaam, wachtwoord, rol));
		    return true;
		}
		
		/**
		 * Check of een gebruiker bestaat in het systeem, en daarmee kan inloggen
		 * @param login
		 * @param password
		 * @return
		 */
		public Gebruiker checkGebruiker(String login, String password){
		    for(Gebruiker gebruiker : gebruikers){
		        if(gebruiker.getInlogNaam().equalsIgnoreCase(login) && gebruiker.checkLogin(password)){
		            return gebruiker;
		        }
		    }
		    System.out.println("bah");
		    return null;
		}
		
		/**
		 * Verkrijg alle mogelijke productTypen die deze fabriek kan produceren
		 * @return
		 */
		public List<Product> getProductTypen(){
		    return productTypen;
		}
		
		/**
		 * Verkrijg een product op basis van zijn naam
		 * Geeft een product waarvan de naam gelijk is aan name,
		 * anders geeft het null
		 * @param name
		 * @return
		 */
		public Product getProductBijNaam(String name){
            for(Product prod : productTypen){
                if(prod.toString().equals(name)){
                    return prod;
                }
            }
            return null;
		    
		}
		
		/**
		 * Verkrijg alle geplaatste bestellingen bij deze fabriek
		 * @return
		 */
        public List<Bestelling> getBestellingen() {
            return bestellingen;
        }
        
        /**
         * Verkrijg alle assemblagelijnen die deze fabriek bevat
         * @return
         */
        public Assemblagelijn[] getAssemblagelijnen(){
            return lijnen;
        }
        
        /**
         * Verkrijg alle onderdelen die deze fabriek heeft
         * @return
         */
        public List<Onderdeel> getOnderdelen(){
            return onderdeelTypen;
        }
        
        /**
         * Verkrijg alle gebruikers van deze fabrieks
         * @return
         */
        public List<Gebruiker> getGebruikers() {
            return gebruikers;
        }
}
