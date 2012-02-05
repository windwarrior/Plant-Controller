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
    private AssemblageLijnPaneel ap;
    private VooraadPaneel vp;
    public MainPanel(Fabriek fabriek, Gebruiker g){
        this.fabriek = fabriek;
        this.g = g;
        p = new BestelPaneel(g, fabriek);
        a = new AlleBestellingenPaneel(fabriek);
        v = new VoegGebruikerToePaneel(fabriek);
        ap = new AssemblageLijnPaneel(fabriek);
        vp = new VooraadPaneel(fabriek);
        init();
    }
    
    public void init(){
        this.addChangeListener(this);
        this.addTab("Bestel", p);
        this.addTab("Alle Bestelingen", a);
        this.addTab("Gebruiker toevoegen", v);
        this.addTab("AssemblageLijnen", ap);
        this.addTab("Vooraad", vp);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        a.updateContents();
        ap.updatePanel();
        vp.updatePanel();
        System.out.println("Updating");
        
    }
}
