package game;

import java.util.LinkedList;

/**
 * This class is the parent class of the {@link Deck} and {@link Hand}
 * classes. It does two things:
 * <ol>
 * <li>It recognizes that both a Deck and a Hand are simply a list of
 * cards. So, it extends LinkedList<Card>.</li>
 * <li>It provides a standard {@link #toString()} method that prints
 * the current contents of the list of cards.
 * </ol>
 * 
 * @author Promineo
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractCardList extends LinkedList<Card> {
  public void describe() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    String lf = System.lineSeparator();

    /*
     * this.getClass() returns the class object of the concrete class
     * (Deck.class or Hand.class). this.getClass().getSimpleName()
     * returns the class name without the package name ("Deck" or
     * "Hand").
     */
    String name = this.getClass().getSimpleName();

    result.append(name).append(": ").append(lf);

    for(int pos = 0; pos < this.size(); pos++) {
      String space = "   ";
      Card card = this.get(pos);

      /*
       * StringBuilder.append(card) calls the toString() method on the
       * Card object.
       */
      result.append(space).append(card).append(lf);
    }

    return result.toString();
  }

}
