/*
 * File name: CardTemplate.java
 * Author: Daniel Cormier, 041003345#
 * Modified by : Boyu Li
 * Course: CST8132 - OOP, Lab Section:302
 * Lab: 4
 * Date: 2022-07-09
 * Professor: Daniel Cormier
 * Purpose: The class contains the basic elements(suit,face) of the cards
 * Also, there are four abstract to return the short name, long name, suit
 * type and value of each card.
 */

    /**
     * The interface class obtains all the suits and faces of the cards, also there
     * are four abstract methods are defined in it.
     *
     * @author Daniel Cormier
     * @version 2.0
     * @since 1.6
     */

public interface CardTemplate {
    //All values are static, as they won't vary from instance to instance.
    //Why use extra memory when we don't need to?

    //Convenience constants:
    final static int MAX_CARDS = 52;
        /** MAX_CARDS show the maximum number of cards in a cardDeck is 52 */
    final static int MAX_SUITS = 4;
        /** MAX_CARDS show there are total 4 type of suits of cards */
    final static int MAX_FACES = 13;
        /** MAX_CARDS show there are total 13 type of faces of cards */
    // Contains the Unicode symbols for solid spades, hollow hearts,
    // hollow diamonds and solid clubs, respectively.  Try commenting it out if you're on a Linux or Mac
    // to see what happens?  If you see gibberish, use the other suitShort definition below.
//     static char[] suitShort = new char[]{'\u2660', '\u2661', '\u2662', '\u2663'};

    // Windows console does not render unicode characters.  Use the below line for all
    // Windows implementations:
    static char[] suitShort = new char[]{'s', 'h', 'd', 'c'};

    //To be used to assemble your card names:
    static String[] rankShort = new String[]{"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    static String[] suitLong = new String[]{"Spades", "Hearts", "Diamonds", "Clubs"};
    static String[] rankLong = new String[]{"Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven",
            "six", "five", "four", "three", "two"};

    //Method to return the "short name" of the card, drawn from the various Short arrays:
    //ie: "Ac" for "Ace of Clubs".
        /**
         *  This is an abstract class for other class to implements
         * @return a short name of a card in String
         */
    public String getShortName();

        /**
         *  This is an abstract class for other class to implements
         * @return a Long name of a card in String
         */

    //Method to return the full name of the card, drawn from the various Long arrays:
    //ie: "Ace of Clubs"
    public String getLongName();

        /**
         *  This is an abstract class for other class to implements
         * @return a specific value of a card in integer
         */
    public int getCardValue();

        /**
         *  This is an abstract class for other class to implements
         * @return a specific suit type of card in integer
         */

    public int getSuitType();
}

