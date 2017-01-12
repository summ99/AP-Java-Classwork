package gui.components;

import java.awt.Image;

public interface Visible {
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public boolean isAnimated();
	public void update();
	public Image getImage();
}
