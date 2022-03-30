package game;

/**
 * This class represents a Card in Galactic War. A Card contains a person name,
 * a planet, and a rank. Cards are created in the {@link Deck} constructor.
 * 
 * @author Promineo
 *
 */
public class Card {
  private String person;
  private String planet;
  private int rank;

  /**
   * Create and initialize a Card object.
   * 
   * @param person The name of the person.
   * @param planet The name of the planet.
   * @param rank The card rank, used for scoring.
   */
  public Card(String person, String planet, int rank) {
    this.person = person;
    this.planet = planet;
    this.rank = rank;
  }

  /**
   * Returns a String representation of the Card object (i.e., "C3-PO of
   * Naboo").
   */
  @Override
  public String toString() {
    return person + " of " + planet;
  }

  /**
   * @return The rank of the card. Ranks are assigned by the {@link Deck} class
   *         when the card is created.
   */
  public int getRank() {
    return rank;
  }
}
