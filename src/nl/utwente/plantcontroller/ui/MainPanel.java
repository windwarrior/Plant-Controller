package nl.utwente.plantcontroller.ui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import nl.utwente.plantcontroller.auth.AccountRechten;
import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Gebruiker;
import nl.utwente.plantcontroller.model.KlantenRol;

public class MainPanel extends JTabbedPane implements ChangeListener{
    private static final long serialVersionUID = 7529387233922050727L;
    
    //De gebruiker die op dit moment ingelogd is
    private Gebruiker gebruiker;
    
    //Een bestelpaneel, hier kunnen bestellingen geplaatst worden
    private BestelPaneel bestelPaneel;
    
    //Een paneel waar alle bestellingen bekeken kunnen worden
    private AlleBestellingenPaneel alleBestellingenPaneel; 
    
    //Een paneel waar een gebruiker toegevoegd kan worden
    private VoegGebruikerToePaneel voegGebruikerToePaneel;
    
    //Een paneel waar de assemblagelijnen beheert kunnen worden
    private AssemblageLijnPaneel assemblageLijnPaneel;
    
    //Een paneel waar de klantgegevens bekeken kunnen worden
    private KlantenPaneel klantenPaneel;
    
    //Een paneel waarmee de vooraad van verschillende onderdelen bekeken kan worden
    private VooraadPaneel vooraadPaneel;
    
    //Het paneel waar een klant een bestelling kan plaatsen
    private KlantBestellingenPaneel klantenBestellingenPaneel;
    
    //De rechten van de gebruiker die ingelogd is
    private AccountRechten rechten;
    public MainPanel(Fabriek fabriek, Gebruiker g){
        this.gebruiker = g;
        this.rechten = g.getRol().getAccountRechten();
        bestelPaneel = new BestelPaneel(g, fabriek);
        alleBestellingenPaneel = new AlleBestellingenPaneel(fabriek);
        voegGebruikerToePaneel = new VoegGebruikerToePaneel(fabriek);
        assemblageLijnPaneel = new AssemblageLijnPaneel(fabriek);
        vooraadPaneel = new VooraadPaneel(fabriek);
        klantenPaneel = new KlantenPaneel(fabriek);
        if(g.getRol() instanceof KlantenRol){
            klantenBestellingenPaneel = new KlantBestellingenPaneel((KlantenRol)g.getRol());
        }
        init();
    }
    
    public void init(){
        this.addChangeListener(this);
        if(rechten.canPlaceOrder()) this.addTab("Bestel", bestelPaneel);
        if(rechten.canCheckAllOrders()) this.addTab("Alle Bestelingen", alleBestellingenPaneel);
        if(rechten.canCreateAccount()) this.addTab("Gebruiker toevoegen", voegGebruikerToePaneel);
        if(rechten.canStartProductRun()) this.addTab("AssemblageLijnen", assemblageLijnPaneel);
        if(rechten.canCheckStock()) this.addTab("Vooraad", vooraadPaneel);
        if(rechten.canCheckAccounts()) this.addTab("Personen", klantenPaneel);
        if(gebruiker.getRol() instanceof KlantenRol){
            this.addTab("Mijn Gegevens", klantenBestellingenPaneel);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        alleBestellingenPaneel.updateContents();
        assemblageLijnPaneel.updatePanel();
        vooraadPaneel.updatePanel();
        klantenPaneel.updatePanel();
        if(gebruiker.getRol() instanceof KlantenRol){
            klantenBestellingenPaneel.updatePanel();
        }
        System.out.println("Updating");
        
    }
}
