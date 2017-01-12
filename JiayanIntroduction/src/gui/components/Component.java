package gui.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Component implements Visible {
	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image;
	public Component(int x, int y, int w, int h) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		update(image.createGraphics());
	}
	public BufferedImage getImage() {
		return image;
	}
	public int getX() {
		
		return x;
	}

	@Override
	public int getY() {
		
		return y;
	}
	public void setX(int x) {
		
		this.x = x;
		
	}
	public void setY(int y) {
		
		this.y = y;
		
	}
	@Override
	public int getWidth() {
		
		return w;
	}

	@Override
	public int getHeight() {
		
		return h;
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		update(image.createGraphics());
	}
	public abstract void update(Graphics2D g);
	
	public Graphics2D clear()
	{
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		return image.createGraphics();
		
	}

}
