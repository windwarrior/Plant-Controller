package nl.utwente.plantcontroller.auth;

public class OperatorRechten extends GebruikerRechten{
    @Override
    public boolean canCheckAllOrders() {
        return true;
    }
    
    
    @Override
    public boolean canStartProductRun() {
        return true;
    }
    
    @Override
    public boolean canCheckStock() {
        return true;
    }
    
}
