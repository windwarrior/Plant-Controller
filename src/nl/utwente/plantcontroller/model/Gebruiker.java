package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.List;

public class Gebruiker {
    private String inlognaam;
    private String password;
    private List<Gebruikersrol> rollen = new ArrayList<Gebruikersrol>();

    public Gebruiker(String inlognaam, String password,
            List<Gebruikersrol> rollen) {
        this.inlognaam = inlognaam;
        this.password = password;
        this.rollen = rollen;
    }
    
    public String getInlogNaam(){
        return inlognaam;
    }
    
    public boolean checkLogin(String password){
        return this.password.equals(password);
    }
    
    public List<Gebruikersrol> getRollen(){
        return rollen;
    }

}