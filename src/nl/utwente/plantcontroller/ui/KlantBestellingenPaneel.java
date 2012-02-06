package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.Bestelling;
import nl.utwente.plantcontroller.model.KlantenRol;

public class KlantBestellingenPaneel extends JPanel implements ActionListener{
    private static final long serialVersionUID = -4168820199603683475L;
    
    //Het model waarin de bestellingen van een klant geplaatst worden
    private DefaultTableModel model;
    
    //De table waarin de bestellingen getoont worden
    private JTable table;
    
    //De knop waarmee de details van een bestelling getoont kunnen worden
    private JButton button = new JButton("Bekijk details");
    
    //De locale lijst van bestellingen
    private List<Bestelling> bestelList = new ArrayList<Bestelling>();
    
    //De klantrol, waarvan de bestellingen af komen
    private KlantenRol k;

    public KlantBestellingenPaneel(KlantenRol k){
        this.k = k;
        init();
    }

    private void init() {
        table = new JTable(model);
        updatePanel();
        button.addActionListener(this);
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
    }
    
    public void updatePanel(){
        model = new DefaultTableModel();
        bestelList = new ArrayList<Bestelling>();
        model.setColumnIdentifiers(new Object[]{"ID", "Status"});
        for(Bestelling bi : k.getBestellingen()){
            model.addRow(new Object[]{bi.getId(), bi.getStatus()});
            bestelList.add(bi);
        }
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        if(row != -1){
            Bestelling b = bestelList.get(row);
            new DetailFrame(b);
        }
    }
}

