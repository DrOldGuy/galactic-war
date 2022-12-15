package game;

/**
 * This class represents a player's hand (list of cards). It extends
 * {@link AbstractCardList}, so a Hand is a list of cards. AbstractCardList
 * supplies a {@link AbstractCardList#toString()} method that prints the list of
 * cards.
 * <p>
 * @SuppressWarnings("serial"): The class doesn't declare the instance variable
 * serialVersionUID so a warning is generated. The class doesn't need to be
 * serialized so just suppress the warning.
 * 
 * @author Promineo
 *
 */
@SuppressWarnings("serial")
public class Hand extends AbstractCardList {
}
