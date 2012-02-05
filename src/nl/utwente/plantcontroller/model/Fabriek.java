package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		    
		    productTypen = new ArrayList<Product>();
		    gebruikers.add(new Gebruiker("admin", "admin", new KlantenRol("Admin", "Adminstraat 26")));
		    productTypen.add(new Product(null,100, 10.0, 4, "product 1"));
		    productTypen.add(new Product(null,100, 17.0, 6, "product 2"));
		    productTypen.add(new Product(null,100, 40.0, 7, "product 3"));
		    
		    onderdeelTypen = new ArrayList<Onderdeel>();
		    onderdeelTypen.add(new Onderdeel(4.7, 29, "Onderdeel 1"));
		    onderdeelTypen.add(new Onderdeel(3.5, 17, "Onderdeel 2"));
		    onderdeelTypen.add(new Onderdeel(1.0, 35, "Onderdeel 3"));
		    onderdeelTypen.add(new Onderdeel(2.7, 96, "Onderdeel 4"));
		    onderdeelTypen.add(new Onderdeel(3.1, 10, "Onderdeel 5"));
		    
		}
		
		public void bestel(Bestelling b) {
		    bestellingen.add(b);
		};
		
		public void voegProductToe(Product p){
		    productTypen.add(p);
		}
		
		public boolean voegGebruikerToe(String inlognaam, String wachtwoord, GebruikersRol rol){
		    for(Gebruiker g: gebruikers){
		        if(g.getInlogNaam().equalsIgnoreCase(inlognaam)){
		            return false;
		        }
		    }
		    gebruikers.add(new Gebruiker(inlognaam, wachtwoord, rol));
		    return true;
		}
		
		public Gebruiker checkGebruiker(String login, String password){
		    for(Gebruiker gebruiker : gebruikers){
		        if(gebruiker.getInlogNaam().equalsIgnoreCase(login) && gebruiker.checkLogin(password)){
		            return gebruiker;
		        }
		    }
		    System.out.println("bah");
		    return null;
		}
		
		public List<Product> getProductTypen(){
		    return productTypen;
		}
		
		public Product getProductBijNaam(String name){
            for(Product prod : productTypen){
                if(prod.toString().equals(name)){
                    return prod;
                }
            }
            return null;
		    
		}

        public List<Bestelling> getBestellingen() {
            // TODO Auto-generated method stub
            return bestellingen;
        }
        
        public Assemblagelijn[] getAssemblagelijnen(){
            return lijnen;
        }
        
        public List<Onderdeel> getOnderdelen(){
            return onderdeelTypen;
        }
}
