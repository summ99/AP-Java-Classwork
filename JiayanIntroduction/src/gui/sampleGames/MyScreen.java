package gui.sampleGames;

import java.awt.Color;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Visible;

public class MyScreen extends Screen {
	private Button newButton;
	public MyScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		newButton = new Button(20,100,80,40,"Hi Button",new Color(0,76,153), new Action(){
			public void act(){
				
			}
			});
		viewObjects.add(newButton);

	}

}
