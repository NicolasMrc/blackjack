package BlackJack;

/**
 * la classe de cartes
 * Created by Nico on 07/11/2016.
 */
public class Card {

    /**
     * la valeur de la carte
     */
    private Value value;

    /**
     * la couleur de la carte
     */
    private Color color;

    /**
     * le constructeur de la carte
     * @param value
     *      la valeur de la carte
     * @param color
     *      la couleur de la carte
     */
    Card(Value value, Color color){
        this.value = value;
        this.color = color;
    }

    /**
     * renvoi la carte sous forme de String
     * @return
     *      la carte
     */
    public String toString(){
        return value.getSymbole() + color.getSymbole();
    }

    /**
     * getter du nom de la couleur
     * @return
     *      le nom de la couleur
     */
    public String getColorName(){
        return this.color.name();
    }

    /**
     * getter du symbole de la couleur
     * @return
     *      le symbole de la couleur
     */
    public String getColorSymbole(){
        return this.color.getSymbole();
    }

    /**
     * getter du symbole de la couleur
     * @return
     *      le symbole de la couleur
     */
    public String getValueSymbole(){
        return this.value.getSymbole();
    }

    /**
     * getter de points
     * @return
     *      les points de la carte
     */
    public int getPoints(){
        return this.value.getPoints();
    }
}
