package caveExplorer;

import java.util.Scanner;

public class Practice {
	public static String [][] arr2d;
	public static String [][] pic;
	public static int i;
	public static int j;
	public static Scanner in;
	 
	 
	public static void main(String[] args) {
	 arr2d = new String[5][4];
	 pic = new String[5][4];
		for(int row =0; row<arr2d.length;row++)
		{
			 for(int col =0; col<arr2d[0].length; col++)
			 {
				 arr2d[row][col] = "("+row + "), " + "(" +col + ")";
			 }
		}
		//start pos
		i = 2;
		j = 1;
		in = new Scanner(System.in);
		startExploring();
	}
	private static void startExploring() {
		while(true)
		{
			System.out.println("You are in room " + arr2d[i][j]);
			pic[i][j] = " X ";
			printPic(pic);
			System.out.println("What do you want to do?");
			String input = in.nextLine();
			while(!isValid(input))
			{
				System.out.println("Please enter w, a, s, or d.");
				input = in.nextLine();
			}
			interpretInput(input);
		}
		
	}
	private static boolean isValid(String input) {
		String lc = input.toLowerCase();
		String [] keys = {"w","a", "s","d"};
		for(String key :keys)
		{
			if(key.equals(lc))
			{
				return true;
			}
		
		}
		return false;
	}
	private static void interpretInput(String input) {
		int iOrig = i;
		int jOrig = j;
		if(input.equals("w")&&i>0)
		{
			i--;
			
		}
		else 
			if(input.equals("a")&&j>0)
			{
				j--;
				
			}
			else
				if(input.equals("s")&& i+1<arr2d.length)
				{
					i++;
					
				}
				else
					if(input.equals("d")&& j+1<arr2d[0].length)
					{
						j++;
						
					}
	
		if(iOrig == i && jOrig ==j)
		{
			System.out.println("You are on the edge of the universe, you cannot move in that direction");
		}
	}
	
	
	public static void mineSweeper ()
	{
		boolean [][] mines = new boolean [6][6];
		createMines(mines,10);
		String [][] field = new String [mines.length][mines[0].length];
		matchValues(field, mines);
		printPic(field);
	}
	private static void createMines(boolean [][] mines, int numOfMines) {
		while(numOfMines>0)
		{
			int row =(int)(Math.random()*mines.length);
			int col = (int)(Math.random()*mines[0].length);
			if(!mines[row][col] )
			{
				mines[row][col] = true;
				numOfMines--;
			}
		}
		
	}
	private static void matchValues(String[][]field, boolean[][]mines)
	{
		for(int row =0; row<field.length; row++)
		{
			for(int col =0; col<field[0].length; col++)
			{
				if(mines[row][col] )
				{
					field[row][col]="X";
				}
				else
				{
					field[row][col]=countAdjacent(mines, row, col);
				}
			}
		}
	}

	private static String countAdjacent(boolean[][] mines, int r, int c) {
		//r and c represent coordinates of element we are dividing a string for
		int count=0;
		/*loop thru row above to row below
		for(int row =r-1; row<=r+1; row++)
		{
			//loop thru col left thru right
			for(int col = c-1; col<c+1; col++)
			{
				//exclude this element when counting
				if(row !=r && col != c){
					if(row >=0 &&
							row < mines.length&&
							col >= 0 && 
							col < mines[row].length)
				}
			}
		}*/
		//this only checks elements in the 2d array
		/*for(int row = 0; row<mines.length;row++)
		{
			for(int col =0; col<mines[row].length;col++)
			{
				if(Math.abs((row-r)+(col-c))==1 //checks taxi cab distance
						&& mines[row][col])  //true/false
				{
					count++;
				}
			}
				
		}
		//this method is very specific
		*/
		count+=validAndTrue(mines,r-1,c);
		//above
		count+=validAndTrue(mines, r+1, c);
		count+=validAndTrue(mines, r, c+1);
		count+=validAndTrue(mines, r, c-1);
		return count +"";
	}

	private static int validAndTrue(boolean[][] mines, int r, int i) {
		// TODO Auto-generated method stub
		if(r>=0 &&r<mines.length && i>=0 && i<mines[0].length &&mines[r][i]  )
		{
			//checks if true
			return 1;
		}
		else return 0;
	}

	public static void picDrawing()
	{
		String [][] pic = new String [10][12];
		for(int row = 0; row<pic.length; row++)
		{
			for(int col =0; col<pic[row].length; col++)
			{
				pic[row][col] = " ";
				
			}
		}
		pic[1][2] = "O ";
		pic[0][2] = "| ";
		pic[2][2] = "| ";
		pic[1][1] = "- ";			
		pic[1][3] = "- ";
		pic[0][1] = "\\ ";
		pic[2][3] = "\\ ";
		pic[0][3] ="/ ";
		pic[2][1] = "/ ";
		for(int row = 7; row<pic.length; row++)
		{
			for(int col =0; col<pic[row].length; col++)
				{
					pic[row][col] = "M ";
				}
		}
		//top row is underscores
		for(int col =0; col<pic[0].length; col++)
		{	
			pic[0][col]="_ ";
			pic[pic.length-1][col]="_ ";
		}
		for(int row =0;row<pic.length; row++)
		{
			pic[row][0]="|";
			pic[row][pic[0].length-1] = "|";
		}
		printPic(pic);
	}
	public static void printPic(String [][] pic)
	{
		for(int row = 0; row<pic.length; row++)
		{
			for(int col =0; col<pic[row].length; col++)
			{
				
				System.out.print(pic[row][col]);
			}
			System.out.println();
		}
	}

/* hhhhhhwwwwww
	public static void drawMap(int r, int c)
	{
		String [][] map = new String [r][c];
		for( r =0; r<map.length; r++)
		{
			for(c =0; c<map[0].length; c++)
			{
				map[0][col]="_";
				map[map.length-1][c] = "_"
			}
		}
		for()
		printPic(map);
	}
	*/
}
