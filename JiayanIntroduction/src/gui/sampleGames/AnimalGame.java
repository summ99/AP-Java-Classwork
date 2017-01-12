package gui.sampleGames;

import gui.GUIApplication;
import gui.screens.CoordinateScreen;

public class AnimalGame extends GUIApplication {
	public static AnimalGame game;
	public static AnimalScreen as;
	public static MyScreen theScreen;
	public AnimalGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		
		as = new AnimalScreen(getWidth(),getHeight());
		setScreen(as);
		theScreen = new MyScreen(getWidth(), getHeight());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
