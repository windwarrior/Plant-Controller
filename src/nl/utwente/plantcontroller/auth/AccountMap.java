package nl.utwente.plantcontroller.auth;

import java.util.HashMap;
import java.util.Map;

public class AccountMap {
    private Map<Account, AccountRechten> rechtenMap = new HashMap<Account, AccountRechten>();
    public AccountMap(String rootpassword){
        this.addToMap(new Account("root", rootpassword), new RootRechten());
        
    }
    
    public void addToMap(Account account, AccountRechten rechten){
        rechtenMap.put(account, rechten);
    }
}
