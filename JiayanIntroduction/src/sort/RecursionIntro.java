package sort;

public class RecursionIntro {

	public static void main(String[] args) {
		hanoi(3,"A","B","C");
		}
	public static void hanoi(int numDiscs, String from, String mid, String to)
		{
			if(numDiscs<2)
			{
				print("Move from"+ from + " to " + to);
			}
			else
			{
				
				//move all but last one to B
				hanoi(numDiscs-1,from,to,mid);
				//move last one to C
				hanoi(1,from,mid,to);
				hanoi(numDiscs-1,mid,from,to);
			}
		}
	private static int moveCount=1;
		private static void print(String string) {
		System.out.println("Move# " + moveCount+ "" + string);
		moveCount++;
	}
		
		
		
		/*System.out.println("Using a for loop...");
		for(int i=0;i<5; i++)
		{
			System.out.println("Hello everyone!");
		}
		System.out.println("Using recursion...");
		int numTimes=5;
		forLoop(numTimes,new Action() {

			public void act() {
				System.out.println("Hello everyone!");
				
			}
		});
	}
	private static void forLoop(int numTimes, Action action) {
		if(numTimes <2)
		{
			action.act();
		}
		else
		{
			action.act();
			forLoop(numTimes-1,action);
		}*/
}
