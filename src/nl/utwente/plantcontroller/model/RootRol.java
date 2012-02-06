package nl.utwente.plantcontroller.model;

import nl.utwente.plantcontroller.auth.AccountRechten;
import nl.utwente.plantcontroller.auth.RootRechten;

/**
 * Denk er nieteens over na dit te releasen :p
 * @author lennart
 *
 */
public class RootRol extends GebruikersRol{
    private RootRechten rechten;
    public RootRol(){
        this.rechten = new RootRechten();
    }
    @Override
    public AccountRechten getAccountRechten() {
        return rechten;
    }

}
