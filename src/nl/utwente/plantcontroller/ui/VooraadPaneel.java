package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.BestelItem;
import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Onderdeel;
import nl.utwente.plantcontroller.model.Product;

public class VooraadPaneel extends JPanel implements ActionListener{
    private JTable table;
    private DefaultTableModel model = new DefaultTableModel();
    private Fabriek fabriek;
    private String[] columnIdentifiers = {"Product","Vooraad","Waarde per stuk", "Totaalwaarde"};
    private JLabel productenLabel = new JLabel("Producten:");
    private JComboBox productenBox = new JComboBox();
    private JLabel vooraadLabel = new JLabel("Nieuwe Vooraad:");
    private JTextField vooraadField = new JTextField();
    private JButton update = new JButton("Verander vooraad");
    public VooraadPaneel(Fabriek fabriek){
        this.fabriek = fabriek;
        init();
    }
    private void init() {
        table = new JTable(model);
        updatePanel();
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER ), BorderLayout.CENTER);
        update.addActionListener(this);
        for(Product p : fabriek.getProductTypen()){
            productenBox.addItem(p);
        }
        for(Onderdeel d : fabriek.getOnderdelen()){
            productenBox.addItem(d);
        }
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(productenLabel, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(productenBox, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(vooraadLabel, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(vooraadField, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(update, c);
        this.add(panel, BorderLayout.SOUTH);
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
    @Override
    public void actionPerformed(ActionEvent arg0) {
        int hoeveelheid;
        try{
            hoeveelheid = Integer.parseInt(vooraadField.getText());
        }catch (NumberFormatException e) {
            return;
        }
        Onderdeel prod = (Onderdeel) productenBox.getSelectedItem();
        
        prod.setVooraad(hoeveelheid);
    }
}
