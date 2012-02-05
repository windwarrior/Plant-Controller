package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.BestelItem;
import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Onderdeel;
import nl.utwente.plantcontroller.model.Product;

public class VooraadPaneel extends JPanel{
    private JTable table;
    private DefaultTableModel model = new DefaultTableModel();
    private Fabriek fabriek;
    private String[] columnIdentifiers = {"Product","Vooraad","Waarde per stuk", "Totaalwaarde"};
    public VooraadPaneel(Fabriek fabriek){
        this.fabriek = fabriek;
        init();
    }
    private void init() {
        table = new JTable(model);
        updatePanel();
        
        this.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER ), BorderLayout.CENTER);
    }
    
    public void updatePanel(){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnIdentifiers);
        for(Product p : fabriek.getProductTypen()){
            model.addRow(new Object[]{p, p.getVooraad(), p.getPrijs(), p.getPrijs()*p.getVooraad()});
        }
        
        for(Onderdeel p : fabriek.getOnderdelen()){
            model.addRow(new Object[]{p, p.getVooraad(), p.getPrijs(), p.getPrijs()*p.getVooraad()});
        }
        
        table.setModel(model);
       
    }
}
