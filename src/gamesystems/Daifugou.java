package gamesystems;

public class Daifugou{
  static Player[] players = new Player[4];
  static Deck deck = new Deck();

  public static void main(String[] args) {
    boolean playAgain = false;

    do{
      System.out.println("ゲームを開始します");
      play();
    }while(playAgain);
  }

  public static void play() {
    int turn;
    Card currentCard;
    Card nextCard;

    for(int i = 0; i < 4; i++) {
      players[i] = new Player(i, new Hand());
    }

    int loopStart = (int)(Math.random()*4);
    System.out.println("初めのプレイヤーは" + players[loopStart] + "です");

    for(int i = 0; i < 3; i++) {
      deck.shuffle();
    }
    System.out.println("デッキをシャッフルしました、カードを配布します");
    turn = 0;
    while(deck.getCardsLeft() > 0) {
      players[(loopStart+1+turn) % players.length].getHand().addCard(deck.dealCard());
      turn++;
    }

    System.out.println("配布が完了しました、カードを整理します");
    players[0].getHand().sortByValue();
    players[0].getHand().checkHand();
    System.out.println();

    do {
      turn = 0;
      Player player = players[(loopStart+turn) % players.length];
      if(player.getHand().getCardCount() != 0) {
        System.out.println( player + "からターンを初めます");
        if(player != players[0]) {
          nextCard = player.getHand().getCard(0);
          player.getHand().removeCard(nextCard);
          System.out.println(player + "は" + nextCard + "を出した");
          currentCard = nextCard;
        }else{
          System.out.println("手札：" + player.getHand().getCardCount() + "枚");
          player.getHand().checkHand();
          System.out.println("どのカードを出しますか？");
          nextCard = player.getHand().selectCard();
          player.getHand().removeCard(nextCard);
          System.out.println(player + "は" + nextCard + "を出した");
          currentCard = nextCard;
        }
        if(player.getHand().getCardCount() == 0) {
          System.out.println(player + "は手札を出しきった");
        }
      }else{
        turn++;
        continue;
      }
      //初手以降
      while(!player.hasPassed()) {
        if(player.getHand().getCardCount() != 0) {
          System.out.println( player + "のターンです");
          if(player != players[0]) {
            nextCard = player.getHand().getCard(0); //AI実装
            if(currentCard.getValue() > nextCard.getValue()) {
              currentCard = nextCard;
            }
            player.getHand().removeCard(nextCard);
            System.out.println(player + "は" + currentCard + "を出した");
          }else{
            System.out.println("手札：" + player.getHand().getCardCount() + "枚");
            player.getHand().checkHand();
            System.out.println("どのカードを出しますか？");
            player.getHand().selectCard();
          }
          if(player.getHand().getCardCount() == 0) {
            System.out.println(player + "は手札を出しきった");
          }
          turn++;
        }else{
          turn++;
          continue;
        }
      }
    }while(players[0].getHand().getCardCount() != 0);
  }
}