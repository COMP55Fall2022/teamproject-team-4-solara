package edu.pacific.comp55.starter;

import java.awt.*;    

import java.awt.event.*;    
public class _Movement extends Frame implements KeyListener {    
Label l;    
TextArea area;
boolean Up = false;
boolean Down = false;
boolean Right = false;
boolean Left = false;

    _Movement() {    
        l = new Label();    
        l.setBounds (20, 50, 100, 20);    
        area = new TextArea();    
        area.setBounds (20, 80, 300, 300);    
        area.addKeyListener(this);  
        add(l);  
        add(area);    
        setSize (400, 400);    
        setLayout (null);    
        setVisible (true);    
    }    
    public void keyPressed (KeyEvent e) {    
    	int key = e.getKeyCode();
    	if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
    		Up = true;
    	}
    	if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_W) {
    		Down = true;
    	}
    	if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_W) {
    		Left = true;
    	}
    	if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_W) {
    		Right = true;
    	}
    	if (Up == true) {
   			System.out.println("Left");
   			System.out.println(Left);
   			System.out.println("Right");
   			System.out.println(Right);
   			System.out.println("Up");
   			System.out.println(Up);
   			System.out.println("Down"); 
   			System.out.println(Down);

    		if (Right == true) {
    			l.setText("Top Right");
    		}
    		else if (Left == true) {
    			l.setText("Top Left");
    		}
    		else if (Down == true) {
    			l.setText("HALT");
    		}
    		else if (Right == false && Left == false && Down == false){
    			l.setText("UP");
    		}
    	}
    	else if (Down == true) {
    		if (Up == true) {
    			l.setText("HALT");
    		}
    		else if (Right == true) {
    			l.setText("Bottom Right");
    		}
    		else if (Left == true) {
    			l.setText("Bottom Left");
    		}
    		else {
    			l.setText("Down");
    		}
    	}
    	else if (Left == true) {
    		if (Up == true) {
    			l.setText("Top Left");
    		}
    		else if (Right == true) {
    			l.setText("HALT");
    		}
    		else if (Down == true) {
    			l.setText("Bottom Left");
    		}
    		else {
    			l.setText("Left");
    		}
    	}
    	else if (Right == true) {
    		if (Down == true) {
    			l.setText("Bottom Right");
    		}
    		else if (Left == true) {
    			l.setText("HALT");
    		}
    		else if (Up == true) {
    			l.setText("Top Right");
    		}
    		else {
    			l.setText("Right");
    		}
    		
    	}
    	else {
    		l.setText("HALT");
    	}
    }

    public void keyReleased (KeyEvent e) {
    	int key = e.getKeyCode();
    	if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
    		Up = false;
    	}
    	if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_W) {
    		Down = false;
    	}
    	if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_W) {
    		Left = false;
    	}
    	if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_W) {
    		Right = false;
    	}    
    	if (Up == false && Left == false && Down == false && Right == false) {
    		l.setText("HALT");
    	}
    }    
    public void keyTyped (KeyEvent e) {    
        l.setText("keyTyped");
    }    
    public static void main(String[] args) {    
        new _Movement();    
    }    
} 