package array;

public class DemoProblems {
	
static int [] fiftyNums = new int [50];
static int [] randomInts = new int [30];
static int [] diceArr = new int [10000];
static int [] results = new int [11];
	public static void main(String[] args) {
		//fillFiftyArray(fiftyNums);
		//printFiftyArray(fiftyNums);
	//	fillRanIntArr(randomInts);
	//	printRanIntArr(randomInts);
		fillDiceArray(diceArr);
		printDiceArray(diceArr);
		
	}
	private static void printFiftyArray(int [] fiftyNums) 
	{
		for(int i:fiftyNums)
		{
			System.out.println(i);
		}
	}
	private static void fillFiftyArray(int [] fiftyNums)
	{
		for(int index=0; index < fiftyNums.length; index++)
		{
			fiftyNums[index]=index+1;
		}
	}
	private static void fillRanIntArr(int [] randomInts)
	{
		for(int index=0; index < randomInts.length; index++)
		{
			int ranInt = (int)(100*Math.random())+1;
			randomInts[index] = ranInt;
		}
	}
	private static void printRanIntArr(int [] randomInts)
	{
		for(int i:randomInts)
		{
			System.out.println(i);
		}
	}
	private static void fillDiceArray(int []diceArr)
	{
		for(int index = 0; index<diceArr.length; index++)
		{
			int ranInt1 = (int)(6*Math.random())+1;
			int ranInt2 = (int)(6*Math.random())+1;
			int totalNum = ranInt1+ranInt2;
			diceArr[index] = totalNum;
		}
		for(int d = 0; d<diceArr.length; d++)
		{
			results[diceArr[d]-2]++;
		}
	}

	private static void printDiceArray(int [] arr)
	{
		for(int i=0; i<arr.length;i++)
		{
			System.out.println(i+1+"is rolled" +((double)arr[i]/diceArr.length+100)+" % of the time.");
		}
	}
	private static void fillDeckOfCards()
	{
		String suits[] = ["Spades","Clubs","Diamonds","Hearts"];
		String ranks[] = ["","","","","","","","",""];
	}
}



