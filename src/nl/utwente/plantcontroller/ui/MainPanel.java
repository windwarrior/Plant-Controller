package nl.utwente.plantcontroller.ui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import nl.utwente.plantcontroller.auth.AccountRechten;
import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Gebruiker;
import nl.utwente.plantcontroller.model.GebruikersRol;
import nl.utwente.plantcontroller.model.KlantenRol;

public class MainPanel extends JTabbedPane implements ChangeListener{
    private Gebruiker g;
    private BestelPaneel p;
    private AlleBestellingenPaneel a; 
    private VoegGebruikerToePaneel v;
    private AssemblageLijnPaneel ap;
    private PersonenPaneel pp;
    private VooraadPaneel vp;
    private KlantBestellingenPaneel kbp;
    private AccountRechten rechten;
    public MainPanel(Fabriek fabriek, Gebruiker g){
        this.g = g;
        this.rechten = g.getRol().getAccountRechten();
        p = new BestelPaneel(g, fabriek);
        a = new AlleBestellingenPaneel(fabriek);
        v = new VoegGebruikerToePaneel(fabriek);
        ap = new AssemblageLijnPaneel(fabriek);
        vp = new VooraadPaneel(fabriek);
        pp = new PersonenPaneel(fabriek);
        if(g.getRol() instanceof KlantenRol){
            kbp = new KlantBestellingenPaneel((KlantenRol)g.getRol());
        }
        init();
    }
    
    public void init(){
        this.addChangeListener(this);
        if(rechten.canPlaceOrder()) this.addTab("Bestel", p);
        if(rechten.canCheckAllOrders()) this.addTab("Alle Bestelingen", a);
        if(rechten.canCreateAccount()) this.addTab("Gebruiker toevoegen", v);
        if(rechten.canStartProductRun()) this.addTab("AssemblageLijnen", ap);
        if(rechten.canCheckStock()) this.addTab("Vooraad", vp);
        if(rechten.canCheckAccounts()) this.addTab("Personen", pp);
        if(g.getRol() instanceof KlantenRol){
            this.addTab("Mijn Gegevens", kbp);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        a.updateContents();
        ap.updatePanel();
        vp.updatePanel();
        pp.updatePanel();
        System.out.println("Updating");
        
    }
}
