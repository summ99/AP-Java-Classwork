package gui.whackAMole;

import java.util.ArrayList;
import java.util.List;

import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class WhackAMoleScreen extends ClickableScreen implements Runnable{
	 private ArrayList<MoleInterface> moles;
	 private PlayerInterface player;
	 private TextLabel label;
	 private TextLabel timeLabel;
	 private double timeLeft;

	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft = 30.0;
		//when making Simon, creating a thread like this is necessary since Simon's screen changes
		Thread play = new Thread(this);
		play.start();
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer(); //similar to simon's score tracker
		label = new TextLabel(350,220,100,40,"Intentionally Blank");
		timeLabel = new TextLabel(360,40,80,40, "30.0");
		viewObjects.add(timeLabel);
		viewObjects.add(label);
		viewObjects.add(player);
	}
	public PlayerInterface getAPlayer()
	{
		return new Player();
		//placeHolder until partner finishes the design of players for now it returns null 
	}
	public MoleInterface getAMole()
	{
		return new Mole((int)(Math.random()*getWidth()), (int)(Math.random()*getHeight()));
	}

	@Override
	public void run() {
		changeText("Ready");
		changeText("Set");
		changeText("GO");
		label.setText(" ");
		//while loop JUST for this timed game/NOT NECESSARY for untimed games like simon
		while(timeLeft>0)
		{
			updateTimer();
			updateAllMoles();
			newMoleAppears();
		}
	}

	private void newMoleAppears() {
		double chance = .2*(60-timeLeft)/60;
		if(Math.random()>chance)
		{
			//create a mole
			final MoleInterface mole = getAMole();
			//final means mole doesn't get changed otherwise computer won't remove it 
			mole.setAppearanceTime((int)(Math.random()*2000));
			//tell mole what to do when clicked
			mole.setAction(new Action(){
				public void act()
				{
					player.increaseScore(1);
					remove(mole);
					moles.remove(mole);
				}
			});
			addObject(mole);
			moles.add(mole);
		}
		
	}
	private void updateAllMoles() {
		for(int i =0; i<moles.size();i++)
		{
			MoleInterface m = moles.get(i);
			int screenTime = m.getAppearanceTime()-100;
			m.setAppearanceTime(screenTime);
			if(m.getAppearanceTime()<=0)
			{
				remove(m); //REMOVES PIC
				moles.remove(m);//removes mole
				i--; //compensate for removal
			}
		}
		
	}
	private void updateTimer() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeLeft-=.1;
		timeLabel.setText(""+(int)((timeLeft)*10)/10.0);
//0.1 is not a clean number in binary so to fix te output we use the formula to round to nearest 10th
	}
	private void changeText(String text) {
		label.setText(text);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
