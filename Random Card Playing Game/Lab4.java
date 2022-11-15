/*
 * File name: Lab4.java
 * Author: Boyu Li, 041003345#
 * Course: CST8132 - OOP, Lab Section:302
 * Lab: 4
 * Date: 2022-07-09
 * Professor: Daniel Cormier
 * Purpose: The class generates 52 unique cards and allows four players.
 * Then, the program will automatically and randomly play the card game.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab4 {
    /**
     * The purpose of class Lab4 is to test the program
     *
     * @author Boyu Li
     * @version 2.0
     * @since 15.0.1
     */
    //The String option will hold the user's option
    private String option = "";
    //The arraylist cardDeck will store 52 unique cards
    private ArrayList<CardTemplate> cardDeck = new ArrayList<CardTemplate>();
    //The arrayList players will hold the all players
    private ArrayList<Player> players = new ArrayList<Player>();
    //The arrayList playCard will hold the cards that players play each round
    private ArrayList<CardTemplate> playCard = new ArrayList<CardTemplate>();

    /**
     * The method is the main method for Lab4, the program will start with it
     *
     * @param args The command line argument
     */

    public static void main(String args[]) {
        Lab4 lab4 = new Lab4();
    }

    /**
     * It is the constructor for Lab4, the class implements all the functions to
     * run an auto card playing game.
     */

    Lab4() {
        Scanner sc = new Scanner(System.in);
        /*
         * The codes below will ask four players to enter their name
         */
        System.out.println("Welcome to Auto-Cards");
        System.out.println("Before we start, let's name the four players.");
        System.out.println("Enter player 1's name: ");
        String playerName1 = sc.nextLine();
        Player player1 = new Player(playerName1);

        System.out.println("Enter player 2's name:");
        String playerName2 = sc.nextLine();
        Player player2 = new Player(playerName2);

        System.out.println("Enter player 3's name:");
        String playerName3 = sc.nextLine();
        Player player3 = new Player(playerName3);

        System.out.println("Enter player 4's name:");
        String playerName4 = sc.nextLine();
        Player player4 = new Player(playerName4);

        //store the four players into ArrayList
        players.add(0, player1);
        players.add(1, player2);
        players.add(2, player3);
        players.add(3, player4);

        /*
         * The while loop below generates 52 unique cards and add them to the cardDeck
         */

        while (cardDeck.size() < 52) {
            //the variable to check whether the new generated card is already existed in the cardDeck
            int count = 0;
            //each round the code will generate a new card
            CardTemplate myCard = new Card();
            //The for loop below will compare the new generated card with all the cards in cardDeck
            //To checks if the new generated card has already existed
            for (int i = 0; i < cardDeck.size(); i++) {
                if (myCard.getShortName().equals(cardDeck.get(i).getShortName())) {
                    //if the card has been already existed, the count will plus
                    count++;
                }
            }
            //if there is no cards is same as the new generated card, add the new generated card into cardDeck
            if (count == 0) {
                cardDeck.add(myCard);
            }
        }

        do {
            //The array to decide the players' playing order for each round
            int[] indexes = {0, 1, 2, 3};
            //When the new game starts, all the players will be initialized
            player1.reset();
            player2.reset();
            player3.reset();
            player4.reset();
            System.out.println("Dealing cards...");
            //The total round for a game is 14 rounds, so it will do 14 rounds
            for (int round = 1; round <= 14; round++) {
                //if the round comes to the final round
                if (round == 14) {
                    //The program will decide the winner and print the information of all the players
                    System.out.println("Game over!");
                    System.out.println("Final scores :");
                    System.out.println(player1.getName() + " with " + player1.getScore() + " hands won.");
                    System.out.println(player2.getName() + " with " + player2.getScore() + " hands won.");
                    System.out.println(player3.getName() + " with " + player3.getScore() + " hands won.");
                    System.out.println(player4.getName() + " with " + player4.getScore() + " hands won.");
                    //The for loop below will decide who is the winner in a game
                    String winnerName = "";
                    int highestScore = 0;
                    for (int i = 0; i < players.size(); i++) {
                        //if any player's score is higher than the highest score
                        if (players.get(i).getScore() >= highestScore) {
                            //assign the player's score and name to winner also highest score
                            //To find the winner
                            highestScore = players.get(i).getScore();
                            winnerName = players.get(i).getName();
                        }
                    }
                    //output the winner
                    System.out.println(winnerName + " has won! (unless they tied)");
                    System.out.println();
                    //based on user's option to decide if the program execute again
                    System.out.println("Another game? y to continue :");
                    option = sc.nextLine();
                } else {
                    System.out.println();
                    System.out.println("This is round " + round + ".");
                    /*
                    * If the round comes to the first round, the program fills players' hand list
                    * by the cards in cardDeck, then remove all the cards from cardDeck
                    */
                    if (round == 1) {
                        for (int i = 0; i < 13; i++) {
                            player1.addCard(cardDeck.get(i));
                            cardDeck.remove(i);
                        }

                        for (int i = 0; i < 13; i++) {
                            player2.addCard(cardDeck.get(i));
                            cardDeck.remove(i);
                        }

                        for (int i = 0; i < 13; i++) {
                            player3.addCard(cardDeck.get(i));
                            cardDeck.remove(i);
                        }

                        for (int i = 0; i < 13; i++) {
                            player4.addCard(cardDeck.get(i));
                        }
                        cardDeck.clear();
                    }
                    //display the players' information at the beginning of each round
                    System.out.println(players.get(indexes[0]).getName() + "(" + players.get(indexes[0]).getScore() + " hands won):" + players.get(indexes[0]).getHand());
                    System.out.println(players.get(indexes[1]).getName() + "(" + players.get(indexes[1]).getScore() + " hands won):" + players.get(indexes[1]).getHand());
                    System.out.println(players.get(indexes[2]).getName() + "(" + players.get(indexes[2]).getScore() + " hands won):" + players.get(indexes[2]).getHand());
                    System.out.println(players.get(indexes[3]).getName() + "(" + players.get(indexes[3]).getScore() + " hands won):" + players.get(indexes[3]).getHand());
                    System.out.println("Enter q to quit, anything else to play out this round:");
                    String quit = sc.nextLine();
                    //The program will receive user's option to decide if the round continue to play
                    if (quit.equalsIgnoreCase("q")) {
                        //if user decide to quit, output author's name and thanking information
                        System.out.println("Thanks for playing!");
                        System.out.println("This Auto-Cards implemented by Boyu Li.");
                        break;
                    } else {
                        /*The first player will randomly play a card, and that card will be the first card
                        * The rest of the players must follow the suit of that card, then add the card to cardDeck
                        * and recycle all the cards that player played
                        */
                        CardTemplate firstCard = players.get(indexes[0]).playCard();
                        playCard.add(0, firstCard);
                        cardDeck.add(firstCard);

                        CardTemplate secondCard = players.get(indexes[1]).playCardBonus(firstCard);
                        playCard.add(1, secondCard);
                        cardDeck.add(secondCard);

                        CardTemplate thirdCard = players.get(indexes[2]).playCardBonus(firstCard);
                        playCard.add(2, thirdCard);
                        cardDeck.add(thirdCard);

                        CardTemplate fourthCard = players.get(indexes[3]).playCardBonus(firstCard);
                        playCard.add(3, fourthCard);
                        cardDeck.add(fourthCard);

                        //display the long name of the cards that players played
                        System.out.println(players.get(indexes[0]).getName() + " plays " + firstCard.getLongName());
                        System.out.println(players.get(indexes[1]).getName() + " plays " + secondCard.getLongName());
                        System.out.println(players.get(indexes[2]).getName() + " plays " + thirdCard.getLongName());
                        System.out.println(players.get(indexes[3]).getName() + " plays " + fourthCard.getLongName());

                        //because the real players arraylist cannot directly involve into the calculations, so I create
                        // a para arraylist to hold the elements from the players arraylist
                        ArrayList<Player> paraPlayer = new ArrayList<Player>();
                        paraPlayer.add(0, players.get(indexes[0]));
                        paraPlayer.add(1, players.get(indexes[1]));
                        paraPlayer.add(2, players.get(indexes[2]));
                        paraPlayer.add(3, players.get(indexes[3]));

                        //The for below will find who is the winner in a round
                        for (int i = 0; i < 4; i++) {
                            if (playCard.get(i).getSuitType() == playCard.get(0).getSuitType()) {
                                if (playCard.get(i).getCardValue() > playCard.get(0).getCardValue()) {
                                    //if the any players card value is greater than first player
                                    //swap the card and player to the first element
                                    //it will make sure the first element of the para player will always be
                                    //the winner
                                    Collections.swap(paraPlayer, 0, i);
                                    Collections.swap(playCard, 0, i);
                                }
                            }
                        }

                        //output the winner's information and add a score for him
                        System.out.println(paraPlayer.get(0).getName() + " wins this hand!");
                        paraPlayer.get(0).handWon();

                        //use the module method to decide the player's playing order
                        //And store the order into an array
                        int offSet = players.indexOf(paraPlayer.get(0));
                        for (int i = 0; i < players.size(); i++) {
                            indexes[i] = (i + offSet) % players.size();
                        }
                        //clear playCard and paraPlayer for next round calculations
                        paraPlayer.clear();
                        playCard.clear();

                    }
                }
            }
        }
        //if user's option is yes, do the game again
        while (option.equalsIgnoreCase("y"));
    }
}
