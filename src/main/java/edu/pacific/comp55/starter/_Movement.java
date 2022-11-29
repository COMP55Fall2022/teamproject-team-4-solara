package edu.pacific.comp55.starter;
import java.awt.*;    
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import acm.graphics.GRect;    
public class _Movement extends Frame implements KeyListener {    
	
	Label l;    
	TextArea area;
	boolean Up = false;
	boolean Down = false;
	boolean Right = false;
	boolean Left = false;
	String player = "";
	_Movement() {
		GOval box;
		box = new GOval(100,100,100,100);
		box.setColor(Color.RED);
		box.setFilled(true);
		//add(box);
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
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
			System.out.println("Player 1");
			player = "Player 1";
		}
		else {
			System.out.println("Player 2");
			player = "Player 2";
		}
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			Up = true;
		}
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			Down = true;
		}
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			Left = true;
		}
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			Right = true;
		}
		if (Up == true) {

			if (Right == true) {
				if (Down == true || Left == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Top Right");
				}
			}
			else if (Left == true) {
				if (Down == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Top Left");
				}
			}
			else if (Down == true) {
				System.out.println("HALT");
			}

			else if (Right == false && Left == false && Down == false){
				System.out.println("Up");
			}
		}
		else if (Down == true) {
			if (Up == true) {
				System.out.println("HALT");
			}
			else if (Right == true) {
				if (Up == true || Left == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Bottom Right");
				}
			}
			else if (Left == true) {
				if (Right == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Bottom Left");
				}
			}
			else {
				System.out.println("Down");
			}
		}
		else if (Left == true) {
			if (Up == true) {
				if (Down == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Top Left");
				}
			}
			else if (Right == true) {
				System.out.println("HALT");
			}
			else if (Down == true) {
				if (Left == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Bottom Left");
				}
			}
			else {
				System.out.println("Left");
			}
		}
		else if (Right == true) {
			if (Down == true) {
				if (Left == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Bottom Right");
				}
			}
			else if (Left == true) {
				System.out.println("HALT");
			}
			else if (Up == true) {
				if (Left == true || Down == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Top Right");
				}
			}
			else {
				System.out.println("Right");
			}

		}
		else {
			System.out.println(player);
			System.out.println("HALT");
		}
	}

	public void keyReleased (KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
			player = "Player 1";
			System.out.println(player);

		}
		else {
			player = "Player 2";
			System.out.println(player);

		}
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			Up = false;
		}
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			Down = false;
		}
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			Left = false;
		}
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			Right = false;
		}    
		if (Up == false && Left == false && Down == false && Right == false) {
			System.out.println("Halt");
		}
		if (Up == true && Left == false && Down == false && Right == false) {
			System.out.println("Up");
		}
		if (Up == false && Left == true && Down == false && Right == false) {
			System.out.println("Left");
		}
		if (Up == false && Left == false && Down == true && Right == false) {
			System.out.println("Down");
		}
		if (Up == false && Left == false && Down == false && Right == true) {
			System.out.println("Right");
		}
		if (Up == true && Left == false && Down == false && Right == true) {
			System.out.println("Top Right");
		}
		if (Up == false && Left == false && Down == true && Right == true) {
			System.out.println("Bottom Right");
		}
		if (Up == true && Left == true && Down == false && Right == false) {
			System.out.println("Top Left");
		}
		if (Up == false && Left == true && Down == true && Right == false) {
			System.out.println("Botton Left");
		}

	}    
	public void keyTyped (KeyEvent e) {    
		l.setText("keyTyped");
	}    
	public static void main(String[] args) {    
		new _Movement();    
	}    
} 