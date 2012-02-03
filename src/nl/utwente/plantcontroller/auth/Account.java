package nl.utwente.plantcontroller.auth;

public class Account {
    private final String name;
    private final String password;

    public Account(final String name, final String password){
        this.name= name;
        this.password = password;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPassword(){
        return password;
    }
}
