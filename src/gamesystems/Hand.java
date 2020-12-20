package gamesystems;

import java.util.ArrayList;

public class Hand {
  private ArrayList<Card> hand;

  public Hand() {
    hand = new ArrayList<Card>();
  }

  public void clearHand() {
    hand.clear();
  }

  public void addCard(Card c) {
    if(c == null)
      throw new NullPointerException("Can't add a null card to a hand.");
    hand.add(c);
  }

  public void removeCard(Card c) {
    hand.remove(c);
  }
  public void removeCard(int position) {
    if(position < 0 || position >= hand.size() )
      throw new IllegalArgumentException("Position does not exist in hand:" + position);
    hand.remove(position);
    }

  public int getCardCount() {return hand.size();}

  public void sortByValue() {
    ArrayList<Card> newHand = new ArrayList<>();
    ArrayList<Card> tempList = new ArrayList<>();

    while(hand.size() > 0) {
      int pos = 0;
      Card c = hand.get(0);
      for(int i = 1; i < hand.size(); i++) {
        Card c1 = hand.get(i);
        if(c1.getValue() < c.getValue() ||
           c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()){
          pos = i;
          c = c1;
        }
      }
      hand.remove(pos);
      if(c.getValue() > 2 && c.getSuit() != Card.JOKER) {
        newHand.add(c);
      }else{
        tempList.add(c);
      }
      if(hand.size() == 0) {
        for(Card temp : tempList) {
          newHand.add(temp);
        }
        tempList.clear();
      }
    }
        hand = newHand;
  }

  public Card getCard(int theNum) { return hand.get(theNum); }

  public void checkHand() {
    for(Card c : hand) {
      System.out.print(c);
    }
    System.out.println();
  }

  public void selectCard() {
  }
}
