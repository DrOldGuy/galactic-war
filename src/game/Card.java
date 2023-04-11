package game;

/**
 * This class represents a Card in Galactic War. A Card contains a
 * card name, a domain (planet or suit), and a rank. Cards are created
 * in the {@link Deck} constructor.
 * 
 * @author Promineo
 *
 */
public class Card {
  private String name;
  private String domain;
  private int rank;

  /**
   * Create and initialize a Card object.
   * 
   * @param name The name of the card.
   * @param domain The name of the domain.
   * @param rank The card rank, used for scoring.
   */
  public Card(String name, String domain, int rank) {
    this.name = name;
    this.domain = domain;
    this.rank = rank;
  }

  /**
   * Returns a String representation of the Card object (i.e., "C3-PO
   * of Naboo", or "Two of Spades").
   */
  @Override
  public String toString() {
    return name + " of " + domain;
  }

  /**
   * @return The rank of the card. Ranks are assigned by the
   *         {@link Deck} class when the card is created.
   */
  public int getRank() {
    return rank;
  }
}
