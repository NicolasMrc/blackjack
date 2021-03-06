package BlackJack;

/**
 * Exception quand lancée quand le deck est vide
 * Created by Nico on 08/11/2016.
 */
public class EmptyDeckException extends java.lang.Exception {

    /**
     * constructeur de l'exception
     */
    public EmptyDeckException(){
        System.out.println(this.message);
    }

    /**
     * message d'erreur
     */
    private String message = "Error, the deck has insuffisant amout of cards";

    @Override
    public String getMessage() {
        return message;
    }
}
