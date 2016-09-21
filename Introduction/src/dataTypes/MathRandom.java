package dataTypes;

import java.util.Random;

public class MathRandom {

	public static void main(String[]args) {
		int[] results = new int [6]; // = array of 6 0s
		int totalRolls = 10000;
		for (int index=0; index<totalRolls; index++)
		{
			int roll = rollFairDie();
			System.out.println("Roll#" + (index+1) + "Die is " + roll);
			results[roll-1]++;
		}
		for(int i=0; i<6; i++)
			
		{
			double percentage = (double)(results[i]/totalRolls) ;
			System.out.println((i+1)+ "was rolled" + percentage  + "%");
			
		}
	}
	public static int rollFairDie()
	{
		double rand = Math.random();//creates random double btween 0-1 exclusive
		int roll =(int)(6 * rand); // [0-5] this is what above code does
		return roll+1;
	}
//public static int rollUnfairDie()
//{
//		double rand = Math.random();
//		double rand2 = Math.random();
//		int roll =(int)(6 * rand);
//		int roll2 = (int)(rand2)+1;
//		if(roll2<0.5)
//			return 6;
//		else 
//			return roll;
//		
//		
//	}

