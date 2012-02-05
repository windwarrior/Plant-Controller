package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fabriek {
		private List<Gebruiker> gebruikers = new ArrayList<Gebruiker>();
		private List<Bestelling> bestellingen = new ArrayList<Bestelling>();
		private Assemblagelijn[] lijnen;
		private List<Product> productTypen;
		
		public Fabriek(){
		    lijnen = new Assemblagelijn[10];
		    for(int i = 0; i < 10; i++){
		        lijnen[i] = new Assemblagelijn();
		    }
		    
		    productTypen = new ArrayList<Product>();
		    List<Gebruikersrol> gebruikersrollijst = new ArrayList<Gebruikersrol>();
		    gebruikersrollijst.add(new KlantenRol("Root", "Het system"));
		    gebruikers.add(new Gebruiker("admin", "admin", gebruikersrollijst));
		    productTypen.add(new Product(null,0,"product 1"));
		}
		
		public void bestel(Bestelling b) {
		    bestellingen.add(b);
		};
		
		public void voegProductToe(Product p){
		    productTypen.add(p);
		}
		
		public void voegGebruikerToe(String inlognaam, String wachtwoord, Gebruikersrol... rollen){
		    gebruikers.add(new Gebruiker(inlognaam, wachtwoord, Arrays.asList(rollen)));
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
                if(prod.getNaam().equals(name)){
                    return prod;
                }
            }
            return null;
		    
		}
}
