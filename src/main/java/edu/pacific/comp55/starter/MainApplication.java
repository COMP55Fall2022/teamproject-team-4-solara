package edu.pacific.comp55.starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";
//	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private SomePane howToPlay;
	private MenuPane menu;
	private int count;
	private GButton butt = new GButton("this is a button", 250.0, 250.0, 100, 50);

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
	//	_Powerups speed = new _Powerups(this);
	//	add(butt);
	//	System.out.println("Hello, world!");
		howToPlay = new SomePane(this);
		menu = new MenuPane(this);
		setupInteractions();
		switchToMenu();
	}

	public void switchToMenu() {
		playRandomSound();
		count++;
		switchToScreen(menu);
	}

	public void switchToSome() {
		playRandomSound();
		switchToScreen(howToPlay);
	}
	public void switchToHowToPlay() {
	//	switchToScreen(howToPlay); 
	}

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
//		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
}
