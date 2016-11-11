package BlackJack;

/**
 * Created by Nico on 08/11/2016.
 */
public class BlackJack {
    private Deck deck;
    private Hand playerHand;
    private Hand bankHand;
    private boolean gameFinished;

    public BlackJack(){
        this.deck = new Deck(2);
        this.playerHand = new Hand();
        this.bankHand = new Hand();
        this.gameFinished = false;
        this.reset();
    }

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

    public String getPlayerHandString(){
        return this.playerHand.toString();
    }

    public String getBankHandString(){
        return this.bankHand.toString();
    }

    public Hand getPlayerHand(){return this.playerHand;}

    public Hand getBankHand(){
        return this.bankHand;
    }

    public int getPlayerBest(){
        return this.playerHand.best();
    }

    public int getBankBest(){
        return this.bankHand.best();
    }

    public boolean isPlayerWinner(){
        if(this.getPlayerBest() <= 21 && ((this.getBankBest() < this.getPlayerBest() && (this.getBankBest() != 21 && this.getPlayerBest() != 21)) || this.getBankBest() > 21)){
            return true;
        } else return false;
    }

    public boolean isBankWinner(){
        if(this.getBankBest() <= 21 && ((this.getPlayerBest() < this.getBankBest() && (this.getPlayerBest() != 21 && this.getBankBest() != 21)) || this.getPlayerBest() > 21)){
            return true;
        } else return false;
    }

    public boolean isGameFinished(){
        if(this.gameFinished){
            return true;
        } else {
            return false;
        }
    }

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
