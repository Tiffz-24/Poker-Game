//Tiffany Zhong
//tjz2105
//creates a player object that keeps track of their
//hand and bankroll

import java.util.ArrayList;
public class Player {
	
    private ArrayList<Card> hand; //the player's cards
    private double bankroll;
    private double bet;
		
    public Player(){		
        bankroll = 100;
	bet = 0;
	hand = new ArrayList<Card>();
	}

        public void addCard(Card c){
	//add the card c to the player's hand
	    hand.add(c);
	}

	public void removeCard(Card c){
	//remove the card c from the player's hand
	    hand.remove(c);
    }
		
	public void bets(double amt){
	//player makes a bet
	    bet = amt;
	    bankroll -= bet;

	}

	public void winnings(double odds){
	//adjust bankroll if player wins
            bankroll += (bet*odds);
	}

	public double getBankroll(){
	//return current balance of bankroll
	    return bankroll;
	}

	public ArrayList<Card> getHand(){
	    return hand;
	}
	
	public String printHand(){
	//prints the player's hand
	    String playerHand = "";
	    for(Card each: hand){
	        playerHand += each.toString() + "\n\n";
	    }
	    return playerHand;
	}
	
	public void emptyHand(){
	    for(int i = 0; i < 5; i++){
	        removeCard(hand.get(0));
	    }

	}
}


