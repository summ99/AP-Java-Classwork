package chatbot;

public class JiayanLike implements Topic{
	private boolean	inLikeLoop;
	private String likeResponse;
	public void talk() {
	Jiayan.print("What are some things you like?");
	inLikeLoop = true;
	while(inLikeLoop)
	{
		likeResponse = Jiayan.getInput();
		int likePsn = Jiayan.findKeyword(likeResponse, "like", 0);
		if(likePsn >= 0)
		{
			String thingsLiked = likeResponse.substring(likePsn+5);
			Jiayan.print("You are such an interesting person because you like"+thingsLiked);
			if(Jiayan.findKeyword(thingsLiked, "school", 0) >= 0)
			{
				inLikeLoop = false;
				Jiayan.school.talk();
			}
			else
			{	
				inLikeLoop = false;
				Jiayan.talkForever();}
			
		}
		else{
			Jiayan.print("I don't understand you");
		}
	}
	
	}
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
