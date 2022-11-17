package edu.pacific.comp55.starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600; // change pixels for images to 3000 by 1000 - 4 NATHAN 
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3", "Main menu theme.mp3", "ButtonSound.mp3" };
	private LevelScreen level; 
	private HowToPlayScreen howToPlay;
	private MenuPane menu;
	private int count;
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
	//	_Powerups speed = new _Powerups(this);
	
		howToPlay = new HowToPlayScreen(this);
		menu = new MenuPane(this);
		level = new LevelScreen(this);
		setupInteractions();
		switchToMenu();
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
	
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
}
