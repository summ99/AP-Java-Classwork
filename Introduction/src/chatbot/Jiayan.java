package chatbot;

import java.util.Scanner;

public class Jiayan {
	static Scanner input; 
	static String user;
	static int lineCount;
	static boolean inLoop;
	static String response;
	static Topic school;
	
	public static void main(String[] args) {
		createTopics();
		promptName();
		talkForever();
		}
	private static void promptName() {
		print("Hello Human, I am a board covered with semiconductors and other such "
				 + "electronic components. What is your name?");
		user = input.nextLine();
		print("Okay I will call you " + user + " until you terminate me.");
	}
	public static void talkForever()
	{
		inLoop = true;
		while (inLoop) 
		{
			print("Greetings!" + user + ", how are you?");
			response = getInput();
			if(findKeyword(response,"good", 0) )
			{
				print("I'm so happy you're good");
				
			}
			else if (response.indexOf("school")>=0)
			{
				inLoop = false;//exit this loop
				school.talk();
			}
			else 
			{
				print("I do not understand you.");
			}
		}
	}
	public static boolean findKeyword(String searchString, String key, int startIndex) {
		// TODO Auto-generated method stub
		String phrase = searchString.trim();
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		int psn = phrase.indexOf(key);
		while(psn >= 0){
			String before = " ";
			String after = " ";
			
			if(psn +key.length() <phrase.length())
			{
				after = phrase.substring(psn+key.length(), psn+key.length()+1).toLowerCase();
			}
			
			if(psn>0)
			{
				before = phrase.substring(psn-1, psn).toLowerCase();
			}
			
			if(before.compareTo("a") < 0 && after.compareTo("a") <0)
			{
				return true;
			}
			
			psn = phrase.indexOf(key, psn+1);
		}
		
		return false;
	}
	private static void promptInput() {
		String userInput = input.nextLine();
		print(user);
		print("You typed" + userInput);
	}
	public static String getInput()
	{
		return input.nextLine();
	}
	public static void print(String s)
	{
		//create a multi-line string
		String printString = "";
		int cutoff = 35;
		//check if there are words to add
		//
		while(s.length()>0)
		{
			String currentLine = "";
			String nextWord = "";
			//while the current line and next word are less than the cutoff AND there r 
			//still words to add, do the following loop
			while(currentLine.length() + nextWord.length() <= cutoff && s.length()>0)
			{
				//add next word to line
				currentLine += nextWord;
				//remove that word
				s = s.substring(nextWord.length());
				int endOfWord = s.indexOf(" "); 
				//check if this is the last word 
				if(endOfWord == 1)
				{
					endOfWord = s.length() -1 ;
				}
				nextWord = s.substring(0, endOfWord+1); //+1 to include space
			}
			
			printString += currentLine + "\n";
		}
		
		System.out.println(printString);
		
	}
	public static void createTopics() {
		input = new Scanner(System.in);
		school = new School();
		
	}

}


