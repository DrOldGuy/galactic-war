# Galactic War

This project plays a variation of the card game War. It is much shorter in that cards are only drawn once by each player. The game is over when all cards have been played so the game does not go on for days.

## Project classes

### GalacticWar

This class contains the entry point (main() method). When run, it creates two players with names randomly selected from a list. It then creates and shuffles a deck of cards and deals the cards to the two players. The players then flip a card and compare the card ranks. The player with the highest card gets a point. When all cards have been flipped, the scores are compared and a winner is declared.

### Player

This class represents a player. Each player class has a player name, a hand of cards and a score. When a player flips a card, it is removed from the hand.

### AbstractCardList

This is the parent class of Deck and Hand. It extends LinkedList to represent that both a deck and a hand are a list of cards. This class contains the toString and describe methods, which are essentially the same for both Deck and Hand.

### Deck

This class represents a deck of cards. The card list is created in the deck constructor. At the start of the game the deck is shuffled and cards are then removed from the deck and evenly dealt to the players. A Deck initializes itself in the constructor, creating all the cards. It contains the shuffle() and draw() methods.

### Hand

This class is very similar to Deck. It is a list of cards contained by the Player.

### Card

A card object has a person name (i.e., "Padmé Amidala"), a planet (i.e., "Naboo"), and a rank. The card details are maintained in the Deck object.

## Playing the game

To play the game, run the GalacticWar class as a Java application.