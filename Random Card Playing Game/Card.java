/*
 * File name: Card.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 - OOP, Lab Section:302
 * Lab: 4
 * Date: 2022-07-09
 * Professor: Daniel Cormier
 * Purpose: The class implements the specific functions for
 * interface class "Card". The class can generate a random card
 * and return its short name, suit type, value, and long name.
 */

import java.util.Random;

/**
 * The purpose of this class is to get the name, suit and value of the
 * random generated card
 *
 * @author Boyu Li
 * @Version 1.0
 * @since 15.0.1
 */

class Card implements CardTemplate {
    //creates two "random" objects to generate the random face and random suit each time
    private Random random1 = new Random();
    private Random random2 = new Random();
    private int randomFace = random1.nextInt(MAX_FACES);
    private int randomSuit = random2.nextInt(MAX_SUITS);

    /**
     * The method getShortName is an override method, it will get the short name
     * of random generated card
     *
     * @return return the short name of the card
     */

    @Override
    public String getShortName() {
        //Based on the suit and face of the card
        //The method return the string with the face letter and suit letter as
        //a short name of the card
        String shortName = "";
        shortName = rankShort[randomFace] + suitShort[randomSuit];
        return shortName;
    }

    /**
     *  The method getLongName is an override method, it will get the long name of
     *  random generated card
     *
     * @return the long name of the card
     */

    @Override
    public String getLongName() {
        //Based on the suit and face of the card
        //The method return the string with the face name and suit name as
        //a long name of the card
        String longName = "";
        longName = rankLong[randomFace] + " of " + suitLong[randomSuit];
        return longName;
    }

    /**
     *  The method getCardValue is an override method, it will get the value of random
     *  generated card
     *
     * @return the specific value of the card
     */

    @Override
    public int getCardValue() {

        /*
        * based on the random generated suit and face,
        * it will get the correspoding value for the
        * random generated card
        */
        int valueOfCard = 0;
        if (randomSuit == 0) {
            /*
            * The value will start with 13, if the loop find out the matched number
            * The value of the card will be assigned to value variable. value will
            * keep subtract each loop to find the correct value of the card
            */
            int value = 13;
            for (int i = 0; i < rankShort.length; i++) {
                if (randomFace == i) {
                    valueOfCard = value;
                }
                value--;
            }
        }

        if (randomSuit == 1) {
            int value = 13;
            for (int i = 0; i < rankShort.length; i++) {
                if (randomFace == i) {
                    valueOfCard = value;
                }
                value--;
            }
        }

        if (randomSuit == 2) {
            int value = 13;
            for (int i = 0; i < rankShort.length; i++) {
                if (randomFace == i) {
                    valueOfCard = value;
                }
                value--;
            }
        }

        if (randomSuit == 3) {
            int value = 13;
            for (int i = 0; i < rankShort.length; i++) {
                if (randomFace == i) {
                    valueOfCard = value;
                }
                value--;
            }
        }
        return valueOfCard;
    }

    /**
     *  The method getSuitType is an override method, it will get the type of the suit of random
     *  generated card
     *
     * @return the type of suit of the card
     */

    @Override
    public int getSuitType() {
        //The else if structure will find out the value of random generated card suit
        int suitType = 0;
        //There is totally 4 type of suit, so there are four conditions here
        if (randomSuit == 0) {
            suitType = 0;
        } else if (randomSuit == 1) {
            suitType = 1;
        } else if (randomSuit == 2) {
            suitType = 2;
        } else {
            suitType = 3;
        }
        return suitType;
    }
}
