package nl.utwente.plantcontroller.ui;


import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame{
    private LoginPanel loginPanel = new LoginPanel();

    public MainFrame(){
        init();
    }

    private void init() {
        this.setSize(400,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(loginPanel);
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        new MainFrame();
    }
}
