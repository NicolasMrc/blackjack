import java.util.LinkedList;
import java.util.List;

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

        hand += " : [";
        List<Integer> points = this.count();
        for (Integer point : points){
            hand += point;
            if (points.indexOf(point) < points.size() - 1) {
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

    public List<Integer> count(){
        LinkedList<Integer> score = new LinkedList<>();
        score.add(0);
        for (Card card : this.cardList){
            for (int i = 0; i < score.size() ; i++){
                int val = score.get(i);
                score.set(i, score.get(i) + card.getPoints());
                if (card.getPoints() == 1){
                    score.add(val + 11);
                    break;
                }
            }
        }
        return score;
    }

    public Integer best(){
        Integer best = null;
        for(Integer points : this.count()){
            if (best == null) {
                best = points;
            } else if(best != 21) {
                if (best > points) {
                    best = points;
                }
            }

        }
        return best;
    }
}
