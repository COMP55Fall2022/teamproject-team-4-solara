package edu.pacific.comp55.starter;

/**
 * This class is the main class that runs the whole program, which allows the Players to play in
 * @author Nathan Osorio, Miguel Constantino-Guzman, Manohar V. Dhulipala, and Divine Atah
 *
 */
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 3000; // Original width and height = 3000 x 1080
	public static final int WINDOW_HEIGHT = 1080; // change pixels for images to 3000 by 1000 - 4 NATHAN
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3", "SOLARA game background theme (1).mp3", "ButtonSound.mp3" };
	private LevelScreen level; 
	private HowToPlayScreen howToPlay;
	private MenuPane menu;
	private ChoosePlaneScreen choosePlane; 
	
	// initializes window height/width
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	// runs program
	public void run() {
		howToPlay = new HowToPlayScreen(this);
		menu = new MenuPane(this);
		level = new LevelScreen(this);
		choosePlane = new ChoosePlaneScreen(this);
		setupInteractions();
		switchToMenu();
	}
	// Sets Player ships of ShipType
	public void setPlayerType(_ShipType p1, _ShipType p2) {
		level.setPLayersType(p1, p2);
	}

	// Called when switching to menu screen
	public void switchToMenu() {
		playMenuSound();
		switchToScreen(menu);
	} 
	// Adds a "quit" box
	public void addQuitBox() {
		menu.addQuitBox();
	}

	// Switched to the "how to play" screen
	public void switchToHowToPlay() {
	
		switchToScreen(howToPlay);
	}
	// Switches to the "level" screen
	public void switchToLevel() {
		switchToScreen(level);
	}
	// Switches to the "Choose plane" screen
	public void switchToChoosePlane() {
		switchToScreen(choosePlane);
	}
	// plays "menu" sound
	private void playMenuSound() {
		AudioPlayer mSound = AudioPlayer.getInstance(); 
		mSound.playSound(MUSIC_FOLDER, SOUND_FILES[2]);
		System.out.println("Sound plays!");
	}
	
	// plays "button" sounds when clicking on, for example, the "Play Game" button
	void playButtonSound() {
		AudioPlayer bSound = AudioPlayer.getInstance();
		bSound.playSound(MUSIC_FOLDER, SOUND_FILES[3]);
	}
	// to assist in starting the program
	public static void main(String[] args) {
		new MainApplication().start();
	}
		
}