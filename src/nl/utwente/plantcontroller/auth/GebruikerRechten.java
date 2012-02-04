package nl.utwente.plantcontroller.auth;

public class GebruikerRechten implements AccountRechten {

    @Override
    public boolean canLogin() {
        return true;
    }

    @Override
    public boolean canLogout() {
        return true;
    }

    @Override
    public boolean canPlaceOrder() {
        return false;
    }

    @Override
    public boolean canCheckOwnOrder() {
        return false;
    }

    @Override
    public boolean canCheckDetailsOfOrder() {
        return false;
    }

    @Override
    public boolean canCheckOpenOrders() {
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
    public boolean canAssignProductToOrder() {
        return false;
    }

    @Override
    public boolean canAddDeliveryToSystem() {
        return false;
    }

    @Override
    public boolean canCheckAccounts() {
        return false;
    }

}
