//Tiffany Zhong
//tjz2105
//creates a card object

public class Card implements Comparable<Card>{
	
    private int suit; //use integers 1-4 to encode the suit
    private int rank; //use integers 1-13 to encode the rank
	
    public Card(int s, int r){ 
    //make a card with suit s and value v
        this.suit = s;
	this.rank = r;
	}
	
    public int compareTo(Card c){
    //use this method to compare cards so they 
    //may be easily sorted
        Card other = c;
	int result = 0;
	if(this.rank < other.rank){
	    result = -1;
	}

	else if(this.rank > other.rank){
	    result = 1;
	}
	
        else if(this.suit > other.suit){
	    result = 1;
	}

	else{
	    result = -1;
	}

        return result;
	}
	
    public String toString(){
    //use this method to easily print a Card object
	String name = "";
	if(rank == 1){
	    name = "ace";
	}
		
        else if(rank == 11){
	    name = "jack";
	}

	else if(rank == 12){
	    name = "queen";
	}

	else if(rank == 13){
            name = "king";
	}

	else{
            name = Integer.toString(rank);
	}

	name += suitName();
	return name;
    }
	
    //needed to make toString method shorter, get string for suit & add to rank
    private String suitName(){
        String name = "";
	if(suit ==1){
	    name += " of clubs";
	}
		
        if(suit ==2){
	    name += " of diamonds";
	}

	if(suit ==3){
	    name += " of hearts";
	}

	if(suit ==4){
	    name += " of spades";
	}

        return name;
    }
	
    public int getRank(){
        return rank;
    }
	
    public int getSuit(){
	return suit;
    }


}
