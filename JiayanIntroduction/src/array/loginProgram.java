package array;

import java.util.Scanner;

public class loginProgram {
	static Scanner input = new Scanner(System.in);
	public static String waitForEntry()
	{
		return input.nextLine();
	}
	//1 point for private 
	//1 point for declaration of data type:String
	private static String username = "test_user";
	private static String password = "test";
	//1 point correct method header
	public static void main(String[] args) {
		//1 chance to enter username
		if(correctuser())
		{
			askPassword();
		}
		else
		{
			System.out.println("Wrong username");
		}

	}
	private static void askPassword() {
		boolean inLoop = true;
		int remainingTries = 3;
	
		while(inLoop)
		{
			System.out.println("Enter password.");
			String entry = waitForEntry();
			if(entry.equals(password))
			{
				System.out.println("You have logged on!");
				inLoop = false;
			}
			else
			{
				remainingTries--;
				if(remainingTries == 0)
					{
						System.out.println("Invalid password");
						inLoop = false;
					}
					else
					{
						System.out.println("Remaining tries: "+ remainingTries);
					}
			
			}
		}
		
	}
	private static boolean correctuser() {
		System.out.println("Enter username");
		//return true or false is actually not necessary
		if(waitForEntry().equals(username))
		{
			return true;	
		}
		else
			return false;
	}

}
