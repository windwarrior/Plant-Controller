package nl.utwente.plantcontroller.auth;

public class RootRechten extends GebruikerRechten {
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
        //Dit is niet strict noodzakelijk voor een rootgebruiker
        return false;
    }

    @Override
    public boolean canCheckOwnOrder() {
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
    public boolean canCheckAccounts() {
        return true;
    }
}
