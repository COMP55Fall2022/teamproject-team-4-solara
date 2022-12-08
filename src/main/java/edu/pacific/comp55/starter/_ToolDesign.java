package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class _ToolDesign implements ActionListener {

	private static final int E_HEIGHT = 50;
	private static final int E_WIDTH = 50;
	private ArrayList<GImage> enemies;
	private ArrayList<GRect> bullets;
	private _BattleShip battleShip1;
	private _BattleShip battleShip2;
	private RandomGenerator rgen;
	private Timer movement;
	private int moveDirector;
	private int numTimes;
	private MainApplication mainScreen;
	private _Bullet bulletObj;

	private String UFO1 = "UFO1.png";
	private String UFO2 = "UFO2.png";
	private String UFO3 = "UFO3.png";
	private AudioPlayer bullSound; 
	private final String SOUND = "sounds";
	private final String BULLETMP3 = "BulletSound.mp3";

	public _ToolDesign(MainApplication app, _ShipType p1, _ShipType p2) {
		mainScreen = app;
		moveDirector = 1;

		battleShip1 = new _BattleShip(p1, app);
		battleShip2 = new _BattleShip(p2, app);
		
		 
	}
	
	public void playSound () {
		bullSound = AudioPlayer.getInstance();
		bullSound.playSound(SOUND, BULLETMP3);
	}

	public void setBattleShip1(_ShipType t) {
		battleShip1 = new _BattleShip(t, mainScreen);
		//this.battleShip1.setShipType(t);;
	}


	public void setBattleShip2(_ShipType t) {
		battleShip2 = new _BattleShip(t, mainScreen);
		//this.battleShip2.setShipType(t);;
	}


	public GImage makeEnemy2(double y) {
		GImage temp2 = new GImage("media/" + UFO2, y + 200, 150);
		// temp2.setColor(Color.BLUE);
		// temp2.setFilled(true);
		return temp2;

	}

	private void addAnEnemy2() {
		GImage e2 = makeEnemy2(rgen.nextInt(0, 1000));
		enemies.add(e2);
		mainScreen.add(e2);
	}

	public GImage makeEnemy3(double y) {
		GImage temp3 = new GImage("media/" + UFO3, y + 200, 275);
		// temp3.setColor(Color.YELLOW);
		// temp3.setFilled(true);
		return temp3;

	}

	private void addAnEnemy3() {
		GImage e3 = makeEnemy3(rgen.nextInt(0, 1000));
		enemies.add(e3);
		mainScreen.add(e3);

	}

	public GImage makeEnemy(double y) {
		GImage temp = new GImage("media/" + UFO1, y + 200, 50);
		// temp.setColor(Color.GREEN);
		// temp.setFilled(true);
		return temp;
	}

	private void moveAllEnemiesOnce() {
		int dx = (moveDirector > 0) ? -2 : 2;
		moveDirector += (moveDirector > 0) ? 1 : -1;
		if (moveDirector > 50)
			moveDirector = -1;
		if (moveDirector < -50)
			moveDirector = 1;

		for (GImage image : enemies) {
			image.move(dx, 0);
		}
	}

	private void addAnEnemy() {
		GImage e = makeEnemy(rgen.nextInt(0, 1000));
		enemies.add(e);
		mainScreen.add(e);
	}

	public void run() {

		rgen = RandomGenerator.getInstance(); 
		enemies = new ArrayList<GImage>(); 
		bullets = new ArrayList<GRect>(); 
		battleShip1.showPlayer();
		battleShip2.showPlayer();
		movement = new Timer(50, this);
		movement.start();
	}
		

	public void actionPerformed(ActionEvent e) {
		
		numTimes += -1;
		if (numTimes % 100 == 0) {
			addAnEnemy();
			addBullet();
			playSound();
		}
		if (numTimes % 50 == 0) {
			addAnEnemy2();
			addBullet();
			playSound();
		}
		if (numTimes % 75 == 0) {
			addAnEnemy3();
			addBullet();
			playSound();
			
		}

		moveAllEnemiesOnce();
		moveAllBulletsOnce();
	}

	public GRect makeBullet(double x, double y) {
		GRect tempBullet = new GRect(x + E_WIDTH, y + E_HEIGHT, 5, 10);
		tempBullet.setColor(Color.RED);
		tempBullet.setFilled(true);
		return tempBullet;

	}

	public void addBullet() {
		if (enemies.size() < 1) {
			return;
		}
		int enemyIndex = rgen.nextInt(0, enemies.size() - 1);
		GRect b = makeBullet(enemies.get(enemyIndex).getX(), enemies.get(enemyIndex).getY());
		bullets.add(b);
		mainScreen.add(b);
	}

	public void moveAllBulletsOnce() {
		for (GRect bullet : bullets) {
			bullet.move(0, 10);

			// bulletCheck = getElementAt(bullet.getX() + (bullet.getWidth() + 1),
			// bullet.getY() + (bullet.getHeight() / 2)); // check for bullet collision
		}
	}
	// come back to this and make another enemy type to add another line of enemy
	// below the ones already made


	
	public void keyPressed(KeyEvent e) {
		battleShip1.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		battleShip1.keyReleased(e);
	}

	public ArrayList<GImage> getEnemies() {
		
		return enemies;
	}

	
}
