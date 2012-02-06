package nl.utwente.plantcontroller.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private static final long serialVersionUID = -4226636267793117440L;
    
    //Tabel waarin de Assemblagelijnen opgeslagen gaan worden
    private JTable tab;
    
    //Model waarmee straks de tabel gevult wordt
    private DefaultTableModel model;
    
    //De fabriek, het "ingangpunt" in het echte systeem
    private Fabriek fabriek;
    
    //De titels van de kolommen van de tabel
    private String[] columnIdentifiers = {"ID","bezet","product","hoeveelheid"};
    
    //De label voor het selectievakje waarmee een assemblageLijn wordt toegewezen
    private JLabel assemblagelijnlabel = new JLabel("Assemblagelijn: ");
    
    //De combobox waarmee een assemblagelijn geselecteerd kan worden
    private JComboBox assemblagelijnbox = new JComboBox();
    
    //De label voor naast het product vakje
    private JLabel productlabel = new JLabel("Product: ");
    
    //Het productvakje waarmee een product geselecteerd kan worden voor productie
    private JComboBox productBox = new JComboBox();
    
    //Een label om aan te geven dat er een hoeveelheid in het naastgelegen vakje hoort
    private JLabel hoeveelheidLabel = new JLabel("Hoeveelheid: ");
    
    //Het vakje waar een hoeveelheid aangegeven kan worden
    private JTextField hoeveelheidTextBox = new JTextField();
    
    //De knop waarmee een productrun gestart kan worden
    private JButton start = new JButton("Start run");
    
    //Een label voor eventuele statusmeldingen
    private JLabel errorLabel = new JLabel("ik ben ook al een error");
    public AssemblageLijnPaneel(Fabriek fabriek){
        this.fabriek = fabriek;
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
        
        for(int i = 0; i< fabriek.getAssemblagelijnen().length; i++){
            assemblagelijnbox.addItem(i);
        }
        for (Product p : fabriek.getProductTypen()) {
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
        int lenght = fabriek.getAssemblagelijnen().length;
        Object[][] o = new Object[lenght][4];
        for(int i = 0; i<lenght; i++){
            o[i][0] = i;
            o[i][1] = fabriek.getAssemblagelijnen()[i].isBusy();
            o[i][2] = fabriek.getAssemblagelijnen()[i].getProduct();
            o[i][3] = fabriek.getAssemblagelijnen()[i].getHoeveelheid();
        }
        model.setDataVector(o, columnIdentifiers);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int assemblagelijn = assemblagelijnbox.getSelectedIndex();
        Product p = (Product) productBox.getSelectedItem();
        int hoeveelheid = Integer.parseInt(hoeveelheidTextBox.getText());
        Productrun pr = new Productrun(p, hoeveelheid);
        if(pr.voldoendeVoorraad(hoeveelheid)){
            System.out.println("voldoende vooraad");
            Assemblagelijn a = fabriek.getAssemblagelijnen()[assemblagelijn];
            if(!a.isBusy()){
                a.startRun(pr);
            }else{
                errorLabel.setText("De assemblagelijn is bezet");
            }
        }else{
            System.out.println("onvoldoende vooraad");
            Object[] options = {"Ja", "Nee", "Misschien"};
            int n = JOptionPane.showOptionDialog(new JFrame(),
                    "Onvoldoende vooraad, producten bestellen?",
                    "items bestellen",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);
            System.out.println(n);
            
            if(n == 2){
                options = new Object[]{"Ja", "Nee"};
                n = JOptionPane.showOptionDialog(new JFrame(),
                        "Geen tijd voor twijfel, producten bestellen?",
                        "items bestellen",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
            }
            
            if(n == 0){
                //er zou nu een mail gestuurt moeten worden naar de inkoop afdeling :)
            }
            
        }
        
    }
}
