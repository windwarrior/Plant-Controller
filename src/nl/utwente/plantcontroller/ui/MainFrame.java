package nl.utwente.plantcontroller.ui;


import javax.swing.JComponent;
import javax.swing.JFrame;

import nl.utwente.plantcontroller.model.Fabriek;

public class MainFrame extends JFrame{
    private static final long serialVersionUID = -7795793302779137037L;
    private LoginPanel loginPanel;
    private Fabriek fabriek;

    public MainFrame(Fabriek fabriek){
        this.fabriek = fabriek;
        loginPanel = new LoginPanel(this, fabriek);
        init();
    }

    private void init() {
        this.setSize(400,200);
        this.getContentPane().add(loginPanel);
        this.setVisible(true);
    }
    
    public void setPanel(JComponent c){
        this.getContentPane().removeAll();
        this.getContentPane().add(c);
    }
}
