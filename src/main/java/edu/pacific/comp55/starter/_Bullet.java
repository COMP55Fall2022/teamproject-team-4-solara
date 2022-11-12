package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;


public class _Bullet extends GraphicsProgram {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int RECT_SIZE = 100;
	public static final int NUM_BULLETS = 2; 
	private ArrayList<GRect> bulletArray;
	private GRect bullet;
	private int xVelocity;
	private int numTimes; 
	private _ShipType playerT; 
	private Timer t; 
	private AudioPlayer a;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}
		
	public GRect makeBullet() {
		bulletArray = new ArrayList<GRect>();
		bullet = new GRect (500,500,3, 20);
		bullet.setColor(Color.BLACK);
		bullet.setFillColor(Color.MAGENTA);
		bullet.setFilled(true);
		add(bullet);
		bulletArray.add(bullet);
		return bullet; 
	}
	
	public void removeBullet() {
		bulletArray.remove(bullet);
		remove(bullet);
	}
	
	public void moveBullet(){
		Timer t = new Timer(30,this);
		t.setInitialDelay(20);
		t.start();
	}

	public void pauseBullet() {
		t.stop();
	}

	public void resumeBullet() {
		t.start();
	}
	
	public void restartBullet() {
		makeBullet();
		moveBullet(); 
	}
		
	public void playSound(String fileName, String songName) {
		a = AudioPlayer.getInstance();
		a.playSound(fileName, songName);
	}
	
	public void boundsChecking() {
		// will change this to instance of enemy (GImage) 
		if (bullet.getY() <= 1.0){
			removeBullet();
			restartBullet();
		}
	}

	public void run() {
//		bulletArray = new ArrayList<GRect>();
//		bulletArray.add(bullet);	
		makeBullet();
//		playSound("sound", "bullet_sound.mp3");
		moveBullet();
		if (bullet.getY() <= 300) {
			restartBullet();
		}
	}
	
	public void actionPerformed(ActionEvent e){
		bullet.move(0,-5);
		boundsChecking();
		if (numTimes == -5 ) {
			t.restart();
		}
	}
		
	@Override
	public String toString() {
		return "_Bullet [bullets=" + bulletArray + "]";
	}
 	
	public static void main(String[] args) {
		new _Bullet().start();
	} 
}
