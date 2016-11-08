/**
 * Created by Nico on 07/11/2016.
 */
public enum Color {

    HEART("\u2665"),
    SPADE("\u2660"),
    CLUB("\u2663"),
    DIAMOND("\u2666");

    private String symbole;

    public String getSymbole() {
        return symbole;
    }

    Color(String symbole){
        this.symbole = symbole;
    }
}
