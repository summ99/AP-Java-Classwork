package gui.components;

import java.awt.Color;
import java.awt.Graphics2D;

public class MovingComponent extends Component implements Runnable {
	private long moveTime; //time when the image last moved
	private double vx; //the horizontal velocity
	private double vy; //the vertical velocity
	private double posx; //the actual x-coordinate of the object
	private double posy; //the actual y-coordinate of the object
	private boolean running;

	public static final int REFRESH_RATE = 20;
	
	public MovingComponent(int x, int y, int w, int h) {
		super(x, y, w, h);
		vx = 0;
		vy = 0;
	}
	public boolean isAnimated(){
		return true;
	}
	
	public void setX(int x)
	{
		super.setX(x);
		posx = x;
	}
	public void setY(int y)
	{
		super.setY(y);
		posy = y;
	}
	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	
	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}
	
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	@Override
	public void update(Graphics2D g) {
		long currentTime = System.currentTimeMillis();
		int difference = (int)(currentTime - moveTime);
		if(difference > REFRESH_RATE)
		{
			moveTime= currentTime;
			posx += vx*(double)difference/REFRESH_RATE;
			posy += vy*(double)difference/REFRESH_RATE;
			//for very low velocities the position might not change by very much so rounding 
			//down to an int might make it look like nothing changed
			super.setX((int)posx);//change only x and y not posx and posy
			super.setY((int)posy);
		}
		drawImage(g);
	}

	private void drawImage(Graphics2D g) {
		// black circle
		g.setColor(Color.black);
		g.fillOval(0, 0, getWidth(), getHeight());
		
	}
	@Override
	public void run() {
		posx = getX();
		posy = getY();
		running = true;
		moveTime = System.currentTimeMillis();
		while(running)
		{
			try {
				Thread.sleep(REFRESH_RATE);
				checkBehaviors();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void checkBehaviors() {
		// TODO Auto-generated method stub
		if(getY()>300)
		{
			setY(300);
			setVy(-vy);
		}
	}
	public void play()
	{
		if(!running)
		{
			Thread go =new Thread(this);
			go.start();
		}
	}

}
