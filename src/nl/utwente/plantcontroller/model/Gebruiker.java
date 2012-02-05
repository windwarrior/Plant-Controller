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
    
    public String getInlogNaam(){
        return inlognaam;
    }
    
    public boolean checkLogin(String password){
        return this.password.equals(password);
    }
    
    public GebruikersRol getRol(){
        return rol;
    }

}