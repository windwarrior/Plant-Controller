package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
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

import nl.utwente.plantcontroller.model.Assemblagelijn;
import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Product;
import nl.utwente.plantcontroller.model.Productrun;

public class AssemblageLijnPaneel extends JPanel implements ActionListener{
    private JTable tab;
    private DefaultTableModel model;
    private Fabriek fa;
    private String[] columnIdentifiers = {"ID","bezet","product","hoeveelheid"};
    private JLabel assemblagelijnlabel = new JLabel("Assemblagelijn: ");
    private JComboBox assemblagelijnbox = new JComboBox();
    private JLabel productlabel = new JLabel("Product: ");
    private JComboBox productBox = new JComboBox();
    private JLabel hoeveelheidLabel = new JLabel("Hoeveelheid: ");
    private JTextField hoeveelheidTextBox = new JTextField();
    private JButton start = new JButton("Start run");
    private JLabel errorLabel = new JLabel("ik ben ook al een error");
    public AssemblageLijnPaneel(Fabriek fa){
        this.fa = fa;
        init();
                
    }

    private void init() {
        hoeveelheidTextBox.setColumns(15);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("bezet");
        model.addColumn("product");
        model.addColumn("hoeveelheid");
        tab = new JTable(model);
        start.addActionListener(this);
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        
        for(int i = 0; i< fa.getAssemblagelijnen().length; i++){
            assemblagelijnbox.addItem(i);
        }
        for (Product p : fa.getProductTypen()) {
            productBox.addItem(p);
        }
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(assemblagelijnlabel, c);
        
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(assemblagelijnbox, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(productlabel, c);
        
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(productBox, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(hoeveelheidLabel, c);
        
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(hoeveelheidTextBox, c);
        
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(start, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(errorLabel, c);
        
        
        
        
        this.add(panel, BorderLayout.SOUTH);
        updatePanel();
    }
    
    public void updatePanel(){
        int lenght = fa.getAssemblagelijnen().length;
        Object[][] o = new Object[lenght][4];
        for(int i = 0; i<lenght; i++){
            o[i][0] = i;
            o[i][1] = fa.getAssemblagelijnen()[i].isBusy();
            o[i][2] = fa.getAssemblagelijnen()[i].getProduct();
            o[i][3] = fa.getAssemblagelijnen()[i].getHoeveelheid();
        }
        model.setDataVector(o, columnIdentifiers);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int assemblagelijn = assemblagelijnbox.getSelectedIndex();
        Product p = (Product) productBox.getSelectedItem();
        int hoeveelheid = Integer.parseInt(hoeveelheidTextBox.getText());
        Assemblagelijn a = fa.getAssemblagelijnen()[assemblagelijn];
        if(!a.isBusy()){
            a.startRun(new Productrun(p, hoeveelheid));
        }
    }
}
