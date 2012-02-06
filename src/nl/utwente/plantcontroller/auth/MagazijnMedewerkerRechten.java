package nl.utwente.plantcontroller.auth;

public class MagazijnMedewerkerRechten extends GebruikerRechten {

    @Override
    public boolean canCheckStock() {
        return true;
    }
}
