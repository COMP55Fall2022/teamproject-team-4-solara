package edu.pacific.comp55.starter;

import java.awt.event.KeyEvent;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 3000; // Original width and height = 3000 x 1080
	public static final int WINDOW_HEIGHT = 1080; // change pixels for images to 3000 by 1000 - 4 NATHAN
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3", "SOLARA game background theme (1).mp3", "ButtonSound.mp3" };
	private LevelScreen level; 
	private HowToPlayScreen howToPlay;
	private MenuPane menu;
	private ChoosePlaneScreen choosePlane; 
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		howToPlay = new HowToPlayScreen(this);
		menu = new MenuPane(this);
		level = new LevelScreen(this);
		choosePlane = new ChoosePlaneScreen(this);
		setupInteractions();
		switchToMenu();
	}

	public void switchToMenu() {
		playMenuSound();
		switchToScreen(menu);
	}
	public void addQuitBox() {
		menu.addQuitBox();
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
		System.out.println("Sound plays!");
	}
		
	void playButtonSound() {
		AudioPlayer bSound = AudioPlayer.getInstance();
		bSound.playSound(MUSIC_FOLDER, SOUND_FILES[3]);
	}
	
	@Override
	public void keyPressed (KeyEvent e) { 
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			menu.addQuitBox();
			
		}
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
		
}
