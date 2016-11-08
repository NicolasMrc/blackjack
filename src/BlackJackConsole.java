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

        for(Card c : tab) { // For each card
            System.out.println("This card is a "+c+ " worth "+c.getPoints()+ " points");
            System.out.print("It's a ");
            switch(c.getColorSymbole()) { // Ok from Java 1.7
                case "♥": System.out.print("heart"); break;
                case "♠": System.out.print("spade"); break;
                case "♣": System.out.print("club"); break;
                case "♦": System.out.print("diamond"); break;
            }
            if(c.getValueSymbole().matches("[JQK]")) { // Is the value symbole a J or a Q or a K ?
                System.out.println(" and a face !");
            } else {
                System.out.println(" and it's not a face.");
            }
        }
    }

    public static void main(String[] args){
        new BlackJackConsole();
    }
}
