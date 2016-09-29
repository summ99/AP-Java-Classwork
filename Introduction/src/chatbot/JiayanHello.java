package chatbot;

public class JiayanHello implements Topic {
	private boolean inHelloLoop;
	private String helloResponse;
	private int helloCount;
	private static String [] calmResponses = {"We've already said our hellos","We've already"
			+ "said hello, let's talk"};
	private static String [] angryResponses = {"Stop saying hello over and over again",
			"You're makng me angry now"};
	public void talk() {
		inHelloLoop = true;
		while(inHelloLoop)
		{
			helloCount++;
			printResponse();
			helloResponse = Jiayan.getInput();
			if(!isTriggered(helloResponse))
			{
				inHelloLoop = false;
				Jiayan.talkForever();
			}
		}
	}

	private void printResponse() {
		int responseIndex =0;
		if(helloCount<5)
		{
			responseIndex = (int)(Math.random()*calmResponses.length);
			Jiayan.print(calmResponses[responseIndex]);
		}
		else
		{
			responseIndex = (int)(Math.random()*angryResponses.length);
			Jiayan.print(angryResponses[responseIndex]);
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		if(Jiayan.findKeyword(userInput, "hi", 0)>= 0)
		{
			return true;
		}
		if(Jiayan.findKeyword(userInput, "hello", 0)>= 0)
		{
			return true;
		}
		return false;
		
	}

}
