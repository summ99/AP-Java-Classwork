package gui.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;

import gui.components.ClickableGraphic;
import gui.components.Graphic;
import gui.components.Visible;

public class AnimalScreen extends Screen implements MouseListener, MouseMotionListener{
	private ClickableGraphic pug;
	private Graphic turtle;
	public AnimalScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		pug = new ClickableGraphic(30,30,.5, "resources/sampleImages/pug.jpg");
		viewObjects.add(pug);
		turtle = new Graphic(30,30,.5, "resources/sampleImages/turtle.jpg");
		viewObjects.add(turtle);

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
		if(pug.isHovered(e.getX(), e.getY()))
		{
			pug.act();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
