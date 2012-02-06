package nl.utwente.plantcontroller.auth;

public class GebruikerRechten implements AccountRechten {

    @Override
    public boolean canPlaceOrder() {
        return false;
    }

    @Override
    public boolean canCheckOwnOrder() {
        return false;
    }


    @Override
    public boolean canStartProductRun() {
        return false;
    }

    @Override
    public boolean canCheckStock() {
        return false;
    }

    @Override
    public boolean canCreateAccount() {
        return false;
    }

    @Override
    public boolean canCheckAllOrders() {
        return false;
    }

    @Override
    public boolean canCheckAccounts() {
        return false;
    }

}
