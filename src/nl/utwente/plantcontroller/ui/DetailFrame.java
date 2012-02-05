package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.BestelItem;
import nl.utwente.plantcontroller.model.Bestelling;

public class DetailFrame extends JFrame{
    private Bestelling b;
    private JPanel pan = new JPanel();
    private JLabel klantLabel = new JLabel("Klant: ");
    private JTextField klantField = new JTextField();
    private JLabel idLabel = new JLabel("ID: ");
    private JTextField idField = new JTextField();
    DefaultTableModel model = new DefaultTableModel();
    private JTable tableForOrders;
    
    
    public DetailFrame(Bestelling b) {
        this.b = b;
        init();
    }
    private void init() {
        this.setLayout(new BorderLayout());
        this.setSize(600,480);
        idField.setEditable(false);
        klantField.setEditable(false);
        idField.setText("" + b.getId());
        model.addColumn("product");
        model.addColumn("Hoeveelheid");
        model.addColumn("Hoeveelheid niet vooradig");
        model.addColumn("stukprijs");
        model.addColumn("totaalprijs");
        tableForOrders  = new JTable(model);
        klantField.setText("" + b.getKlant());
        
        pan.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        pan.add(klantLabel, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        pan.add(idLabel, c);
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        pan.add(klantField, c);
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        pan.add(idField, c);
        
        this.add(pan, BorderLayout.NORTH);
        
        for(BestelItem bi : b.getBestelItems()){
            model.addRow(new Object[]{bi.getProduct(), bi.getAantal(), bi.getHoeveelheidTeWeinig(), bi.getProduct().getPrijs(), bi.getPrijs()});
        }
        
        this.add(new JScrollPane(tableForOrders, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER ), BorderLayout.CENTER);
        this.setVisible(true);
        
    }
}
