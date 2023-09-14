import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;

/** Play a simple game like Go Fish!
 * 
 * @author Tristan Dow
 * @version 1.0
 *
 */
public class GoFish_TristanDow {

	/** Each player gets 7 cards initially
	 * 
	 */
	public static int STARTING_HAND_SIZE = 7;
	
	/** Play a game of Go Fish!  The rules are below.
	 * A regular deck of cards consists of 52 cards.  
	 * There are four suits and thirteen card ranks (Ace, 2, 3,…10, Jack, Queen, and King). 
	 * We’re going to simplify our cards.  The cards will have ranks from 1 to 13, 
	 * and each rank will have identical cards.  This removes suit from the game.
	 * 
	 * The computer deals seven cards to the human and the computer from a shuffled deck. The 
	 * remaining cards are shared in a pile.
	 * 
	 * The human player should play first. The human asks the computer for all its card(s) 
	 * of a particular rank that is already in his or her hand. 
	 * For example Mayra may ask, "Computer, do you have any threes?" Mayra must have at 
	 * least one card of the rank she requested in her hand. The computer must hand over 
	 * all cards of that rank. If the computer has no cards of that rank, 
	 * Mayra is told to "Go fish," and she draws a card from the pool and places 
	 * it in her own hand. When any player at any time has all four cards of one rank,
	 *  it forms a book, and the cards must be removed from the hand and placed face 
	 *  up in front of that player. 
	 *  
	 *  If the player has no cards in their hand, they may not request cards form the other 
	 *  player, they just draw a card.
	 *  When the pile is empty, no cards are drawn, but the player still gets to ask for cards 
	 *  following the same rules.
	 *  
	 *  The computer is not allowed to examine or deduce the human player’s cards while 
	 *  playing the game. The computer should randomly pick one card from their hand to request.  
	 *  This means that the computer is not being strategic at all and will 
	 *  probably lose most of the time (unless the player really stinks at Go Fish!). 
	 *  
	 *  When all sets of cards have been laid down, the game ends. The player with the 
	 *  most cards in piles wins.
	 *  
	 *  The game is easier to play if the cards are printed out in sorted order.  
	 *  This also uses a method in the Collections class, which meets a learning objective.

	 * @param args There are no command line arguments.
	 */
	public static void main(String[] args) 
	{
		// Creates deck of cards
		ArrayList<Integer> pool=createDeck();
		Scanner input = new Scanner(System.in);
		
		// Shuffle deck
		shuffleDeck(pool);
		
		playOneGame(pool, input);
	}
	
	/** Play one full game of Go Fish!. 
	 * 
	 * @param pool The deck of cards, already shuffled.
	 * @param input Attached to the keyboard to interact with the user.
	 */
	public static void playOneGame(ArrayList<Integer> pool, Scanner input)
	{
		ArrayList<Integer> computer = new ArrayList<Integer>();
		ArrayList<Integer> person = new ArrayList<Integer>();
		ArrayList<Integer> computerPile = new ArrayList<Integer> ();
		ArrayList<Integer> personPile = new ArrayList<Integer>();

		// Deal cards
		dealHands(pool, person, computer);
		// Show the person their starting hand
		showCards(person);
	
		
		// Play the game
		while (computerPile.size() + personPile.size() < 52 || !pool.isEmpty())
		{
			// Let the person play first
			// show the person their cards
			if (!person.isEmpty())
			{
				System.out.println("What card do you want?");
				int card = input.nextInt();
				
				// Play one turn with the person doing the choosing
				playOneTurn(card, person, computer, personPile, computerPile, pool);
			}
			else
			{
				// Let the player draw from the deck
				drawCard(pool,person);
			}
			
			showGameState(person, computerPile, personPile);
			
			// Now it is the computer's turn
			// Randomly choose a card
			if (!computer.isEmpty())
			{
				int card = computer.get((int)(Math.random()*computer.size()));	
				System.out.println("Do you have any "  + card + "'s ?");
				
				// Play one turn with the computer doing the choosing
				playOneTurn(card, computer, person, computerPile, personPile, pool);
			}
			else if (!pool.isEmpty())
			{
				// Let the computer draw from the deck
				drawCard(pool,computer);
			}
			
			showGameState(person, computerPile, personPile);
		}
		
		// Determine the winner and tell the user--remember ties are possible
		if(personPile.size() < computerPile.size())
		{
			System.out.println("The player has won!");
		}
		else if(computerPile.size() > personPile.size())
		{
			System.out.println("The computer has won!");	
		}
		else
		{
			System.out.println("It's a tie!");
		}
			
	}
	
	
	/** Show the user their cards and their pile and the computer's pile.
	 * 
	 * @param person The cards in the person's hand.
	 * @param computerPile The pile of completed books for the computer.
	 * @param personPile The pile of completed books for the person.
	 */
	public static void showGameState(ArrayList<Integer> person, ArrayList<Integer> computerPile,
			ArrayList<Integer> personPile)
	{
		System.out.println("Here are your cards");
		showCards(person);
		System.out.println("Here is your pile");
		showCards(personPile);
		System.out.println("Here is my pile");
		showCards(computerPile);
	}
	
