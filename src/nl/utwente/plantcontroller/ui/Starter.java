package nl.utwente.plantcontroller.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import nl.utwente.plantcontroller.model.Fabriek;

public class Starter extends JFrame implements ActionListener{
    private JButton newClient = new JButton("Nieuwe login sessie");
    private Fabriek fabriek;
    public Starter(){
        init();
    }
    private void init() {
        this.setSize(200,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        newClient.addActionListener(this);
        this.add(newClient);
        this.setVisible(true);
        
        fabriek = new Fabriek();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new MainFrame(fabriek);
    }
    
    public static void main(String[] args){
        new Starter();
    }
    
}
