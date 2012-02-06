package nl.utwente.plantcontroller.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.BestelItem;
import nl.utwente.plantcontroller.model.Bestelling;
import nl.utwente.plantcontroller.model.KlantenRol;

public class KlantBestellingenPaneel extends JPanel{
    private DefaultTableModel model;
    private JTable table;
    //
    
    private KlantenRol k;

    public KlantBestellingenPaneel(KlantenRol k){
        this.k = k;
        init();
    }

    private void init() {
        updatePanel();
        table = new JTable(model);
        this.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
    }
    
    private void updatePanel(){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Status"});
        for(Bestelling bi : k.getBestellingen()){
            model.addRow(new Object[]{bi.getId(), bi.getStatus()});
        }
    }
}

