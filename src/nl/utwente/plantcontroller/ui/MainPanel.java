package nl.utwente.plantcontroller.ui;

import javax.swing.JTabbedPane;

import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Gebruiker;

public class MainPanel extends JTabbedPane{
    private Fabriek fabriek;
    private Gebruiker g;

    public MainPanel(Fabriek fabriek, Gebruiker g){
        this.fabriek = fabriek;
        this.g = g;
        init();
    }
    
    public void init(){
        this.addTab("Bestel", new BestelPaneel(g, fabriek));
    }
}
