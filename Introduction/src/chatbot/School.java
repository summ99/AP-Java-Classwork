package chatbot;

public class School implements Topic {
	
	private boolean inSchoolLoop;
	private String schoolResponse;
	public School()
	{
		
	}
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop)
		{
			Jiayan.print("Tell me about school!");
			schoolResponse = Jiayan.getInput();
			if(schoolResponse.indexOf("stop")>=0)
			{
				inSchoolLoop = false;
				Jiayan.talkForever();
			}
			Jiayan.print("That is my favorite part about school too!");
		}
	}

}
