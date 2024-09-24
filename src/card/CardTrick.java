/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;
/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier nguytamd - 991726877
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        Card[] magicHand = new Card[7];
        
        for (int i=0; i < magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(Card.SUITS.length)]);
            magicHand[i] = c;
            System.out.println(c.getSuit() + " " + c.getValue());
        }
        
        //insert code to ask the user for Card value and suit, create their card
        // and search magicHand here
        //Then report the result here
        // add one luckcard hard code 2,clubs
        
        System.out.println("Enter a card value from 1 - 13 (1 - Ace, 11 - Jack, 12 - Queen, 13 - King): ");
        int userValue = scanner.nextInt();
        System.out.println("Enter a suit from 0 - 3 (0 - Hearts, 1 - Diamonds, 2 - Clubs, 3 - Spades): ");
        int userSuit = scanner.nextInt();
        scanner.nextLine();
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);
        
        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() 
                    && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("Nice! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not found in the magic hand.");
        }
        
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        System.out.println("Lucky card: " + luckyCard.getValue() + " of " + luckyCard.getSuit());
        
        scanner.close();
    }
    
}
