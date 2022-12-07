package edu.pacific.comp55.starter;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class _TestImageMove extends JFrame {
	MainApplication app;
    public _TestImageMove() {
        
        initUI();
    }
    
    private void initUI() {

        add(new _TestBoard());

        setSize(1000, 1000);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

            _TestImageMove ex = new _TestImageMove();
            ex.setVisible(true);
    }
}