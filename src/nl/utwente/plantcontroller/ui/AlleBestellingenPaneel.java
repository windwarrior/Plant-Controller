package nl.utwente.plantcontroller.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.Bestelling;
import nl.utwente.plantcontroller.model.Fabriek;

public class AlleBestellingenPaneel extends JPanel{
    private Fabriek f;
    private JTable table = new JTable();
    DefaultTableModel model;
    JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    public AlleBestellingenPaneel(Fabriek f){
        this.f = f;
        init();
    }

    private void init() {
        updateContents();
        this.add(pane);
    }

    public void updateContents() {
        model = new DefaultTableModel();
        model.addColumn("Geplaast door");
        model.addColumn("ID");
        model.addColumn("status");
        for(Bestelling b : f.getBestellingen()){
            model.addRow(new Object[]{b.getKlant(), b.getId(), b.getStatus()});
        }
        table.setModel(model);
    }
}
