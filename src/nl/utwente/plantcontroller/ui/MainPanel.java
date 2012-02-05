package nl.utwente.plantcontroller.ui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Gebruiker;

public class MainPanel extends JTabbedPane implements ChangeListener{
    private Fabriek fabriek;
    private Gebruiker g;
    private BestelPaneel p;
    private AlleBestellingenPaneel a; 
    private VoegGebruikerToePaneel v;
    public MainPanel(Fabriek fabriek, Gebruiker g){
        this.fabriek = fabriek;
        this.g = g;
        p = new BestelPaneel(g, fabriek);
        a = new AlleBestellingenPaneel(fabriek);
        v = new VoegGebruikerToePaneel(fabriek);
        init();
    }
    
    public void init(){
        this.addChangeListener(this);
        this.addTab("Bestel", p);
        this.addTab("Alle Bestelingen", a);
        this.addTab("Gebruiker toevoegen", v);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        a.updateContents();
        System.out.println("Updating");
        
    }
}
