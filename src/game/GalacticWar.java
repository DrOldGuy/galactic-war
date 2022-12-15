package game;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * This class contains the entry point for the Java application (the main
 * method). It starts and plays the game of Galactic War. This game is an
 * abbreviated version of the game of War. The game of War is a game between two
 * players that can go on for days. Galactic War is similar but there is no
 * endless drawing of cards, reshuffling the deck, etc. Here are the rules of
 * Galactic War:
 * <ul>
 * <li>Two players are randomly selected from a list of player names.
 * <li>A card deck is generated and shuffled.
 * <li>The players are dealt cards from the deck, which go into their hands.
 * <li>Players draw the top card from their hand and compare the card rank. The
 * player with the highest card gets a point. If there's a tie, neither player
 * gets a point.
 * <li>After all the cards have been played, the winner is announced. If the
 * players both have the same number of points, a tie is announced.
 * </ul>
 * 
 * @author Promineo
 *
 */
public class GalacticWar {

  /*
   * This is the list of player names. This list never changes. Instead, it is
   * copied when names are needed.
   */
  private final List<String> members = List.of("Bob", "Jane");

  /* This allows the game to generate two random player names. */
  private Random random = new Random();

  /*
   * Create the players as instance variables. This allows all methods to access
   * them.
   */
  private Player player1;
  private Player player2;

  /* Store the deck as an instance variable */
  private Deck deck;

  /**
   * This method is the entry point for the Java application. It starts the
   * game. This method creates a GalacticWar object and calls the run method on
   * the object. This makes the move from a static method to an instance method
   * so that the methods can access the instance variables.
   * 
   * @param args
   */
  public static void main(String[] args) {
    new GalacticWar().run();
  }

  /**
   * This method creates the players, creates and shuffles the deck, and plays
   * the game.
   */
  private void run() {
    selectPlayers();
    createAndShuffleDeck();
    dealTheCards();
    playTheGame();
    declareWinner();
  }

  /**
   * The deck is stored as an instance variable. Create a new deck and shuffle
   * it.
   */
  private void createAndShuffleDeck() {
    deck = new Deck();
    deck.shuffle();
  }

  /**
   * Create a new list of member names. This list is modified by removing names
   * of player members. The original list (members) is not modified, which is a
   * good thing because it is an immutable list (throws an exception if an
   * attempt is made to modify it).
   */
  private void selectPlayers() {
    List<String> names = new LinkedList<>(members);
    player1 = selectPlayer(names);
    player2 = selectPlayer(names);

    System.out
        .println(player1.getName() + " is playing " + player2.getName() + ".");
  }

  /**
   * Figure out which player has the highest score and announce the winner. Note
   * the self-documenting method calls ({@link #printWinner(Player)},
   * {@link #printLoser(Player)} and {@link #printTie(Player, Player)}. These
   * methods are clearly named for what they do.
   */
  private void declareWinner() {
    if(player1.getScore() > player2.getScore()) {
      printWinner(player1);
      printLoser(player2);
    }
    else if(player2.getScore() > player1.getScore()) {
      printWinner(player2);
      printLoser(player1);
    }
    else {
      printTie(player1, player2);
    }
  }

  /**
   * Announce the loser.
   * 
   * @param loser The loser.
   */
  private void printLoser(Player loser) {
    System.out.println(loser.getName()
        + " is the miserable, decrepit loser with a pathetic score of "
        + loser.getScore() + ".");
  }

  /**
   * Announce the winner.
   * 
   * @param winner The winner.
   */
  private void printWinner(Player winner) {
    System.out.println(winner.getName()
        + " is the glorious winner with a score of " + winner.getScore() + ".");
  }

  /**
   * Announce a tie, in which both players have the same score.
   * 
   * @param player1 The first player.
   * @param player2 The second player.
   */
  private void printTie(Player player1, Player player2) {
    System.out.println(player1.getName() + " and " + player2.getName()
        + " tied with a score of " + player1.getScore() + ".");
  }

  /**
   * This method plays the game and stores each player's score in the
   * {@link Player} object.
   */
  private void playTheGame() {
    /*
     * Each player has the same number of cards so pick one to get the number of
     * cards, which equals the number of turns.
     */
    int numTurns = player1.getHand().size();

    /*
     * For each turn, players flip over the top card in their hand, which
     * removes the card from the hand. The card ranks are compared and the
     * winning player increments the score in the Player object. If there is a
     * tie, neither player increments the score. A while loop would also make
     * sense here: while(!player1.getHand().isEmpty()) { ... }
     */
    for(int turn = 0; turn < numTurns; turn++) {
      playersFlipCards();
    }
  }

  /**
   * Each player flips a card and checks the play winner.
   */
  private void playersFlipCards() {
    Card card1 = player1.flip();
    Card card2 = player2.flip();
    
    if(card1.getRank() > card2.getRank()) {
      player1.incrementScore();
    }
    else if(card2.getRank() > card1.getRank()) {
      player2.incrementScore();
    }
  }

  /**
   * Deal the deck evenly to each player. The cards in the deck go into the
   * players' hands.
   */
  private void dealTheCards() {
    int size = deck.size();

    /*
     * Use a traditional for loop because the counter (index) allows us to
     * determine which player to deal to.
     */
    for(int index = 0; index < size; index++) {
      /*
       * Use the modulo (remainder) operator to determine which player gets a
       * card. The remainder of dividing by 2 is either 1 (for odd numbers) or 0
       * (for even numbers).
       */
      if(index % 2 == 0) {
        player1.draw(deck);
      }
      else {
        player2.draw(deck);
      }

      /*
       * Here is an alternate approach. I prefer this approach but it's not the
       * one specified in the assignment.
       */
      // while(!deck.isEmpty()) {
      // player1.draw(deck);
      // player2.draw(deck);
      // }
    }
  }

  /**
   * Randomly select a player name from the given list. The player name is
   * removed from the list so that the same player is not selected twice.
   * 
   * @param names The list of names to select from.
   * @return A {@link Player} object created with the selected name.
   */
  private Player selectPlayer(List<String> names) {
    int pos = random.nextInt(names.size());
    String playerName = names.remove(pos);
    return new Player(playerName);
  }
}
