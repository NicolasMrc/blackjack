
import BlackJack.BlackJack;

import java.util.Scanner;

/**
 * Classe d'interface console du blackjack
 * Created by Nico on 07/11/2016.
 */
public class BlackJackConsole {

    /**
     * constructeur
     */
    public  BlackJackConsole(){
        System.out.println("Welcolme to the BlackJack.BlackJack table. Let's play !");

        BlackJack blackJack = new BlackJack();

        System.out.println("The bank draw : " + blackJack.getBankHandString());
        System.out.println("The player draw : " + blackJack.getPlayerHandString());

        while(!blackJack.isGameFinished()){
            String choice;
            System.out.println("Do you want to draw another card ? [y/n]");
            Scanner s = new Scanner(System.in);
            choice = s.next();
            if (choice.equalsIgnoreCase("y")){
                blackJack.playerDrawAnotherCard();
                System.out.println("The player draw : " + blackJack.getPlayerHandString());
                if(blackJack.getPlayerBest() > 21){
                    System.out.println("The bank win you went over 21 !");
                }
            } else if (choice.equalsIgnoreCase("n")){
                blackJack.bankLastTurn();

            }
        }

        if(blackJack.isBankWinner()){
            System.out.println("The bank won !");
        } else if (blackJack.isPlayerWinner()){
            System.out.println("The player won !");
        }
    }

    /**
     * main lancant le constructeur de la classe
     * @param args
     */
    public static void main(String[] args){
        new BlackJackConsole();
    }
}
