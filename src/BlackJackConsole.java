import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Nico on 07/11/2016.
 */
public class BlackJackConsole {
    public  BlackJackConsole(){
        System.out.println("Welcolme to the BlackJack table. Let's play !");

        Deck deck = new Deck(1);
        System.out.println("Here is the deck :\n" + deck);
        deck.shuffle();
        System.out.println("Here is the deck shuffled :\n" + deck);
        System.out.println();
        for(int i = 0; i < 3 ; i++) {
            try {
                Card c = deck.draw();
                System.out.println("This card is a " + c + " worth " + c.getPoints() + " points");
            } catch (EmptyDeckException e) {
                System.exit(-1);
            }
        }
    }

    public static void main(String[] args){
        new BlackJackConsole();
    }
}
