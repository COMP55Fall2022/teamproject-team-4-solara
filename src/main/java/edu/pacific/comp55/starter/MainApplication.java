package edu.pacific.comp55.starter;

import java.awt.event.KeyEvent;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 3000;
	public static final int WINDOW_HEIGHT = 1080; // change pixels for images to 3000 by 1000 - 4 NATHAN 
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3", "Main menu theme.mp3", "ButtonSound.mp3" };
	private LevelScreen level; 
	private HowToPlayScreen howToPlay;
	private MenuPane menu;
	private ChoosePlaneScreen choosePlane; 
	private _HealthBar healthBar; 
	private int count;
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
	    //_Powerups speed = new _Powerups(this);
		healthBar = new _HealthBar(this, WINDOW_WIDTH, WINDOW_HEIGHT, 5);
		MainApplication.add(healthBar);
		howToPlay = new HowToPlayScreen(this);
		menu = new MenuPane(this);
		level = new LevelScreen(this);
		choosePlane = new ChoosePlaneScreen(this);
		setupInteractions();
		switchToMenu();
	}
	


	private static void add(_HealthBar healthBar2) {
		
		
	}

	public void switchToMenu() {
		playMenuSound();
		count++;
		switchToScreen(menu);
	}

	public void switchToHowToPlay() {
	
		switchToScreen(howToPlay);
	}
	public void switchToLevel() {
		switchToScreen(level);
	}
	
	public void switchToChoosePlane() {
		switchToScreen(choosePlane);
	}
	
	private void playMenuSound() {
		AudioPlayer mSound = AudioPlayer.getInstance(); 
		mSound.playSound(MUSIC_FOLDER, SOUND_FILES[2]);
	}
	

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	void playButtonSound() {
		AudioPlayer bSound = AudioPlayer.getInstance();
		bSound.playSound(MUSIC_FOLDER, SOUND_FILES[3]);
	}
	
	@Override
	public void keyPressed (KeyEvent e) { 
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}


}
