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

			if (Right == true) {
				if (Down == true || Left == true) {
					l.setText("HALT");
				}
				else {
					l.setText("Top Right");
				}
			}
			else if (Left == true) {
				if (Down == true) {
					l.setText("HALT");
				}
				else {
					l.setText("Top Left");
				}
			}
			else if (Down == true) {
				l.setText("HALT");
			}

			else if (Right == false && Left == false && Down == false){
				l.setText("Up");
			}
		}
		else if (Down == true) {
			if (Up == true) {
				l.setText("HALT");
			}
			else if (Right == true) {
				if (Up == true || Left == true) {
					l.setText("HALT");
				}
				else {
					l.setText("Bottom Right");
				}
			}
			else if (Left == true) {
				if (Right == true) {
					l.setText("HALT");
				}
				else {
					l.setText("Bottom Left");
				}
			}
			else {
				l.setText("Down");
			}
		}
		else if (Left == true) {
			if (Up == true) {
				if (Down == true) {
					l.setText("HALT");
				}
				else {
					l.setText("Top Left");
				}
			}
			else if (Right == true) {
				l.setText("HALT");
			}
			else if (Down == true) {
				if (Left == true) {
					l.setText("HALT");
				}
				else {
					l.setText("Bottom Left");
				}
			}
			else {
				l.setText("Left");
			}
		}
		else if (Right == true) {
			if (Down == true) {
				if (Left == true) {
					l.setText("HALT");
				}
				else {
					l.setText("Bottom Right");
				}
			}
			else if (Left == true) {
				l.setText("HALT");
			}
			else if (Up == true) {
				if (Left == true || Down == true) {
					l.setText("HALT");
				}
				else {
					l.setText("Top Right");
				}
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
			l.setText("Halt");
		}
		if (Up == true && Left == false && Down == false && Right == false) {
			l.setText("Up");
		}
		if (Up == false && Left == true && Down == false && Right == false) {
			l.setText("Left");
		}
		if (Up == false && Left == false && Down == true && Right == false) {
			l.setText("Down");
		}
		if (Up == false && Left == false && Down == false && Right == true) {
			l.setText("Right");
		}
		if (Up == true && Left == false && Down == false && Right == true) {
			l.setText("Top Right");
		}
		if (Up == false && Left == false && Down == true && Right == true) {
			l.setText("Bottom Right");
		}
		if (Up == true && Left == true && Down == false && Right == false) {
			l.setText("Top Left");
		}
		if (Up == false && Left == true && Down == true && Right == false) {
			l.setText("Botton Left");
		}

	}    
	public void keyTyped (KeyEvent e) {    
		l.setText("keyTyped");
	}    
	public static void main(String[] args) {    
		new _Movement();    
	}    
} 