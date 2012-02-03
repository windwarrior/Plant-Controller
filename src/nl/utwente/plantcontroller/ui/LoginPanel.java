package nl.utwente.plantcontroller.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
    private static final long serialVersionUID = 407324739824395920L;
    
    private JTextField name = new JTextField();
    private JPasswordField passwrd = new JPasswordField();
    private JLabel nameLabel = new JLabel("Naam:");
    private JLabel passwrdLabel = new JLabel("Wachtwoord:");
    private JButton login = new JButton("login");
    private JLabel errorLabel = new JLabel("Ik ben een error");
    
    public LoginPanel(){
        init();
    }
    
    public void init(){
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
}
