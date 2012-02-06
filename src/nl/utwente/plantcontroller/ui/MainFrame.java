package nl.utwente.plantcontroller.ui;


import javax.swing.JComponent;
import javax.swing.JFrame;

import nl.utwente.plantcontroller.model.Fabriek;

public class MainFrame extends JFrame{
    private static final long serialVersionUID = -7795793302779137037L;
    //het loginpaneel wat in dit mainframe gestopt wordt
    private LoginPanel loginPanel;
    public MainFrame(Fabriek fabriek){
        loginPanel = new LoginPanel(this, fabriek);
        init();
    }

    private void init() {
        this.setSize(600,480);
        this.getContentPane().add(loginPanel);
        this.setVisible(true);
    }
    
    /**
     * Een methode om het login panel te kunnen vervangen
     * met het MainPanel
     * @param c
     */
    public void setPanel(JComponent c){
        this.getContentPane().removeAll();
        this.getContentPane().add(c);
    }
}
