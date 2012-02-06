package nl.utwente.plantcontroller.auth;

public class VerkoopManagerRechten extends GebruikerRechten {
    @Override
    public boolean canCreateAccount() {
        return true;
    }

    @Override
    public boolean canCheckAccounts() {
        return true;
    }

    @Override
    public boolean canCheckAllOrders() {
        return true;
    }

}
