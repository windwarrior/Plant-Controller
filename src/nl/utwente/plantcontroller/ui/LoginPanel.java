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
    
    private JTextField name = new JTextField();
    private JPasswordField passwrd = new JPasswordField();
    private JLabel nameLabel = new JLabel("Naam:");
    private JLabel passwrdLabel = new JLabel("Wachtwoord:");
    private JButton login = new JButton("login");
    private JLabel errorLabel = new JLabel("Ik ben een error");

    private MainFrame parent;

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
