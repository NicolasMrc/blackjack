package BlackJack;

import java.util.LinkedList;
import java.util.List;

/**
 * La classe Hand
 * Created by Nico on 08/11/2016.
 */
public class Hand {

    /**
     * la liste des cartes de la main
     */
    private LinkedList<Card> cardList = new LinkedList<>();

    /**
     * methode renvoyant la main sous forme de String
     * @return
     *      la main en String
     */
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

    /**
     * permet d'ajouter une carte a la main
     * @param card
     *      la carte a ajouter
     */
    public void add(Card card){
        this.cardList.add(card);
    }

    /**
     * permet de supprimer toute les cartes de la main
     */
    public void clear(){
        this.cardList.clear();
    }

    /**
     * methode permettant de compter les points possibles d'une main
     * @return
     *      la list des poinst possible
     */
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

    /**
     * permet de calculer les meilleurs points de la main
     * @return
     *      le meilleur score
     */
    public Integer best(){
        Integer best = null;
        for(Integer points : this.count()){
            if (best == null) {
                best = points;
            } else if(best != 21) {
                if (best < points && points <= 21) {
                    best = points;
                }
            }

        }
        System.out.println(this.toString() + " best :" + best);
        return best;
    }

    /**
     * getter de la liste de carte
     * @return
     *      la list de carte
     */
    public LinkedList<Card> getCardList() {
        return cardList;
    }
}
