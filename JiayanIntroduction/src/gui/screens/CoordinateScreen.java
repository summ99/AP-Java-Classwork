package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.MovingComponent;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener{

	private Button myButton;
	private TextArea area;
	private Graphic pug;
	private TextLabel text;
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}
	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		
		myButton = new Button(20,100,80,40,"Hello Button",new Color(0,76,153), new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
			});
		viewObjects.add(myButton);
		
		text = 
				new TextLabel(20, 300, 500, 40, "Some text");
		viewObjects.add(text);
		
		area = 
				new TextArea(20, 200, 500, 100, "This is "
						+ "really long text. It prints over"
						+ " multiple lines, as you can see. "
						+ "We worked on this in class. It"
						+ " is called TextArea.");
		viewObjects.add(area);
		
		pug = new Graphic(30,30,.5, "resources/sampleImages/pug.jpg");
		viewObjects.add(pug);
		MovingComponent c = new MovingComponent(20,20,100,100);
		viewObjects.add(c);
		c.setVy(2);
		c.setX(1);
		c.play();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();//get mouse x coordinate
		int my = e.getY();
		//text.setText("Mouse at " +mx + ", "+ my);
		
	}
	public MouseMotionListener getMouseMotionListener()
	{
		return this;
	}
	public MouseListener getMouseListener()
	{
		return this;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(myButton.isHovered(e.getX(), e.getY()))
		{
			myButton.act();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
