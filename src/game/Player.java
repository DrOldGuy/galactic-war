package game;

import java.util.List;

/**
 * This class defines the data needed for a player. Note the principle
 * of Abstraction: only the player name, score, and hand are
 * maintained. This is a very shallow abstraction of a real person. We
 * only store the attributes we care about.
 * <p>
 * Also note the principle of Encapsulation: all instance variables
 * are private. Access is only allowed through public accessor
 * methods, which gives us control over how the data is stored and
 * presented.
 * 
 * @author Promineo
 *
 */
public class Player {
  private String name;
  private Hand hand = new Hand();
  private int score;

  /**
   * The player name must be set in the constructor. It is immutable
   * as there is no setter for player name.
   * 
   * @param name The player name.
   */
  public Player(String name) {
    this.name = name;
  }

  /**
   * @return The player name.
   */
  public String getName() {
    return name;
  }

  /**
   * Remove the "top" card from the deck and add it to the player's
   * hand.
   * 
   * @param deck The deck of cards.
   */
  public void draw(Deck deck) {
    getHand().add(deck.draw());
  }

  /**
   * Express the player object as a String. This returns the player
   * name and cards in the hand. In the assignment, this would do the
   * same thing as the describe() method. I would implement describe
   * like this:
   * 
   * <pre>
   * public String describe() {
   *   return toString();
   * }
   * </pre>
   * 
   * This is because toString() is a method on Object. When you pass
   * an object to System.out.println(), the toString() method is
   * called on the object. Java doesn't know anything about a
   * describe() method. toString() is a method on the Object class.
   * Since every class is ultimately derived from Object, Java knows
   * that <em>every</em> object has a toString() method.
   */
  @Override
  public String toString() {
    return name;
  }
  
  public void describe() {
    StringBuilder result = new StringBuilder();

    result.append("Player ").append(name).append("'s ").append(hand);
    System.out.println(result.toString());
  }

  /**
   * @return The player's current hand. The hand changes when the
   *         {@link #flip()} method is called.
   */
  public List<Card> getHand() {
    return hand;
  }

  /**
   * Remove and return the "top" card from the player's hand.
   * 
   * @return The "top" card in the deck. Note that this will throw an
   *         exception if this is called with an empty hand. It's up
   *         to the caller to keep things straight.
   */
  public Card flip() {
    return hand.remove();
  }

  /**
   * Increment the player's score by 1.
   */
  public void incrementScore() {
    score = getScore() + 1;
  }

  /**
   * @return The player's current score.
   */
  public int getScore() {
    return score;
  }
}
