package nl.utwente.plantcontroller.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nl.utwente.plantcontroller.model.Fabriek;
import nl.utwente.plantcontroller.model.GebruikersRol;
import nl.utwente.plantcontroller.model.KlantenRol;
import nl.utwente.plantcontroller.model.Magazijnrol;
import nl.utwente.plantcontroller.model.Operatorrol;
import nl.utwente.plantcontroller.model.Verkopersrol;
import nl.utwente.plantcontroller.util.PasswordGenerator;

public class VoegGebruikerToePaneel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    
    //De fabriek van het systeem, gebruikt om gebruikers toe te kunnen voegen
    private Fabriek f;
    
    //De inlognaam waarmee de gebruiker straks kan inloggen
    private JLabel inlogNaamLabel = new JLabel("Inlognaam:");
    private JTextField inlogNaamField = new JTextField();
    //De naam van de gebruiker
    private JLabel naamLabel = new JLabel("Naam:");
    private JTextField naamField = new JTextField();
    //Het adres van de nieuwe klant
    private JLabel adresLabel = new JLabel("Adres:");
    private JTextField adresField = new JTextField();
    //De rol van de nieuwe gebruiker binnen het systeem
    private JLabel rollenLabel = new JLabel("Rollen:");
    private JTextField errorLabel = new JTextField("Ik ben een error");
    
    
    //Een box met alle mogelijke rollen binnen het systeem
    private JComboBox rollenBox = new JComboBox();
    
    //De knop om een gebruiker toe te voegen
    private JButton voegToeKnop = new JButton("Voeg toe");
    
    public VoegGebruikerToePaneel(Fabriek f){
        this.f = f;
        init();
    }
    
    public void init(){
        this.setLayout(new GridBagLayout());
        inlogNaamField.setColumns(15);
        naamField.setColumns(15);
        adresField.setColumns(15);
        rollenBox.addItem("Geen");
        rollenBox.addItem("Klant");
        rollenBox.addItem("Magazijn Medewerker");
        rollenBox.addItem("Verkoop Medewerker");
        rollenBox.addItem("Fabrieks Operator");
        voegToeKnop.addActionListener(this);
        errorLabel.setEditable(false);
        errorLabel.setColumns(30);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        this.add(inlogNaamLabel, c);
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(inlogNaamField, c);
        
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        this.add(naamLabel, c);
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(naamField, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        this.add(adresLabel, c);
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        this.add(adresField, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        this.add(rollenLabel, c);
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(rollenBox, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.LINE_START;
        this.add(voegToeKnop, c);
        
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(errorLabel, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == voegToeKnop){
            if(!inlogNaamField.getText().equals("") && !naamField.getText().equals("") && !adresField.getText().equals("") && !rollenBox.getSelectedItem().equals("Geen")){
                String loginNaam = inlogNaamField.getText();
                String password = PasswordGenerator.generatePass();
                GebruikersRol r = getRol((String)rollenBox.getSelectedItem(), naamField.getText(), adresField.getText());
                if(f.voegGebruikerToe(loginNaam, password, r)){
                    errorLabel.setText("Wachtwoord: " + password);
                }else{
                    errorLabel.setText("Gebruikersnaam bestaat al");
                }
                
                
            }else{
                errorLabel.setText("Een van de velden is leeg");
            }
        }
    }
    
    private GebruikersRol getRol(String rol, String naam, String adres){
        GebruikersRol r;
        if(rol.equals("Klant")){
            r = new KlantenRol(naam, adres);
        }else if(rol.equals("Magazijn Medewerker")){
            r= new Magazijnrol();
        }else if(rol.equals("Verkoop Medewerker")){
            r = new Verkopersrol();
        }else{
            r = new Operatorrol();
        }
        
        return r;
    }
}