	/** Play one turn of Go Fish!. The chooser is the person who is selecting a card from the
	 * other person's hand.  This will alternate between the person and the computer.
	 * @param card The card that has been selected.
	 * @param chooser The hand for the player who is currently choosing.
	 * @param chosen The hand for the player who is being asked for cards.
	 * @param chooserPile The pile for the player who is currently choosing.
	 * @param chosenPile The pile for the player who is being asked for cards.
	 * @param pool The deck of cards that have not yet been distributed, already sorted.
	 */
	public static void playOneTurn(int card, ArrayList<Integer> chooser, ArrayList<Integer> chosen,
			ArrayList<Integer> chooserPile, ArrayList<Integer> chosenPile, ArrayList<Integer> pool)
	{
		if (chosen.contains(card))
		{
			// Chosen gives cards to Chooser
			transferCards(card, chooser, chosen);
			// If there is a set of four matching cards, put them on the table
			for(int i = 1; i <= 13; ++i)
			{
				if(Collections.frequency(chooser, new Integer(card)) == 4)
				{
					transferCards(i, chooser, chooserPile);
				}
			}
			
			
		}
		else
		{
			System.out.println("Go fish!");
			
			// Draw a card by removing it from the pool and putting it in the chooser's hand
			drawCard(pool, chooser);
			// If there is a set of four matching cards, put them on the table
			for(int i = 1; i <= 13; ++i)
			{
				if(Collections.frequency(chooser, new Integer(card)) == 4)
				{
					transferCards(i, chooser, chooserPile);
				}
			}
		}
	}
	
	/** Transfer all cards of rank card from the source to the destination.
	 * 
	 * @param card The rank of the selected card.
	 * @param destination The hand that will receive the cards.
	 * @param source The hand that will lose the cards.
	 */
	public static void transferCards(int card, ArrayList<Integer> destination, ArrayList<Integer> source)
	{
		while (source.contains(card))
		{
			destination.add(card);
			source.remove(new Integer(card)); // this is that tricky thing from the handout
		}
	}
	
	/** Deal two equal size hands, one to each player.
	 * 
	 * @param deck The deck of cards that should be dealt. These cards should have been shuffled.
	 * @param hand1 The first player.
	 * @param hand2 The second player.
	 */
	public static void dealHands(ArrayList<Integer> deck, ArrayList<Integer> hand1, ArrayList<Integer> hand2)
	{
		for(int i = 0; i < 7; ++i)
		{
			drawCard(deck, hand1);
		}
		for(int i = 0; i < 7; ++i)
		{
			drawCard(deck, hand2);
		}
	}
	
	/** Draws a card from the deck to a hand.
	 * 
	 * @param deck The deck to draw from
	 * @param hand The hand to draw to
	 */
	public static void drawCard(ArrayList<Integer> deck, ArrayList<Integer> hand)
	{
		hand.add(deck.get(0));
		deck.remove(0);
	}
	
	/** Build a deck of 52 cards, 4 of each rank from 1 to 13
	 * 
	 * @return The deck of cards.
	 */
	public static ArrayList<Integer> createDeck()
	{
		ArrayList<Integer> temp = new ArrayList<Integer>(52);
		// Populating deck of cards
		for(int i = 0; i < 4; ++i)
		{
			for(int j = 1; j <= 13; ++j)
				{
					temp.add(j);
				}
		}
		return temp;
	}
	

	/** Show all of the cards is any given pack, hand, deck, or pile.
	 * 
	 * @param cards The cards to be displayed
	 */
	public static void showCards(ArrayList<Integer> cards)
	{
		// Sort the cards to make it easier for the user to know what they have
		sortHand(cards);
		
		for (Integer i: cards)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	/** Shuffles a full deck of 52 cards.
	 * 
	 * @param deck The deck to shuffle
	 */
	public static void shuffleDeck(ArrayList<Integer> deck)
	{
		Random randomGen = new Random();
		int temp = 0;
		int indexToSwap;
		int deckSize = deck.size()-1;
		for(int i = 0; i < deck.size(); ++i)
		{
			indexToSwap = randomGen.nextInt(deckSize);
			temp = deck.get(indexToSwap);
			deck.set(indexToSwap, deck.get(i));
			deck.set(i,temp);
		}
	}
	
	public static void sortHand(ArrayList<Integer> hand)
	{
		           
		Collections.sort(hand);
	}

}
