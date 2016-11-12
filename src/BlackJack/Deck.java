package BlackJack;

import java.util.Collections;
import java.util.LinkedList;

/**
 * La classe du deck
 * Created by Nico on 08/11/2016.
 */
public class Deck {

    /**
     * la liste de cartes contenus dans le deck
     */
    private LinkedList<Card> cards = new LinkedList<>();

    /**
     * constructeur du deck
     * @param nbBox
     *      le nombre de boite de 52 cartes contenu dans le deck
     */
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

    /**
     * permet de piocher la premiere carte du deck
     * @return
     *      la premiere carte du deck
     * @throws EmptyDeckException
     *      si le deck est vide
     */
    public Card draw() throws EmptyDeckException {
        if(this.cards.size() > 0){
            return this.cards.pollFirst();
        } else {
            throw new EmptyDeckException();
        }
    }

    /**
     * renvoi le deck en String
     * @return
     */
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

    /**
     * permet de mélanger le deck aleatoirement
     */
    public void shuffle(){
        Collections.shuffle(this.cards);
    }
}
