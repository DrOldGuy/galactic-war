package game;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * This class represents a card deck. The deck is populated with cards
 * in the constructor. Note that the Deck class extends
 * {@link AbstractCardList}, which extends LinkedList<Card>. This
 * means that the Deck can be treated as a List of Card with all the
 * public methods from List accessible to the caller.
 * <p>
 * @SuppressWarnings("serial"): The class doesn't declare the instance
 * variable serialVersionUID so a warning is generated. The class
 * doesn't need to be serialized so just suppress the warning.
 * 
 * @author Promineo
 *
 */
@SuppressWarnings("serial")
public class Deck extends AbstractCardList {
  /*
   * The internal list of person names that is used to generate the
   * deck.
   */
  private final List<String> cardNames = List.of("Bobba Fett",
      "Anakin Skywalker", "Luke Skywalker", "Leia Organa", "Han Solo",
      "Padmé Amidala", "Jabba the Hutt", "Chewbacca", "Yoda", "C3-PO",
      "R2-D2", "Shmi Skywalker", "Rey Skywalker", "Jar-Jar Binks",
      "Maz Kanata", "Wedge Antilles");

  /* In the homework, this could be represented as: */
  // private final List<String> cardNames = List.of("Two", "Three",
  // "Four",
  // "Five",
  // "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King",
  // "Ace");

  /*
   * The internal list of planets (like suits) that is used to
   * generate the deck.
   */
  private final List<String> domains = List.of("Tatooine", "Alderaan",
      "Hoth", "Kamino", "Naboo", "Dagobah");

  /* In the homework, this could be represented as: */
  // private final List<String> domains =
  // List.of("Hearts", "Clubs", "Spades", "Diamonds");

  /**
   * The deck of cards is populated in this constructor. A card is a
   * combination of person name and planet (i.e., "Chewbacca of
   * Hoth"). Each card also has a rank, which is the position of the
   * person element in the people list with 1 added to it. For example
   * "Bobba Fett" is at position 0 so any "Bobba Fett" card would have
   * a rank of 1. Likewise, "Wedge Antilles" is in the 16th position
   * in the list so all "Wedge Antilles" cards have a rank of 17.
   */
  public Deck() {
    for(int rank = 1; rank <= cardNames.size(); rank++) {
      String cardName = cardNames.get(rank - 1);
      generateCardsForPerson(rank, cardName);
    }
  }

  /**
   * Generate all the cards for a person. This will add a card for
   * each planet for the given person.
   * 
   * @param rank The card rank.
   * @param cardName The person name.
   */
  private void generateCardsForPerson(int rank, String cardName) {
    for(String domain : domains) {
      add(new Card(cardName, domain, rank));
    }
  }

  /**
   * Randomly shuffle the cards in the deck. Note the use of the
   * <em>this</em> keyword. It isn't needed but draws attention to the
   * fact that size(), get(), and set() are all methods found in the
   * parent {@link LinkedList} object.
   */
  public void shuffle() {
    Random random = new Random();

    for(int cardPos = 0; cardPos < this.size(); cardPos++) {
      int swapPos = random.nextInt(this.size());

      Card card = this.get(cardPos);
      this.set(cardPos, this.get(swapPos));
      this.set(swapPos, card);
    }

    // Or, you can do this:
    // Collections.shuffle(this);
  }

  /**
   * Draw and return the "top" card from the deck.
   * 
   * @return The "top" card.
   */
  public Card draw() {
    return this.remove();
  }
}
