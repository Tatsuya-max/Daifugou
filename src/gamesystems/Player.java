package gamesystems;

public class Player {
  private int id;
  private int rank;
  private Hand hand;
  private boolean passed = false;

  public static final int DAIFUGOU = 1;
  public static final int FUGOU = 2;
  public static final int HINMIN = 3;
  public static final int DAIHINMIN = 4;

  public int getRank() {return rank;}
  public Hand getHand() {return hand;}
  public boolean hasPassed() {return passed;}


  public Player(int theId,Hand theHand) {
    id = theId;
    hand = theHand;
  }

  public String getIdAsString() {
    if(id == 0) {
      return "あなた";
    }else{
      return "Player" + id;
    }
  }

  public String getRankAsString() {
    switch(rank) {
    case DAIFUGOU:	return "(大富豪)";
    case FUGOU:		return "(富豪)";
    case HINMIN:	return "(貧民)";
    case DAIHINMIN:	return "(大貧民)";
    default:		return "";
    }
  }

  public String toString() {
    return getIdAsString() + getRankAsString();
  }
  public Card playCard(Card c) {
    getHand().removeCard(c);
    return c;
  }

}
