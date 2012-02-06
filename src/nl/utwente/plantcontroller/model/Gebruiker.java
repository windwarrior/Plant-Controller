package nl.utwente.plantcontroller.model;

public class Gebruiker {
    private String inlognaam;
    private String password;
    private GebruikersRol rol;
    public Gebruiker(String inlognaam, String password,GebruikersRol rol) {
        this.inlognaam = inlognaam;
        this.password = password;
        this.rol = rol;
    }
    
    /**
     * Verkrijg de loginNaam van een gebruiker
     * @return
     */
    public String getInlogNaam(){
        return inlognaam;
    }
    
    /**
     * Bekijk of het wachtwoord "password" gelijk is aan het
     * interne wachtwoord, en daarmee te garanderen dat de
     * gebruiker kan inloggen op het systeem
     * @param password
     * @return
     */
    public boolean checkLogin(String password){
        return this.password.equals(password);
    }
    
    /**
     * Verkrijg de rol die deze gebruiker vervult in het systeem
     * @return
     */
    public GebruikersRol getRol(){
        return rol;
    }

}