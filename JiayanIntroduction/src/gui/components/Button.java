package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

	public class Button extends TextLabel implements Clickable {
		
		private java.awt.Color Color;
		private gui.components.Action Action;
		
		public Button(int x, int y, int w, int h, String text, Color color, Action action) {
			super(x, y, w, h, text);
			this.Color = color;
			this.Action = action;
			update();
			// TODO Auto-generated constructor stub
		}
	public Color getColor()
	{
		return Color;
	}
	public void setColor(Color c)
	{
		Color = c;
		update();
	}
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 25);
		g.setColor(Color.black);
		g.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, 35, 25);
		g.setFont(new Font(getFont(),Font.PLAIN,getSize()));
		FontMetrics fm = g.getFontMetrics();
				if(getText()!=null){
					g.setColor(Color.white);
					String t = getText();
					// NOCKLES CODE FOR CENTERING   just in case text is too wide, cut off
					int cutoff = t.length();
					while(cutoff > 0 && fm.stringWidth(t) > getWidth()){
						cutoff --;
						t = t.substring(0,cutoff); 
					}
					g.drawString(t, (getWidth()-fm.stringWidth(t))/2, (getHeight()+fm.getHeight()-fm.getDescent())/2);
			
				}
	
			}
	@Override
	public boolean isHovered(int x, int y) {
		if(x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight())
		{
			return true;
		}
		else
			{
			return false;
			}
	}
	@Override
	public void act() {
		Action.act();
		
	}
	}
