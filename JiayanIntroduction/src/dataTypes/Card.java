package dataTypes;

public class Card {
	
	public static void main(String[] args) 
	{
		String[] suits = {"Spades", "Hearts","Clubs", "Diamonds"};
		String[] cards = {"Ace","Two","Three","Four","Five","Six","Seven","Eight",
				"Nine","Ten","Jack","Queen","King",};
		int numCards = 5;
          for (int i=1; i<=numCards; i++)

             {
	          int ranSuit = (int) (Math.random() * suits.length);
	          int ranCard = (int) (Math.random() * cards.length);
              System.out.println("This is the "+ cards[ranCard] + " of " + suits[ranSuit]);

             }
	}
	
}
