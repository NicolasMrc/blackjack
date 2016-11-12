package BlackJack;

/**
 * Classe d'énumeration de valeurs
 * Created by Nico on 07/11/2016.
 */
public enum Value {
    AS("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    HEIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    /**
     * le symbole
     */
    private String symbole;

    /**
     * le nombre de point
     */
    private int points;

    /**
     * constructeur
     * @param symbole
     *      le symbole
     * @param points
     *      les points
     */
    Value(String symbole, int points){
        this.symbole = symbole;
        this.points = points;
    }

    /**
     * le getter de symbole
     * @return
     *      le symbole
     */
    public String getSymbole() {
        return symbole;
    }

    /**
     * le getrter de points
     * @return
     *      les points
     */
    public int getPoints() {
        return points;
    }
}
