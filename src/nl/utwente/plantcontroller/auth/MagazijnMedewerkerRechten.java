package nl.utwente.plantcontroller.auth;

public class MagazijnMedewerkerRechten extends GebruikerRechten{
    @Override
    public boolean canAssignProductToOrder() {
        return true;
    }
    
    @Override
    public boolean canCheckStock() {
        return true;
    }
    
    @Override
    public boolean canAddDeliveryToSystem() {
        return true;
    }
}
