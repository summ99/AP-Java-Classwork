package caveExplorer;

public class Practice {

	public static void main(String[] args) {
		boolean [][] mines = new boolean [6][6];
		createMines(mines,10);
		String [][] fields = new String [mines.length][mines[0].length];
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
		//loop thru row above to row below
		for(int row =r-1; row<=r+1; row++)
		{
			//loop thru col left thru right
			for(int col = c-1; col<c+1; col++)
			{
				if(row!=r&&col!=c)
				{
					if(row>=0 && row< mines.length&&cols>=0 &&cols<mines[0].length)
				}
			}
		}
		return null;
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
		/*int ranBirdRow = (int)(Math.random()*9);
		int ranBirdCol = (int)(Math.random()*4);
		pic[ranBirdRow][ranBirdCol]="(=}=>";
		for(int row =0; row<2;row++)
		{
			int ranIncr = (int)(Math.random()*2+1);
			for(int ranCol = (int)(Math.random()*4+1); ranCol<pic[row].length; ranCol+=ranIncr)
			{
				pic[row][ranCol] = "~ ";
			}
		}*/
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
}
