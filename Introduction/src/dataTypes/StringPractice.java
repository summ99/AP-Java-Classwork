package dataTypes;

import java.util.Scanner;

public class StringPractice {
	static Scanner input; 
	static String user;
	static int lineCount;
	public static void main(String[] args) {
		createAScanner();
		lineCount = 0;
		demonstrateStringMethods();
		print("Try inputting a string");
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
		while (true) 
		{promptInput();}
	}
	private static void promptInput() {
		String userInput = input.nextLine();
		print(user);
		print("You typed" + userInput);
	}
	public static void print(String s)
	{
		lineCount++;
		System.out.println("Line# " + lineCount + s);
		
	}
	public static void createAScanner() {
		input = new Scanner(System.in);
		
	}
	public static void demonstrateStringMethods()
	{
		//String text = new String("Hello World");
				String text1 = "Hello World";
				String text2 = "Hello ";
				String text3 = "World";
				if (text1.equals(text2+text3))
				{
					System.out.println("equal");
				}
				System.out.println(text1);
				System.out.println(text2+text3);
				String word1 = "Ardvark";
				String word2 = "Zyzzyva";
				if(word1.compareTo(word2)  < 0)
				{
					System.out.println("Word1 is before word2");
				}
	}
}
