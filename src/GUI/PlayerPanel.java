package GUI;

import BlackJack.Card;
import BlackJack.Hand;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Panel du joueur
 * Created by Nico on 11/11/2016.
 */
public class PlayerPanel extends JPanel {
    /**
     * constante de Color pour le bleu clair
     */
    private java.awt.Color LIGHT_BLUE = new java.awt.Color(44, 55, 72);

    /**
     * constante de Color pour le bleu
     */
    private java.awt.Color BLUE = new java.awt.Color(35, 42, 55);

    /**
     * la main du joueur
     */
    private Hand playerHand;

    /**
     * constructeur du playerPanel
     * @param playerHand
     *      la main du joueur a afficher
     */
    public PlayerPanel(Hand playerHand){
        this.playerHand = playerHand;
    }

    /**
     * methode appellée quand le panel est dessiné
     * @param g
     *      graphics
     */
    public void paintComponent(Graphics g){
        g.setColor(this.LIGHT_BLUE);
        g.fillRect(0, 0, 1080, 360);
        this.drawCard(g);
    }


    /**
     * methode permettant de dessiner les cartes du joueur
     * @param g
     *      les graphics
     */
    public void drawCard(Graphics g){
        g.setColor(this.BLUE);
        g.fillRect(0, 10, 1080, 230);

        LinkedList<Card> cards = this.playerHand.getCardList();

        for(Card card : cards){
            try {
                Image img = ImageIO.read(new File("images/" + card.getValueSymbole() + "_" + card.getColorName() + ".png"));
                g.drawImage(img, findPosX(cards.size(), cards.indexOf(card)), 25, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * permet de calculer la position d'affichage de chaque carte en fonction de son index
     * dans la liste de carte ainsi que le nombre de carte dans le deck
     * @param nbCard
     *      le nombre de cartes dans le deck
     * @param index
     *      l'index de la carte dans la liste
     * @return
     *      la position x en pixel a laquelle doit etre afficher la carte
     */
    private int findPosX(int nbCard, int index){
        return (470 - (nbCard - 1)  * 80) + (index * 160);
    }
}
