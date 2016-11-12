package BlackJack;

/**
 *Classe du blackjack
 * Created by Nico on 08/11/2016.
 */
public class BlackJack {

    /**
     * le deck
     */
    private Deck deck;

    /**
     * la main du joueur
     */
    private Hand playerHand;

    /**
     * la main de la bank
     */
    private Hand bankHand;

    /**
     * boolean indiquand si le jeu est fini ou non
     */
    private boolean gameFinished;

    /**
     * constructeur de la classe blackjack
     */
    public BlackJack(){
        this.deck = new Deck(2);
        this.playerHand = new Hand();
        this.bankHand = new Hand();
        this.gameFinished = false;
        this.reset();
    }

    /**
     * permet de reinitialiser une partie
     */
    public void reset(){
        this.bankHand.clear();
        this.playerHand.clear();
        this.gameFinished = false;

        try {
            this.bankHand.add(this.deck.draw());
            this.playerHand.add(this.deck.draw());
            this.playerHand.add(this.deck.draw());
        } catch (EmptyDeckException e){
            System.out.println("Error, the deck has insuffisent cards");
            System.exit(-1);
        }
    }

    /**
     * renvoi la main du joueur sous forme de String
     * @return
     *      la main du joueur en String
     */
    public String getPlayerHandString(){
        return this.playerHand.toString();
    }

    /**
     * getter de la main de la bann en String
     * @return
     *      la main de la banque en String
     */
    public String getBankHandString(){
        return this.bankHand.toString();
    }

    /**
     * getter de la main du joueur
     * @return
     *      la main du joueur
     */
    public Hand getPlayerHand(){return this.playerHand;}

    /**
     * getter de la main de la bank
     * @return
     *      la main de la bank
     */
    public Hand getBankHand(){
        return this.bankHand;
    }

    /**
     * getter du best du joueur
     * @return
     *      le meilleur score du joueur
     */
    public int getPlayerBest(){
        return this.playerHand.best();
    }

    /**
     * getter du meilleur score de la bank
     * @return
     *      le champ best de la bank
     */
    public int getBankBest(){
        return this.bankHand.best();
    }

    /**
     * determine si le joueur est gagnant
     * @return
     *  true si le joueur est gagnant
     */
    public boolean isPlayerWinner(){
        if(this.getPlayerBest() <= 21 && ((this.getBankBest() < this.getPlayerBest() && (this.getBankBest() != 21 && this.getPlayerBest() != 21)) || this.getBankBest() > 21)){
            return true;
        } else return false;
    }

    /**
     * determine si la bank est gagnant
     * @return
     *      true si la bank gagne
     */
    public boolean isBankWinner(){
        if(this.getBankBest() <= 21 && ((this.getPlayerBest() < this.getBankBest() && (this.getPlayerBest() != 21 && this.getBankBest() != 21)) || this.getPlayerBest() > 21)){
            return true;
        } else return false;
    }

    /**
     * determine si le jeu est fini
     * @return
     *  true si le jeu est fini
     */
    public boolean isGameFinished(){
        if(this.gameFinished){
            return true;
        } else {
            return false;
        }
    }

    /**
     * permet de faire piocher au joueur une nouvelle carte
     */
    public void playerDrawAnotherCard(){
        try {
            this.playerHand.add(this.deck.draw());
            if (this.playerHand.best() > 21) {
                this.gameFinished = true;
            }
        } catch (EmptyDeckException e){
            System.out.println("Error, the deck has insuffisent cards");
            System.exit(-1);
        }
    }

    /**
     * permet de faire piocher a la bank lorsque le joueur Stand
     */
    public void bankLastTurn(){
        if(!this.gameFinished){
            while(!this.isGameFinished()){
                try{
                    this.bankHand.add(this.deck.draw());
                    System.out.println("The bank draw : " + this.getBankHandString());
                } catch (EmptyDeckException e){
                    System.out.println("Error, the deck has insuffisent cards");
                    System.exit(-1);
                }
                if(this.isBankWinner() || this.getBankBest() > 21){
                    this.gameFinished = true;
                }
            }
        }
    }
}
