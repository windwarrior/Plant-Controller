package nl.utwente.plantcontroller.model;

import nl.utwente.plantcontroller.auth.AccountRechten;
import nl.utwente.plantcontroller.auth.VerkoopManagerRechten;

public class Verkopersrol extends GebruikersRol {
    
    private VerkoopManagerRechten rechten;

    public Verkopersrol(){
        this.rechten = new VerkoopManagerRechten();
    }

    @Override
    public AccountRechten getAccountRechten() {
        return rechten;
    }
}
