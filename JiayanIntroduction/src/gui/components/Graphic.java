package gui.components;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Graphic implements Visible {
	//FIELDS 
		private BufferedImage image;
		private boolean loadedImages;
		private int x;
		private int y;
		
		/**
		 * Full size graphics constructor
		 * @param x
		 * @param y
		 * @param imageLocation
		 */
		public Graphic(int x, int y, String imageLocation) {
			this.x = x;
			this.y = y;
		loadedImages = false;
			loadImages(imageLocation,0,0);
		}
		
		/**
		 * Custom size graphics constructor
		 * @param x
		 * @param y
		 * @param x width
		 * @param h height
		 * @param imageLocation
		 */
		public Graphic(int x, int y, int w, int h, String imageLocation) {
			this.x = x;
			this.y = y;
			loadedImages = false;
			loadImages(imageLocation,w,h);
		}
		
		/**
		 * Scaled size graphics constructor
		 * @param x
		 * @param y
		 * @param scale 
		 * @param imageLocation
		 */
		public Graphic(int x, int y, double scale, String imageLocation) {
			this.x = x;
			this.y = y;
			loadedImages = false;
			loadImages(imageLocation,scale);
		}

		private void loadImages(String imageLocation, 
				double scale) {
			try{
				//get the full size image
				ImageIcon icon = new ImageIcon(imageLocation);
				int newWidth = (int)(icon.getIconWidth() * scale);
				int newHeight = (int)(icon.getIconHeight() * scale);
				image = new BufferedImage(newWidth,newHeight,
						BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, newWidth,newHeight,
						0,0,icon.getIconWidth(),
						icon.getIconHeight(), null);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		private void loadImages(String imageLocation, 
				int w, int h) {
			try{
				//full size image
				ImageIcon icon = new ImageIcon(imageLocation);
				
				if(w <= 0 && h <=0){
					//use full size icon
					image = new BufferedImage(icon.getIconWidth(),
							icon.getIconHeight(), 
							BufferedImage.TYPE_INT_ARGB);
					//use the graphics2D tool to copy the icon
					Graphics2D g = image.createGraphics();
					g.drawImage(icon.getImage(), 0, 0, null);
				}else{
					//use custom size icon
					image = new BufferedImage(w,h,
							BufferedImage.TYPE_INT_ARGB);
					Graphics2D g = image.createGraphics();
					//note to self: this is how you crop:
					/**
					 * image to draw
					 * xCoord of destination
					 * yCoord of destination
					 * width of destination
					 * height of destination
					 * xCoord of target
					 * yCoord of target
					 * width of target
					 * height of target
					 * null
					 */
					g.drawImage(icon.getImage(), 0, 0, w,h,
							0,0,icon.getIconWidth(),
							icon.getIconHeight(), null);
				}
				loadedImages = true;
			}catch(Exception e){
				//this happens when you don't name the image correctly
				e.printStackTrace();
			}
			
		}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	public void setX( int x)
	{
		this.x=x;
	}
	public void setY( int y)
	{
		this.y=y;
	}
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return image.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return image.getHeight();
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//image stays the same
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	

	public boolean isHovered(int x2, int y2) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}

}
