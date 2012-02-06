package nl.utwente.plantcontroller.model;

import nl.utwente.plantcontroller.auth.AccountRechten;
import nl.utwente.plantcontroller.auth.MagazijnMedewerkerRechten;

public class Magazijnrol extends GebruikersRol {
    private MagazijnMedewerkerRechten rechten;
    public Magazijnrol(){
        this.rechten = new MagazijnMedewerkerRechten();
    }
    @Override
    public AccountRechten getAccountRechten() {
        return rechten;
    }
}
