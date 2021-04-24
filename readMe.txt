Tiffany Zhong
tjz2105

For the Card, Deck, and player classes, I filled in the methods provided as Professor Cannon told us to 
and added a few more. I chose to use the removeCard method to empty the hand in another method in the player
class instead of to swap cards since it seemed easier to use the set method.

In my first game constructor (for testing the hands), I used a for loop to iterate through the string arrays
entered in the command line and the Integer.parseInt method to turn the substring into a card that I could add
to the player's hand. I initialized the instance variables needed to actually play the game and emptied
the hand after evaluating it since I saw the tester class calls the play method afterwards.

In the play method, I used a while loop to allow the user to play multiple rounds and within it I called various
helper method to keep the play method short and readable. First, I printed a welcome statement and the player's 
initial bankroll, which I set to 100, and asked the user to make their bet, which I then subtracted from their bankroll
by calling the bets method in player. Then I called helper methods to deal the player 5 cards, allow them to 
swap cards, evaluate the hand and print the result, deal out winnings, and then empty the hand afterwards. Finally, I 
allowed the user to choose whether or not to play again.

My checkHand method uses a series of booleans to determine which result to print and how to adjust the bankroll 
accordingly, which is essentially what Professor Cannon told us to do in class. I chose to use an instance variable
to keep track of the payout so that I would not have to call the bankroll method in every if statement. I also made
an instance variable for a scanner so that I would not have to initalize one every time I took in a user input.