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
    private static final long serialVersionUID = -8080019934735683489L;
    
    //De bestelling waarmee de Table gevult gaat worden
    private Bestelling b;
    
    //Een paneel dat gebruikt gaat worden om componenten op te plaatsen
    private JPanel pan = new JPanel();
    
    //Het label waarnaast de naam van de klant geplaatst wordt
    private JLabel klantLabel = new JLabel("Klant: ");
    
    //Het TextField waarin de klantnaam komt te staan
    private JTextField klantField = new JTextField();
    
    //Het label om aan te geven dat het naastgelegen veld voor het ID van de bestelling is
    private JLabel idLabel = new JLabel("ID: ");
    
    //Het id van de bestelling
    private JTextField idField = new JTextField();
    
    //Het datamodel van de table
    DefaultTableModel model = new DefaultTableModel();
    
    //De tabel waarin de bestelde items geplaatst kunnen worden
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
