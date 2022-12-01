package edu.pacific.comp55.starter;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class _Movement extends GraphicsProgram {

	public static final int WINDOW_WIDTH = 800;
	public static final int speed = 10;
	public static final int WINDOW_HEIGHT = 600;
	public static final int SHAPE_SIZE = 100;
	public int lastX = 0;
	public int lastY = 0;
	public String player = "";
	public boolean Up = false;
	public boolean Down = false;
	public boolean Right = false;
	public boolean Left = false;
	GOval oval = new GOval(100, 100, SHAPE_SIZE, SHAPE_SIZE);
	GRect rect = new GRect(500, 500, SHAPE_SIZE, SHAPE_SIZE);
	
	private GObject toDrag;

	private MainApplication levelScreen;

	
	public void run() {
		oval.setColor(Color.blue);
		oval.setFilled(true);
		add(oval);
		
		rect.setColor(Color.green);
		rect.setFilled(true);
		add(rect);
		
		addKeyListeners();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();

		toDrag = getElementAt(e.getX(), e.getY());
		
	}
	
	@Override
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
					oval.move(speed, speed*-1);
				}
			}
			else if (Left == true) {
				if (Down == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Top Left");
					oval.move(-1*speed, -1*speed);
				}
			}
			else if (Down == true) {
				System.out.println("HALT");
			}

			else if (Right == false && Left == false && Down == false){
				System.out.println("Up");
				oval.move(0,speed*-1);
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
					oval.move(speed, speed);
				}
			}
			else if (Left == true) {
				if (Right == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Bottom Left");
					oval.move(-1*speed, speed);
				}
			}
			else {
				System.out.println("Down");
				oval.move(0, speed);
			}
		}
		else if (Left == true) {
			if (Up == true) {
				if (Down == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Top Left");
					oval.move(-1*speed, -1*speed);
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
					oval.move(-1*speed, speed);
				}
			}
			else {
				System.out.println("Left");
				oval.move(-1*speed, 0);
			}
		}
		else if (Right == true) {
			if (Down == true) {
				if (Left == true) {
					System.out.println("HALT");
				}
				else {
					System.out.println("Bottom Right");
					oval.move(speed, speed);
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
					oval.move(speed, -1*speed);
				}
			}
			else {
				System.out.println("Right");
				oval.move(speed, 0);
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
			oval.move(0, -1*speed);
		}
		if (Up == false && Left == true && Down == false && Right == false) {
			System.out.println("Left");
			oval.move(-1*speed, 0);
			System.out.println("YOOOOOOO");
		}
		if (Up == false && Left == false && Down == true && Right == false) {
			System.out.println("Down");
			oval.move(0, speed);
		}
		if (Up == false && Left == false && Down == false && Right == true) {
			System.out.println("Right");
			oval.move(speed, 0);
		}
		if (Up == true && Left == false && Down == false && Right == true) {
			System.out.println("Top Right");
			oval.move(speed, -1*speed);
		}
		if (Up == false && Left == false && Down == true && Right == true) {
			System.out.println("Bottom Right");
			oval.move(speed, speed);
		}
		if (Up == true && Left == true && Down == false && Right == false) {
			System.out.println("Top Left");
			oval.move(-1*speed, -1*speed);
		}
		if (Up == false && Left == true && Down == true && Right == false) {
			System.out.println("Botton Left");
			oval.move(-1*speed, speed);
		}
		}	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}
	
	public static void main(String[] args) {
		new _Movement().start();
	}

}

