package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Gebruiker;
import nl.utwente.plantcontroller.model.KlantenRol;
import nl.utwente.plantcontroller.model.Onderdeel;
import nl.utwente.plantcontroller.model.Product;

public class PersonenPaneel extends JPanel{
    private Fabriek fabriek;
    private DefaultTableModel model;
    private Object[] columnIdentifiers = {"Klantnaam", "Adres"};
    private JTable tab = new JTable(model);           
    public PersonenPaneel(Fabriek fabriek){
        this.fabriek = fabriek;
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        updatePanel();
        this.add(new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
    }
    
    public void updatePanel(){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnIdentifiers );
        for(Gebruiker g: fabriek.getGebruikers()){
            if(g.getRol() instanceof KlantenRol){
                KlantenRol k = (KlantenRol) g.getRol();
                model.addRow(new Object[]{k, k.getAdres()});
            }
        }
        
        tab.setModel(model);
       
    }
}
