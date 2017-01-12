package gui.Simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class SimonScreenJiayan extends ClickableScreen implements Runnable{
	private ProgressInterfaceJiayan progress;
	private ButtonInterfaceJiayan[] buttons;
	private ArrayList<MoveInterfaceJiayan> sequence;
	private int roundNum;
	private boolean acceptingInput;
	private int lastSelected;
	private int sequenceIndex;
	private TextLabel label;
	public SimonScreenJiayan(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		roundNum = 0;
		addButtons();
		for(int i=0; i<buttons.length; i++)
		{
			viewObjects.add(buttons[i]);
		}
		progress = getProgress();
		label = new TextLabel(350,220,100,40, "Let's Play Simon!");
		sequence = new ArrayList<MoveInterfaceJiayan>();
		lastSelected = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		viewObjects.add(label);
		viewObjects.add(progress);
	}

	private MoveInterfaceJiayan randomMove() {
		int random = (int) (Math.random()*buttons.length);
		while(random==lastSelected)
		{
			random = (int) (Math.random()*buttons.length);
		}
		lastSelected = random;
		return getMove(buttons[random]);
	}

	private MoveInterfaceJiayan getMove(ButtonInterfaceJiayan b) {
		// TODO Auto-generated method stub
		return null;
	}
	private ProgressInterfaceJiayan getProgress() {
		// TODO Auto-generated method stub
		return null;
	}
	private void addButtons() {
		int numButtons = 6;
		Color[] colors = {Color.blue, Color.pink, Color.yellow, Color.green, Color.black, Color.red};
		for(int i=0; i<numButtons; i++)
		{
			final ButtonInterfaceJiayan b = getAButton();
			 buttons[i] = b;
			b.setColor(); 
		    b.setX();
		    b.setY();
		    b.setAction(new Action(){

		    	public void act(){
		    		 if(acceptingInput)
		    		 {
		    			 Thread blink = new Thread(new Runnable(){

		    				 public void run(){
		    					 b.highlight();
		    					 try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		    					 dim();
		    				 }

							private void dim() {
								// TODO Auto-generated method stub
								
							}

		    				 });
		    			 blink.start();
		    			if(b == sequence.get(sequenceIndex).getButton())
		    			{
		    				sequenceIndex++;
		    			}
		    			else
		    			{
		    				progress.gameOver();
		    			}
		    			if(sequenceIndex == sequence.size())
		    			{
		    				Thread nextRound = new Thread(SimonScreenJiayan.this);
		    				nextRound.start();
		    			}
		    			
		    		 }
		    	}
		    	});

		}
	}
	private ButtonInterfaceJiayan getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		  label.setText("");
		    nextRound();
		    acceptingInput = false;
		    roundNum++;
	}
	private void nextRound() {
		// TODO Auto-generated method stub
		acceptingInput = false;                
		roundNum ++;
		progress.setRound(roundNum);
		sequence.add(randomMove());
		progress.setSequenceLength(sequence.size());
		changeText("Simon's Turn");
		label.setText(" ");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		label.setText(" ");
		sequenceIndex = 0;

	}
	private void playSequence() {
		// TODO Auto-generated method stub
		ButtonInterfaceJiayan b = null;
        for(MoveInterfaceJiayan i: sequence){
                if(b!=null)
                       {
							b.dim();
							}
							b = i.getButton();
							b.highlight();
							try {                        
							Thread.sleep((int)(2000*(1.0/roundNum)));
							}        
							catch (InterruptedException e) {
							e.printStackTrace();
							}
							}
							b.dim();
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
