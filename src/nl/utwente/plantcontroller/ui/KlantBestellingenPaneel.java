package nl.utwente.plantcontroller.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.KlantenRol;

public class KlantBestellingenPaneel extends JPanel{
    DefaultTableModel model;
    JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    private KlantenRol k;

    public KlantBestellingenPaneel(KlantenRol k){
        this.k = k;
        init();
    }

    private void init() {
        
    }
}
