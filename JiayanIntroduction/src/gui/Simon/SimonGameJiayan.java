package gui.Simon;

import gui.GUIApplication;

public class SimonGameJiayan extends GUIApplication {
	public SimonGameJiayan(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		SimonScreenJiayan simonJScreen = new SimonScreenJiayan(getWidth(),getHeight());
		setScreen(simonJScreen);
	}

	public static void main(String[] args) {
		SimonGameJiayan simonJ = new SimonGameJiayan(800,500);
		Thread game = new Thread(simonJ);
		game.start();
	}
	
}
