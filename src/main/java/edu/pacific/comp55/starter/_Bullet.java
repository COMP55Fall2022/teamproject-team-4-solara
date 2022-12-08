package edu.pacific.comp55.starter;

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class _Bullet {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int BULLET_LENGTH = 25;
	public static final int BULLET_WIDTH = 3;
	public static final int MS = 1;
	public static final int SPEED = -5;
	public static final int BULLET_SPAWN_Y = PROGRAM_HEIGHT - 50;
	private ArrayList<GRect> bullets;
	private ArrayList<GImage> enemy;
	Timer t;
	MainApplication app;
	private _ToolDesign tool;

	private AudioPlayer pSound;
	private final String SOUND = "sounds";
	private final String BULLET = "BulletSound.mp3";

	public _Bullet(MainApplication app) {
		this.app = app;
		bullets = new ArrayList<GRect>();
	}

	public void playSound() {
		pSound = AudioPlayer.getInstance();
		pSound.playSound(SOUND, BULLET);
	}

	public void mousePressed(MouseEvent e) {
		newBullet(e.getX());
	}

	private GRect makeBullet(double x, double y) {
		GRect temp = new GRect(x - BULLET_WIDTH / 2, y, BULLET_WIDTH, BULLET_LENGTH);
		temp.setColor(Color.CYAN);
		temp.setFillColor(Color.magenta);
		temp.setFilled(true);
		app.add(temp);
		return temp;
	}

	public void newBullet(double x) {
		GRect bullet = makeBullet(x, BULLET_SPAWN_Y);
		bullets.add(bullet); // adds to ArrayList
		app.add(bullet); // adds to "screen"
		playSound();
	}

	public void removeBullet() {
		for (GRect bullet : bullets) {
			if (bullet.getY() < 0) {
				app.remove(bullet);
				bullets.remove(bullet);
				return;
			}
		}
	}

	public void shoot() {
		for (GRect bullet : bullets) {
			bullet.move(0, SPEED);
		}
	}

}

