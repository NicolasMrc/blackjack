import java.util.List;

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

        Hand hand = new Hand();

        for(int i = 0; i < 3 ; i++) {
            try {
                hand.add(deck.draw());
            } catch (EmptyDeckException e) {
                System.exit(-1);
            }
        }
        System.out.print("Your hand is currently : \n" + hand);
    }

    public static void main(String[] args){
        new BlackJackConsole();
    }
}
