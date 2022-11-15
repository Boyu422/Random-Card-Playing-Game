/*
 * File name: Player.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 - OOP, Lab Section:302
 * Lab: 4
 * Date: 2022-07-09
 * Professor: Daniel Cormier
 * Purpose: The class obtains the main functions(get name,
 * get hand card, add card, get score, play card, reset the
 * score and hand cards, and increase the score if player win)
 * for card game.
 */

import java.util.ArrayList;
import java.util.Random;
/**
 * The class Player provides all functions for players.
 *
 * @author Boyu Li
 * @version 2.0
 * @since 15.0.1
 */
public class Player {
    //create an Arraylist card to hold the card the players currently has
    private ArrayList<CardTemplate> playerHand = new ArrayList<CardTemplate>();
    //create a string to hold user's name
    private String name;
    //create an int to hold user's score
    private int score;
    //create a random object to pick a random card
    private Random myRandom = new Random();

    /**
     * This is a constructor accepts a string variable as a player's name
     *
     * @param paraName player's name, we will have four different players' name
     * in this program
     */
    Player(String paraName) {
        name = paraName;
    }
    /**
     * This method addCard will add a card variable to ArrayList player's hand
     *
     * @param myCard card from card deck
     */
    public void addCard(CardTemplate myCard) {
        playerHand.add(myCard);
    }

    /**
     * This method getHand can return all the cards that player currently has
     * as a String
     *
     * @return the all the cards in Arraylist playerHand
     */
    public String getHand() {
        //To create a string here to hold the all card's short name
        String handCard = "";
        //The for loop below will accumulate all cards short name
        for (int i = 0; i < playerHand.size(); i++) {
            handCard += playerHand.get(i).getShortName() + " ";
        }
        return handCard;
    }

    /**
     * The method handWon will plus 1 to internal variable score
     */

    public void handWon() {
        score++;
    }

    /**
     * The method getScore is to return the score that player currently has
     *
     * @reutrn the player's score
     */

    public int getScore() {
        return score;
    }

    /**
     * The method getName is to get the name of the player
     *
     * @return the player's name
     */

    public String getName() {
        return name;
    }

    /**
     * The method reset is to initialize the cards that player
     * currently has also the score.
     */
    public void reset() {
        playerHand.clear();
        score = 0;
    }
    /**
     * The method playCard will randomly pick then remove a card from ArrayList playerHand
     *
     * @return the card that's picked randomly
     */
    public CardTemplate playCard() {
        //The method will randomly pick a card
        int randomCard = myRandom.nextInt(playerHand.size());
        //Firstly store this card into a card object, then remove it
        CardTemplate playCard = playerHand.get(randomCard);
        playerHand.remove(randomCard);
        return playCard;
    }

    /**
     *  The method will randomly pick a card from ArrayList playerHand has the same suits
     *  with the input card,if there is no same suit card, the method will randomly pick
     *  a card from ArrayList playerHand
     *
     * @param firstCard the card that decides the card suit
     *
     * @return return a card that's picked
     */

    public CardTemplate playCardBonus(CardTemplate firstCard) {
        //The method will check whether the cards that player currently owned have the same suit card
        ArrayList<CardTemplate> valuedCard = new ArrayList<CardTemplate>();
        //Store all the same suit cards into a valueCard arraylist
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).getSuitType() == firstCard.getSuitType()) {
                valuedCard.add(playerHand.get(i));
            }
        }
        //if there are any valid cards, the method will randomly pick a card with same suit
        if (valuedCard.isEmpty() == false) {
            int randomCard = myRandom.nextInt(valuedCard.size());
            CardTemplate playCard = playerHand.get(randomCard);
            playerHand.remove(randomCard);
            return valuedCard.get(randomCard);
            //otherwise, randomly pick a card to play
        } else {
            int randomCard = myRandom.nextInt(playerHand.size());
            CardTemplate playCard = playerHand.get(randomCard);
            playerHand.remove(randomCard);
            return playCard;
        }
    }
}

