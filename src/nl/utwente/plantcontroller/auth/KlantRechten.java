package nl.utwente.plantcontroller.auth;

public class KlantRechten extends GebruikerRechten {
    @Override
    public boolean canPlaceOrder() {
        return true;
    }

    @Override
    public boolean canCheckOwnOrder() {
        return true;
    }

}
