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
	@Override
	public boolean isTriggered(String userInput) {
		//String[] triggers = {"school", "class", "teachers",};
		//for loop could be used to iterate thru words
		if(Jiayan.findKeyword(userInput, "school", 0)>= 0)
		{
			return true;
		}
		if(Jiayan.findKeyword(userInput, "class", 0)>= 0)
		{
			return true;
		}
		return false;
	}
 
}
