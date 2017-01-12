package gui.whackAMole;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Component;

public class Player extends Component implements PlayerInterface {
	private int score;
	public Player() {
		super(20,20,100,100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increaseScore(int i) {
		// TODO Auto-generated method stub
		score +=i;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(200,220,255));
		g.fillOval(0, 0, 99, 99);
		g.drawOval(0, 0, 99, 99);
		g.drawString("Score = " + score, 40, 55);
	}

}
