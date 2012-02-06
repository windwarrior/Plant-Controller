package nl.utwente.plantcontroller.model;

import nl.utwente.plantcontroller.auth.AccountRechten;

public abstract class GebruikersRol {
    /**
     * Verkrijg de rechten die deze Gebruikersrol heeft
     * @return
     */
    public abstract AccountRechten getAccountRechten();
}
