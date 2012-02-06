package nl.utwente.plantcontroller.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.Gebruiker;

public class LoginPanel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 407324739824395920L;
    
    //Het veld voor de loginnaam
    private JTextField name = new JTextField();
    //Het veld voor het wachtwoord van de gebruiker
    private JPasswordField passwrd = new JPasswordField();
    
    //het label om aan te geven dat het naastliggende veld voor loginnaam is
    private JLabel nameLabel = new JLabel("Naam:");
    
    //het label om aan te geven dat het naastliggende veld voor het password is
    private JLabel passwrdLabel = new JLabel("Wachtwoord:");
    
    //de knop om mee in te loggen
    private JButton login = new JButton("login");
    
    //een label om eventuele errors in te plaatsen
    private JLabel errorLabel = new JLabel("Ik ben een error");
    
    //De frame waarin dit paneel geplaatst is
    private MainFrame parent;

    //De fabriek van dit systeem
    private Fabriek fabriek;
    
    public LoginPanel(MainFrame parent, Fabriek fabriek){
        this.parent = parent;
        this.fabriek = fabriek;
        init();
    }
    
    public void init(){
        login.addActionListener(this);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        this.add(nameLabel, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(passwrdLabel, c);
        
        name.setColumns(15);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(name, c);
        
        passwrd.setColumns(15);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(passwrd, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(login, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(errorLabel, c);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource().equals(login)){
            if(name.getText() != "" &&  passwrd.getPassword() != null){
                
               String s = new StringBuilder().append(passwrd.getPassword()).toString(); //haha, dit is ontzettend lelijk, maarja 
               Gebruiker g;
               System.out.println(s);
               if((g = fabriek.checkGebruiker(name.getText(), s)) != null){
                   errorLabel.setText("Yay!");
                   if(parent == null) System.out.println("parent null?");
                   if(fabriek == null) System.out.println("fabriek null?");
                   if(parent == null) System.out.println("gebruiker null?");
                   parent.setPanel(new MainPanel(fabriek, g));
               }else{
                   errorLabel.setText("login/password is incorrect");
                   passwrd.setText("");
               }
            }
        }
    }
}
