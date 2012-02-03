package nl.utwente.plantcontroller.auth;

public class RootRechten extends GebruikerRechten{
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
        return true;
    }

    @Override
    public boolean canCheckOwnOrder() {
        return true;
    }

    @Override
    public boolean canCheckDetailsOfOrder() {
        return true;
    }

    @Override
    public boolean canCheckOpenOrders() {
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

    @Override
    public boolean canCreateAccount() {
        return true;
    }

    @Override
    public boolean canCheckAllOrders() {
        return true;
    }

    @Override
    public boolean canAssignProductToOrder() {
        return true;
    }

    @Override
    public boolean canAddDeliveryToSystem() {
        return true;
    }

    @Override
    public boolean canCheckAccounts() {
        return true;
    }
}
