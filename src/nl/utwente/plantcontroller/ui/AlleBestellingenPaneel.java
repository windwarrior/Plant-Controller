package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.Bestelling;
import nl.utwente.plantcontroller.model.Fabriek;

public class AlleBestellingenPaneel extends JPanel implements ActionListener{
    private Fabriek f;
    private JTable table = new JTable();
    private JButton detailButton = new JButton("details");
    private List<Bestelling> bestellingenMap = new ArrayList<Bestelling>();
    DefaultTableModel model;
    JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public AlleBestellingenPaneel(Fabriek f){
        this.f = f;
        init();
    }

    private void init() {
        updateContents();
        this.setLayout(new BorderLayout());
        this.add(pane, BorderLayout.CENTER);
        this.add(detailButton, BorderLayout.SOUTH);
        detailButton.addActionListener(this);
    }

    public void updateContents() {
        model = new DefaultTableModel();
        model.addColumn("Geplaast door");
        model.addColumn("ID");
        model.addColumn("status");
        bestellingenMap = new ArrayList<Bestelling>();
        for(Bestelling b : f.getBestellingen()){
            Object[] row = new Object[]{b.getKlant(), b.getId(), b.getStatus()};
            model.addRow(row);
            bestellingenMap.add(b);
        }
        table.setModel(model);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(detailButton)){
            
            System.out.println(model.getValueAt(table.getSelectedRow(), 0) + " " + model.getValueAt(table.getSelectedRow(), 1) + " " + model.getValueAt(table.getSelectedRow(), 2));
            System.out.println("" + bestellingenMap.get(table.getSelectedRow()));
            new DetailFrame(bestellingenMap.get(table.getSelectedRow()));
        }
    }
}

