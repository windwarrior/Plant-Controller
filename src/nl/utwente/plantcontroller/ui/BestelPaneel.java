package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.BestelItem;
import nl.utwente.plantcontroller.model.Bestelling;
import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Gebruiker;
import nl.utwente.plantcontroller.model.GebruikersRol;
import nl.utwente.plantcontroller.model.KlantenRol;
import nl.utwente.plantcontroller.model.Product;

public class BestelPaneel extends JPanel implements ActionListener {
    private static final long serialVersionUID = -3923119979431172823L;
    
    //De gebruiker die de bestelling gaat plaatsen
    private Gebruiker g;
    
    //De fabriek, het startpunt in het systeem
    private Fabriek f;
    
    //Het label, om aan te geven dat de combobox ernaast producten bevat
    private JLabel productLabel = new JLabel("Product Typen:");
    
    //De combobox met producten
    private JComboBox productComboBox = new JComboBox();
    
    //Een knop om een product toe te voegen aan een bestellling
    private JButton voegToeKnop = new JButton("Voeg Toe");
    
    //Een label om aan te geven dat in het textfield een hoeveelheid hoort
    private JLabel amountLabel = new JLabel("Aantal");
    
    //Een textfield voor de hoeveelheid te bestellen producten
    private JTextField amountField = new JTextField();
    
    //De table waarin de bestellingen getoont gaan worden
    private JTable table;
    
    //De knop waarmee de bestelling bestelt kan worden
    private JButton bestelKnop = new JButton("Bestel");
    
    //Het tablemodel dat gebruikt wordt als data voor de tabel
    private DefaultTableModel model = new DefaultTableModel();

    public BestelPaneel(Gebruiker g, Fabriek f) {
        this.g = g;
        this.f = f;
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        table = new JTable(model);
        model.addColumn("product");
        model.addColumn("Hoeveelheid");
        voegToeKnop.addActionListener(this);
        bestelKnop.addActionListener(this);
        JScrollPane pane = new JScrollPane(table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        productComboBox.addItem("geen");
        for (Product p : f.getProductTypen()) {
            productComboBox.addItem(p.toString());
        }
        amountField.setColumns(15);

        Container cont = new Container();
        cont.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        cont.add(productLabel, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        cont.add(productComboBox, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        cont.add(amountLabel, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        cont.add(amountField, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 5);
        cont.add(voegToeKnop, c);
        this.add(cont, BorderLayout.NORTH);

        c = new GridBagConstraints();
        this.add(pane, BorderLayout.CENTER);

        this.add(bestelKnop, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bestelKnop) {
            Map<String, Integer> bestelling = getBestelling();
            GebruikersRol gr = g.getRol();
            if (gr instanceof KlantenRol) {
                KlantenRol kr = (KlantenRol) gr;
                Bestelling best = new Bestelling(kr);
                for (Entry<String, Integer> bestset : bestelling.entrySet()) {
                    best.addProduct(new BestelItem(f.getProductBijNaam(bestset
                            .getKey()), bestset.getValue()));
                }
                // TODO: NIET NET
                f.bestel(best);
                kr.plaatsBestelling(best);
                clearBestelling();
            }

        } else if (e.getSource() == voegToeKnop) {
            if (!productComboBox.getSelectedItem().equals("geen")) {
                int hoeveelheid;
                try{
                    hoeveelheid = Integer.parseInt(amountField.getText());
                }catch(NumberFormatException er){
                    return;
                }
                int row;
                if ((row = getStackableRowIndex(productComboBox
                        .getSelectedItem())) != -1) {
                    int value = (Integer) ((Vector<?>) model.getDataVector()
                            .elementAt(row)).elementAt(1) + hoeveelheid;
                    model.removeRow(row);
                    model.insertRow(row,
                            new Object[] { productComboBox.getSelectedItem(),
                                    value });
                } else {
                    model.addRow(new Object[] {
                            productComboBox.getSelectedItem(), hoeveelheid });
                }
            }
        }
    }

    private void clearBestelling() {
        for(int i = model.getRowCount() -1; i >= 0; i-- ){
            model.removeRow(i);
        }
    }

    public int getStackableRowIndex(Object choice) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (((Vector<?>) model.getDataVector().elementAt(i)).elementAt(0)
                    .equals(choice)) {
                return i;
            }
        }
        return -1;
    }

    public Map<String, Integer> getBestelling() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < model.getRowCount(); i++) {
            String key = (String) ((Vector<?>) model.getDataVector().elementAt(i))
                    .elementAt(0);
            int value = (Integer) ((Vector<?>) model.getDataVector().elementAt(i))
                    .elementAt(1);
            map.put(key, value);
        }
        

        return map;
    }
}
