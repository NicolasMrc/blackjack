package BlackJack;

/**
 * Classe de couleur
 * Created by Nico on 07/11/2016.
 */
public enum Color {

    HEART("\u2665"),
    SPADE("\u2660"),
    CLUB("\u2663"),
    DIAMOND("\u2666");

    /**
     * le symbole de la couleur
     */
    private String symbole;

    /**
     * getter du symbole
     * @return
     *      le symbole
     */
    public String getSymbole() {
        return symbole;
    }

    /**
     * constructeur de la couleur
     * @param symbole
     *      le symbole
     */
    Color(String symbole){
        this.symbole = symbole;
    }
}
