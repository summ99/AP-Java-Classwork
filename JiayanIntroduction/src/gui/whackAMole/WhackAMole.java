package gui.whackAMole;

import gui.GUIApplication;

public class WhackAMole extends GUIApplication {

	public WhackAMole(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		WhackAMoleScreen wams = new WhackAMoleScreen(getWidth(),getHeight());
		setScreen(wams);
	}

	public static void main(String[] args) {
		WhackAMole wamg= new WhackAMole(800,500);
		Thread game = new Thread(wamg);
		game.start();

	}

}
