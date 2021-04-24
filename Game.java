//Tiffany Zhong
//tjz2105
//runs a test game and an actual game, which includes
//having the player bet a certain amount and
//decide which cards to replace and keep as well as
//checking their hand, and dealing payouts accordingly

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
	
    private Player p;
    private Deck cards;
    private double payout;
    private Scanner input;
    	
    public Game(String[] testHand){
    //adds cards entered in command line to player's hand and evaluates it
        payout = 0;
	input = new Scanner(System.in);
        p = new Player();
	cards = new Deck();
		
	for(int i = 0; i < testHand.length; i++){
            if(testHand[i].charAt(0) == 'c'){
	        p.addCard(new Card(1,Integer.parseInt(testHand[i].substring(1))));
	    }

            if(testHand[i].charAt(0) == 'd'){
                p.addCard(new Card(2,Integer.parseInt(testHand[i].substring(1))));
	    }

            if(testHand[i].charAt(0) == 'h'){
	        p.addCard(new Card(3,Integer.parseInt(testHand[i].substring(1))));
	    }
		    
            if(testHand[i].charAt(0) == 's'){
	        p.addCard(new Card(4,Integer.parseInt(testHand[i].substring(1))));
	    }
        }
		
	System.out.println(checkHand(p.getHand()));
	p.emptyHand();
    }
	
    public Game(){
    // This no-argument constructor is to actually play a normal game
        payout = 0;
	input = new Scanner(System.in);
        p = new Player();
	cards = new Deck();
    }
	
    public void play(){
        System.out.println("Welcome to video poker. Your current bankroll: "
						  + p.getBankroll());
	//allow user to stop the game or keep going
	int again = 1;
	while (again == 1){
	//ask user for bet amount, store number
	    System.out.println("Enter a number of tokens to bet (1-5)");
	    p.bets(input.nextDouble());
		
	    dealHand();
			
            //methods allow user to keep/replace cards & then evaluate hand
            swapHand(p.getHand());
            System.out.println(checkHand(p.getHand()));
			
	    //deal out winnings and print bankroll
            p.winnings(payout);
	    System.out.println("your bankroll: " + p.getBankroll());

	    p.emptyHand();
			
            System.out.println("input 1 to play again, 0 to stop");
            again = input.nextInt();
	}
		
	    System.out.println("game ended");
    }
	
    private void dealHand(){
    //shuffle cards & deal 5 cards into player's hand
	cards.shuffle();
	for(int i = 0; i < 5; i++){
	    p.addCard(cards.deal());
	}
    }
	
    private void swapHand(ArrayList<Card> hand){
    //keep or replace cards from user input 
	System.out.println("your hand: " + p.printHand());
	System.out.println("To answer the following questions type 1 for yes, 0 for no");
		
	for(int i = 1; i <= 5; i++){
            System.out.println("Would you like to keep card #" + i + "?");
	    if(input.nextInt() == 0){
	        hand.set(i-1,cards.deal());
	    }
	}
    }

    public String checkHand(ArrayList<Card> hand){
    //sort and print hand
        Collections.sort(p.getHand());
	System.out.println("your sorted hand: " + p.printHand());
		
        //calls helper methods to evaluate hand & determine payout
        if(royalFlush(hand)){
            payout = 250;
            return "royal flush";
	}
		
	else if(straightFlush(hand)){
	    payout = 50;
	    return "straight flush";
	}
		
	else if(fourOfAKind(hand)){
            payout = 25;
	    return "four of a kind";
	}
		
	else if(fullHouse(hand)){
	    payout = 6;
	    return "full house";
	}
		
	else if(flush(hand)){
	    payout = 5;
	    return "flush";
	}
		
        else if(straight(hand)){
            payout = 4;
	    return "straight";
	}
		
	else if(threeOfAKind(hand)){
	    payout = 3;
	    return "three of a kind";
	}
		
	else if(twoPair(hand)){
	    payout = 2;
	    return "two pair";
	}
		
        else if(pair(hand)){
	    payout = 1;
	    return "pair";
	}
		
	else{
            payout = 0;
            return "high card";
	}
    }

    private boolean royalFlush(ArrayList<Card> hand){
    //check for a royal flush
        if(hand.get(0).getRank() == 1 && hand.get(1).getRank() == 10 &&
	    hand.get(2).getRank() == 11 && hand.get(3).getRank() == 12 &&
            hand.get(4).getRank() == 13){
	    return true;
	}

	else{
            return false;
	}
    }
	
    private boolean straightFlush(ArrayList<Card> hand){
    //check for straight flush
        return straight(hand)&&flush(hand);
    }
	
    private boolean fourOfAKind(ArrayList<Card> hand){
    // check for four of a kind
        if(hand.get(0).getRank() == hand.get(3).getRank()||
            hand.get(1).getRank() == hand.get(4).getRank()){
	    return true;
        }

        else{
	    return false;
        }

    }
	
    private boolean fullHouse(ArrayList<Card> hand){
    //check for a full house
	return threeOfAKind(hand)&&twoPair(hand);
    }
	
    private boolean flush(ArrayList<Card> hand){
    //check for a flush
	for(int i = 1; i < 5; i++){
	    if(hand.get(i).getSuit() != hand.get(0).getSuit()){
		return false;
	    }
	}

	return true;
    }
	
    private boolean straight(ArrayList<Card> hand){
    //check for a straight
        if(!pair(hand) && hand.get(4).getRank() - hand.get(0).getRank() == 4){
	    return true;
        }
	    
        else{
	    return false;
	}
    }
	
    private boolean threeOfAKind(ArrayList<Card> hand){
    //check for three of a kind
        if(hand.get(0).getRank() == hand.get(2).getRank() || 
	    hand.get(1).getRank() == hand.get(3).getRank() ||
	    hand.get(2).getRank() == hand.get(4).getRank()){
	    return true;
	}
	
        else{
	    return false;
	}
    }
	
    private boolean twoPair(ArrayList<Card> hand){
    //check for two pairs
	int value = 0;
	boolean twoPair = false;
	boolean pair = false;
	for(int i = 0; i < 4; i++){
	    if(hand.get(i).getRank() == hand.get(i+1).getRank()){
	        if(pair && hand.get(i).getRank() != value){
		    twoPair = true;
		}

		else{
		    pair = true;
		    value = hand.get(i).getRank();
		}
	    }
	}
	return twoPair;
    }
	
    private boolean pair(ArrayList<Card> hand){
    //check for a pair
        for(int i = 0; i < 4; i++){
	    if(hand.get(i).getRank() == hand.get(i+1).getRank()){
	        return true;
	    }
	}
	return false;

    }

}
