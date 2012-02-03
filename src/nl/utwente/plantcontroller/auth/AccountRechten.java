package nl.utwente.plantcontroller.auth;

public interface AccountRechten {
    /**
     * true als een gebruiker kan inloggen
     * @return
     */
    public boolean canLogin();
    /**
     * true als een gebruiker kan uitloggen
     * @return
     */
    public boolean canLogout();
    /**
     * true als de gebruiker een bestelling kan plaatsen
     * @return
     */
    public boolean canPlaceOrder();
    /**
     * true als een gebruiker zijn bestellingen kan bekijken
     * @return
     */
    public boolean canCheckOwnOrder();
    /**
     * true als een gebruiker details van een bestelling kan bekijken
     * @return
     */
    public boolean canCheckDetailsOfOrder();
    /**
     * true als een gebruiker openstaande order kan bekijken
     * @return
     */
    public boolean canCheckOpenOrders();
    /**
     * true als een gebruiker een productrun kan starten
     * @return
     */
    public boolean canStartProductRun();
    /**
     * true als een gebruiker de voorraad van een onderdeel kan bekijken
     * @return
     */
    public boolean canCheckStock();
    
    /**
     * true als een gebruiker een nieuw account kan aanmaken
     * @return
     */
    public boolean canCreateAccount();
    
    /**
     * true als de gebruiker alle bestellingen kan bekijken
     * @return
     */
    public boolean canCheckAllOrders();
    
    /**
     * true als een gebruiker een product kan toewijzen aan een order
     * @return
     */
    public boolean canAssignProductToOrder();
    
    /**
     * true als een gebruiker een aangekomen bestelling kan toevoegen aan het systeem
     * @return
     */
    public boolean canAddDeliveryToSystem();
    
    
    public boolean canCheckAccounts();
}
