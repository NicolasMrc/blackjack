import java.util.LinkedList;

/**
 * Created by Nico on 08/11/2016.
 */
public class Hand {
    LinkedList<Card> cardList = new LinkedList<>();

    public String toString(){
        String hand = "[";
        for(Card card : this.cardList){
            hand += card.toString();
            if (cardList.indexOf(card) < this.cardList.size() - 1){
                hand += ", ";
            }
        }
        hand += "]";
        return hand;
    }

    public void add(Card card){
        this.cardList.add(card);
    }

    public void clear(){
        this.cardList.clear();
    }
}
