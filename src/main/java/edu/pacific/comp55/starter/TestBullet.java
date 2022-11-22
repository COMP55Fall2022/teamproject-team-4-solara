package edu.pacific.comp55.starter;

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class TestBullet extends GraphicsProgram implements ActionListener{
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int BULLET_LENGTH = 25;
	public static final int BULLET_WIDTH = 3;
	public static final int MS = 50;
	public static final int SPEED = -5;
	public static final int BULLET_SPAWN_Y = PROGRAM_HEIGHT - 50;
	private ArrayList<GRect> bullets;
	Timer t;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		bullets = new ArrayList<GRect>();
		addMouseListeners();
		t = new Timer(MS, this);
		t.start();
	}

	@Override
	public void mousePressed(MouseEvent e) {		
		for(GRect bullet : bullets) {
			if(bullet.getY() < 100) {
				return;
			}		
		}
		newbullet(e.getX());
	}
	
	private void newbullet(double x) {
		GRect bullet = makebullet(x, BULLET_SPAWN_Y);
		bullets.add(bullet);
		add(bullet);
	}

	public GRect makebullet(double x, double y) {
		GRect temp = new GRect(x - BULLET_WIDTH / 2, y, BULLET_WIDTH, BULLET_LENGTH);
		temp.setColor(Color.CYAN);
		temp.setFillColor(Color.magenta);
		temp.setFilled(true);
		bullets.add(temp);
		return temp;
	}

	public void removeBullet() {
//		bulletArray.remove(bullet);
//		remove(bullet);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(GRect bullet : bullets) {
			bullet.move(0, SPEED);
			if(bullet.getY() < 50) {
				bullets.remove(bullet);
				remove(bullet);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		new TestBullet().start();
	}

}
