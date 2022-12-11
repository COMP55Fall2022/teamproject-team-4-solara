package edu.pacific.comp55.starter;
/**
 * This class helps in displaying menu screen buttons, images for the enemies, labels, and for
 * help in shooting bullets
 * @author Nathan Osorio, Miguel Constantino-Guzman, Manohar V. Dhulipala, and Divine Atah
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.G3DRect;
import acm.graphics.GImage;
import javax.swing.*;


public class LevelScreen extends GraphicsPane implements ActionListener {
	private MainApplication program;
	private GImage level; 
	private _ToolDesign engine;
	private _HealthBar healthBar; 
	private _Powerups powerups; 
	private _Score score;
	private AudioPlayer pSound; 
	private final String SOUND = "sounds"; 
	private final String BULLET = "BulletSound.mp3";

	int BULLET_SPAWN_Y = 1080 - 50; // PROGRAM_HEIGHT - 50
	
	public GParagraph sureM; 
	public G3DRect rect;  
	public GButton yes; 
	public GButton no; 


	private _Bullet bulletObj;
	private Timer t;
	
	private int w; 
	private int h; 

	public LevelScreen(MainApplication app) {
		// to add objects to MainApplication program
		this.program = app;
		level = new GImage("media/Space Background.jpg", 0, 0);
		engine = new _ToolDesign(app, _ShipType.SHIP_BALANCED, _ShipType.SHIP_BALANCED);
		healthBar = new _HealthBar(app);
		powerups = new _Powerups(app);
		score = new _Score(app);
		bulletObj = new _Bullet(app);
		
		// Adds "return to screen" text
		sureM = new GParagraph ("Are you sure you'd\n         like to quit?", 580, 380);
		rect = new G3DRect(550,300, w , h);
		yes = new GButton ("YES", w * 1.50, h * 1.60, 100,50);
		no = new GButton ("NO", w * 2, h * 1.60, 100,50);
		
		// sets colors for "YES" and "NO" buttons when trying to quit the game/level
		yes.setColor(Color.RED);
		yes.setFillColor(Color.GRAY);
		no.setColor(Color.GREEN);
		no.setFillColor(Color.GRAY);
		sureM.setFont("impact-bold-40");
		sureM.setColor(Color.CYAN);
		rect.setColor(Color.WHITE) ;
		rect.setFillColor(Color.GRAY);
		rect.setFilled(true);

	}
	
	/**
	 * Assigns battleships 1 and 2 to the level screen
	 * @param t1 --> from enumerator of type ShipType
	 * @param t2 --> from enumerator of type ShipType
	 */
	void setPLayersType(_ShipType t1, _ShipType t2) {
		engine.setBattleShip1(t1);
		engine.setBattleShip2(t2);
	}

	// assigns sound to Player bullets when shot
	public void playSound() {
		pSound = AudioPlayer.getInstance();
		pSound.playSound(SOUND, BULLET);
	}
	/*
	 * shows contents on screen for power ups, health bar, and score labels, as well as a timer for the
	 * bullets shot from the players
	 */
	public void showContents() {
		program.add(level);
		engine.run();
		healthBar.makeHealthBar();
		powerups.run();
		score.addScoreLabel();
		// Timer to allow bullets to move
		t = new Timer(1, this);
		t.start();
	}
	
	// "Return to screen" box
	public void addReturnBox() {
		program.add(rect);
		program.add(sureM);
		program.add(yes);
		program.add(no);
	}
	// Removes "Return to screen" box
	public void removeReturnBox() {
		program.remove(rect);
		program.remove(sureM);
		program.remove(yes);
		program.remove(no);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); 
		if ( key == KeyEvent.VK_ESCAPE) {
			addReturnBox();
		}
	}

	// receives player input (after mouse is pressed to shoot a bullet/bullets)
	public void actionPerformed(ActionEvent e) {
		bulletObj.shoot();
		bulletObj.removeBullet(); 
	}
	// "mouse-pressed" coordinates to make a bullet and plays sound after
	public void mousePressed(MouseEvent e) {
		bulletObj.newBullet(e.getX(), e.getY());
		playSound();

	}
		
	public void hideContents() {
		program.remove(level);
	}
	

	
}
