import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Nico on 08/11/2016.
 */
public class Deck {
    private LinkedList<Card> cards = new LinkedList<>();

    Deck(int nbBox){
        for(int i = 0; i < nbBox;i++){
            for (Color color : Color.values()){
                for(Value value : Value.values()){
                    cards.add(new Card(value, color));
                }
            }
        }
        this.shuffle();
    }

    public Card draw() throws EmptyDeckException {
        if(this.cards.size() > 0){
            return this.cards.pollFirst();
        } else {
            throw new EmptyDeckException();
        }
    }

    public String toString(){
        String deck = "[";
        for(Card card : this.cards){
            deck += card.toString();
            if (cards.indexOf(card) < this.cards.size() - 1){
                deck += ", ";
            }
        }
        deck += "]";
        return deck;
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }
}
