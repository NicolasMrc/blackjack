import java.util.LinkedList;

/**
 * Created by Nico on 07/11/2016.
 */
public class BlackJackConsole {
    public  BlackJackConsole(){
        System.out.println("Welcolme to the BlackJack table. Let's play !");
        // This is an array of two cards
        Card[] tab = { new Card(Value.TWO, Color.HEART), new Card(Value.JACK, Color.SPADE) };

        LinkedList<Card> cards = new LinkedList<>();

        for (Color color : Color.values()){
            for(Value value : Value.values()){
                cards.add(new Card(value, color));
            }
        }

        System.out.println("There is " + cards.size() + "in the deck !");

        for(Card c : cards) { // For each card
            System.out.println("This card is a "+c+ " worth "+c.getPoints()+ " points");
        }
    }

    public static void main(String[] args){
        new BlackJackConsole();
    }
}
