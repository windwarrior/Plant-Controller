package nl.utwente.plantcontroller.auth;

public interface AccountRechten {

    /**
     * true als de gebruiker een bestelling kan plaatsen
     * 
     * @return
     */
    public boolean canPlaceOrder();

    /**
     * true als een gebruiker zijn bestellingen kan bekijken
     * 
     * @return
     */
    public boolean canCheckOwnOrder();

    /**
     * true als een gebruiker een productrun kan starten
     * 
     * @return
     */
    public boolean canStartProductRun();

    /**
     * true als een gebruiker de voorraad van een onderdeel kan bekijken
     * 
     * @return
     */
    public boolean canCheckStock();

    /**
     * true als een gebruiker een nieuw account kan aanmaken
     * 
     * @return
     */
    public boolean canCreateAccount();

    /**
     * true als de gebruiker alle bestellingen kan bekijken
     * 
     * @return
     */
    public boolean canCheckAllOrders();

    /**
     * true als een gebruiker gegevens van alle accounts kan bekijken
     * 
     * @return
     */
    public boolean canCheckAccounts();
}
