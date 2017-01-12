package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import gui.components.Visible;

public abstract class Screen {
	//abstract classes can't be instantiated!!!
	/*
	  ArrayList Lesson:
						      Arrays	                ArrayList
				declaration     int[]nums ArrayList  <Integer> nums
				instantiation   nums = new int[5];   nums = new ArrayList<Integer>()
				adding items    num[i]=4;	     nums.add(new Integer(5))
				length/size     nums.length          nums.size() 
*/
	private BufferedImage image;
	private ArrayList<Visible> viewObjects;
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList <Visible>();
		initObjects(viewObjects);
		initImage(width, height);
		
	}
	public abstract void 
	initObjects(ArrayList<Visible> viewObjects);
	
	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
	}
	public BufferedImage getImage()
	{
		return image;
	}
	public int getWidth()
	{
		return image.getWidth();
	}
	public int getHeight()
	{
		return image.getHeight();
	}
	void update() {
		Graphics2D g = image.createGraphics();
		//smooth graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		//g.drawString("Hello World", 40, 100);
		//g.drawOval(20, 70, 100, 50);
		//for(i=0;i<viewObjects.size(); i++){}
		for(int i =0; i<viewObjects.size(); i++)
		{
			Visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
	}
	public MouseMotionListener getMouseMotionListener()
	{
		return null;
	}
	public MouseListener getMouseListener() 
	{
		return null;
	}
	public void addObject(Visible v)
	{
		viewObjects.add(v);
	}
	public void removeObject(Visible v)
	{
		viewObjects.remove(v);
	}
	/* in this implementation, we have a simple command :remove(v),however when an object is removed 
	 * from a list, every object after that object is moved up in order, therefore, you must be aware 
	 * that ALL of their indices change!
	 * Here is an example: 
	 * (the following is wrong) suppose u have List<Integer> with 4,8,7,1 and u want to move all integers greater than 5,
	 * u do 
	 * 			for(int i =0; i<List.size(); i++)
	 * 			{ 
	 * 				if (list.get(i)>5)
	 * 					{
	 * 						list.remove(i);
	 * 					}
	 * 			}
	 * 			YOU FAIL (once 8 is removed, everything moves and 7 is skipped and left in the list)
	 *----------------------------THIS IS THE CORRECT WAY---------------------------------
	 * 			while(list.get(i)>5)
	 * 			{
	 * 				list.remove(i);
	 * 			}
	 *-----------------------------ORRRRR-------------------------------------------------
	 * 		for(int i =0; i<List.size(); i++)
	 * 			{ 
	 * 				if (list.get(i)>5)
	 * 					{
	 * 						list.remove(i);
	 * 						i--;
	 * 					}
	 * 			}
	 * ArrayList is an instance of List, which is abstract and cannot be instantiated
	 * If you call List.remove(int), it will return the object being removed at that index, 
	 * so you could do:
	 * 	System.out.println(List.remove(0) + toString() + " was removed."));
	 * This mo
	  */
	 public void moveToBack(Visible v)
	 {
		 if(viewObjects.contains(v))
		 {
			 viewObjects.remove(v);
			 //back is index 0
			 viewObjects.add(0,v);
		 }
	 }
	 public void moveToFront(Visible v)
	 {
		 if(viewObjects.contains(v))
		 {
			 viewObjects.remove(v);
			 viewObjects.add(v);
		 }
	 }
	public void initObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
}
