package chatbot;

import java.util.Scanner;

public class Jiayan {
	static Scanner input; 
	static String user;
	static int lineCount;
	static boolean inLoop;
	static String response;
	static Topic school;
	static Topic like;
	
	public static void main(String[] args) {
		createTopics();
		promptName();
		promptInput();
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
			if(findKeyword(response,"good", 0) != -1)
			{
				print("I'm so happy you're good");
				
			}
			else if (findKeyword(response, "school", 0)>=0)
			{
				inLoop = false;//exit this loop
				school.talk();
			}
			else if (findKeyword(response, "like", 0)>=0)
			{
				inLoop = false;
				like.talk();      
			}
			else 
			{
				print("I do not understand you.");
			}
		}
	}
	public static int findKeyword(String searchString, String key, int startIndex) {
		String phrase = searchString.trim();
		//trim cuts off spaces at the beginning n end but not in between words
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		//System.out.println("the phrase is" + phrase);
		//System.out.println("the key is" + key);
		//string n key converted to lower case
		int psn = phrase.indexOf(key);
		//System.out.println("the position found is" + psn);
		//find position of keyword
		//while loop only runs when there is a keyword in the string
		while(psn >= 0){
			String before = " ";
			String after = " ";
			//if the phrase does not end with this word
			if(psn +key.length() <phrase.length())
			{
				after = phrase.substring(psn+key.length(), psn+key.length()+1).toLowerCase();
			}
			// if the phrase does not begin with this word
			if(psn>0)
			{
				before = phrase.substring(psn-1, psn).toLowerCase();
				//System.out.println("the word before" + key +"is" + before);
			}
			//if no word found yet
			if(before.compareTo("a") < 0 && after.compareTo("a") <0)
			{
				//System.out.println("key was found at" + psn);
				if(noNegations(phrase, psn))
				return psn;
			}
			
			psn = phrase.indexOf(key, psn+1);
//			System.out.println("the key was not found");
		}
		
		return -1;
	}
	
	/*helper method; contributes functionality to another method to another method; are 
	very common when u need to smtg repeatedly; help make smtg readable
	this method is private bc it is only used by the method it is helping*/
	private static boolean noNegations(String phrase, int index)
	{
		//check for "no "(3 chars bc there is a space)
		//check to see if there is space for the word no to be in front of the index
		if(index-3 >= 0 && phrase.substring(index-3, index).equals("no "))
		{
			return false;
		}
		//check for "not"
		if(index-4 >= 0 && phrase.substring(index-4, index).equals("not "))
		{
			return false;
		}
		//check for never
		if(index-6 >= 0 && phrase.substring(index-6, index).equals("never "))
		{
			return false;
		}
		//check for "n't"
		if(index-4 >= 0 && phrase.substring(index-4, index).equals("n't "))
		{
			return false;
		}
		return true;
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
		like = new JiayanLike();
		
	}

}


