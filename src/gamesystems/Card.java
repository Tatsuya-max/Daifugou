package gamesystems;

public class Card {
  private final int suit;
  private final int value;

  public static final int SPADES = 0;
  public static final int HEARTS = 1;
  public static final int DIAMONDS = 2;
  public static final int CLUBS = 3;
  public static final int JOKER = 4;

  public static final int ACE = 1;
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;

  public Card(int theSuit, int theValue) {
    if(theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && theSuit != CLUBS && theSuit != JOKER) {
      throw new IllegalArgumentException("Illegal playing card suit");
    }
    if(theValue < 1 || theValue > 13 && theSuit != JOKER) {
      throw new IllegalArgumentException("Illegal playing card value");
    }
    suit = theSuit;
    value = theValue;
  }

  public int getSuit() {return suit;}
  public int getValue() {return value;}

  public String getSuitAsString() {
    switch(suit) {
      case SPADES:	return "♠";
      case HEARTS:	return "♥";
      case DIAMONDS:	return "◆";
      case CLUBS:		return "♣";
      default: 		return "JOKER";
    }
  }
  public String getValueAsString() {
    if(suit == JOKER) {
      return "";
    }else{
      switch(value) {
      case ACE:	return "A";
      case 2:		return "2";
      case 3:		return "3";
      case 4:		return "4";
      case 5:		return "5";
      case 6:		return "6";
      case 7:		return "7";
      case 8:		return "8";
      case 9:		return "9";
      case 10:	return "10";
      case JACK:	return "J";
      case QUEEN:	return "Q";
      default:	return "K";
      }
    }
  }

  public String toString() {
    return "[" + getSuitAsString() + getValueAsString() + "]";
  }
}
