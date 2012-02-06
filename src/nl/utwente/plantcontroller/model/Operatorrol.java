package nl.utwente.plantcontroller.model;

import nl.utwente.plantcontroller.auth.AccountRechten;
import nl.utwente.plantcontroller.auth.OperatorRechten;

public class Operatorrol extends GebruikersRol {
    private OperatorRechten rechten;

    public Operatorrol(){
        this.rechten = new OperatorRechten();
    }

    @Override
    public AccountRechten getAccountRechten() {
        // TODO Auto-generated method stub
        return rechten;
    }
}
