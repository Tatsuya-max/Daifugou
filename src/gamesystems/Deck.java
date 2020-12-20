package gamesystems;

public class Deck {
  private Card[] deck;
  private int cardsLeft;

  public int getCardsLeft() {return cardsLeft;}

  public Deck() {
    deck = new Card[54];
    cardsLeft = 0;
    for(int suit = 0; suit <= 3; suit++) {
      for(int value = 1; value <= 13; value++) {
        deck[cardsLeft] = new Card(suit,value);
        cardsLeft++;
      }
    }
        deck[52] = new Card(Card.JOKER, 14);
        deck[53] = new Card(Card.JOKER, 14);
  }

  public void shuffle() {
    for(int i = deck.length-1; i >= 0; i--) {
      int rand = (int)(Math.random()*(i+1));
      Card temp = deck[i];
      deck[i] = deck[rand];
      deck[rand] = temp;
    }
    cardsLeft = 54;
  }

  public Card dealCard() {
    if(cardsLeft == 0)
      throw new IllegalStateException("No cards are left int the deck");
    Card temp = deck[deck.length - cardsLeft];
    cardsLeft--;
    return temp;
  }
}
