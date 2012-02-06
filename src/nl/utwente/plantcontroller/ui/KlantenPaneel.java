package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Gebruiker;
import nl.utwente.plantcontroller.model.KlantenRol;

public class KlantenPaneel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 7441857059944398080L;
    private Fabriek fabriek;
    private DefaultTableModel model;
    private Object[] columnIdentifiers = {"Klantnaam", "Adres"};
    private JTable tab = new JTable(model);     
    private JButton but = new JButton("Bekijk details");
    public KlantenPaneel(Fabriek fabriek){
        this.fabriek = fabriek;
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        but.addActionListener(this);
        updatePanel();
        this.add(new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        this.add(but, BorderLayout.SOUTH);
    }
    
    public void updatePanel(){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnIdentifiers );
        for(Gebruiker g: fabriek.getGebruikers()){
            if(g.getRol() instanceof KlantenRol){
                KlantenRol k = (KlantenRol) g.getRol();
                model.addRow(new Object[]{k, k.getAdres()});
            }
        }
        
        tab.setModel(model);
       
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        int row = tab.getSelectedRow();
        if(row != -1){
            System.out.println("nothing!");
            KlantenRol k = (KlantenRol) model.getValueAt(row, 0);
            JFrame frame = new JFrame();
            frame.add(new KlantBestellingenPaneel(k));
            frame.setSize(new Dimension(600,400));
            frame.setVisible(true);
        }
    }
}
