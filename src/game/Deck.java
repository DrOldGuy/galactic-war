package game;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a card deck. The deck is populated with cards in the
 * constructor. Note that the Deck class extends LinkedList<Card>. This means
 * that the Deck can be treated as a List of Card with all the public methods
 * from List accessible to the caller.
 * <p>
 * @SuppressWarnings("serial"): The class doesn't declare the instance variable
 * serialVersionUID so a warning is generated. The class doesn't need to be
 * serialized so just suppress the warning.
 * 
 * @author Promineo
 *
 */
@SuppressWarnings("serial")
public class Deck extends LinkedList<Card> {
  /* The internal list of person names that is used to generate the deck. */
  private final List<String> people = List.of("Bobba Fett", "Anakin Skywalker",
      "Luke Skywalker", "Leia Organa", "Han Solo", "Padmé Amidala",
      "Jabba the Hutt", "Chewbacca", "Yoda", "C3-PO", "R2-D2", "Shmi Skywalker",
      "Rey Skywalker", "Jar-Jar Binks", "Maz Kanata", "Wedge Antilles");

  /*
   * The internal list of planets (like suits) that is used to generate the
   * deck.
   */
  private final List<String> planets =
      List.of("Tatooine", "Alderaan", "Hoth", "Kamino", "Naboo", "Dagobah");

  /**
   * The deck of cards is populated in this constructor. A card is a combination
   * of person name and planet (i.e., "Chewbacca of Hoth"). Each card also has a
   * rank, which is the position of the person element in the people list with 1
   * added to it. For example "Bobba Fett" is at position 0 so any "Bobba Fett"
   * card would have a rank of 1. Likewise, "Wedge Antilles" is in the 16th
   * position in the list so all "Wedge Antilles" cards have a rank of 17.
   */
  public Deck() {
    for(int personPos = 0; personPos < people.size(); personPos++) {
      int rank = personPos + 1;
      String person = people.get(personPos);

      for(String planet : planets) {
        add(new Card(person, planet, rank));
      }
    }
  }

  /**
   * Returns a String representation of all the cards currently in the deck.
   * This is mostly just used for debugging purposes.
   */
  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();

    b.append("List of cards:" + System.lineSeparator());

    for(Card card : this) {
      b.append("   ").append(card).append(System.lineSeparator());
    }

    return b.toString();
  }

  /**
   * Randomly shuffle the cards in the deck.
   */
  public void shuffle() {
    /*
     * This algorithm works like this: 1) a temporary list is created that is a
     * copy of the list in the Deck object. The list in the Deck object is
     * emptied by calling clear(). While the temp list has cards, a card is
     * randomly selected. It is removed from the temp list and added to the list
     * in the Deck. Once the temp list is empty, the deck has been shuffled.
     */
    // List<Card> tempList = new LinkedList<>(this);
    // Random random = new Random();
    //
    // clear();
    //
    // while(!tempList.isEmpty()) {
    // add(tempList.remove(random.nextInt(tempList.size())));
    // }

    /* This is a much shorter way of shuffling the deck. */
    Collections.shuffle(this);
  }

  /**
   * Draw and return the "top" card from the deck.
   * 
   * @return The "top" card.
   */
  public Card draw() {
    return remove(0);
  }
}
