//Tiffany Zhong
//tjz2105
//creates a array object for a deck of cards
//and the ability to shuffle and deal 

public class Deck {
	
    private Card[] cards;
    private int top; //the index of the top of the deck

	
    public Deck(){
    //make a 52 card deck here
	int counter = 0;
	top = 0;
	cards = new Card [52];
	//nested for loops to populate array with suits & ranks
	for(int j = 1; j <= 13; j++){
	    for(int i = 1; i <= 4; i++){
	        cards[counter]= new Card(i, j);
		counter++;
	    }
			
	}
	    shuffle();
	}
	
    public void shuffle(){
    //shuffle the deck here
	int shuffleCard1 = 0;
	int shuffleCard2 = 0;
	for(int i = 0; i < 1000; i++){
	    shuffleCard1 = (int)(Math.random()*52);
	    shuffleCard2 = (int)(Math.random()*52);
			
	    Card temp = cards[shuffleCard2];
	    cards[shuffleCard2] = cards[shuffleCard1];
	    cards[shuffleCard1] = temp;
	}
    }
	
    public Card deal(){
    //deal the top card in the deck
    //check if top variable exceeds number of cards, shuffle deck if it does
	if(top > 51){
	    shuffle();
	    top = 0;
	}

	top++;
	return cards[top - 1];
    }
	


}
