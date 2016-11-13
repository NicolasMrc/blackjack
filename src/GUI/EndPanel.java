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
 * Panel de fin contenant les "cartes" de fin : winner, loser, blackjack
 * Created by Nico on 11/11/2016.
 */
public class EndPanel extends JPanel {

    /**
     * constante de couleurs de gris clair pour les font
     */
    private final java.awt.Color LIGHT_GREY = new java.awt.Color(183,183,183);

    /**
     * constante de couleur bleu clair pour les background
     */
    private final java.awt.Color LIGHT_BLUE = new java.awt.Color(44, 55, 72);

    /**
     * constante de couleur bleue pour les background
     */
    private final java.awt.Color BLUE = new java.awt.Color(35, 42, 55);

    /**
     * le type de fin
     */
    private String endType;

    /**
     * la main contenant les cartes a afficher
     */
    private Hand hand;

    /**
     * boolean indiquant true si le EndPanel a affiché est celui de la banque
     */
    private boolean isBank;

    /**
     * constructeur
     * @param endType
     *      le type de fin
     * @param hand
     *      la main a afficher
     * @param isBank
     *      indique si le panel est pour la bank ou le joueur
     */
    public EndPanel(String endType, Hand hand, boolean isBank){
        this.endType = endType;
        this.hand = hand;
        this.isBank = isBank;
    }

    /**
     * methode apellée lorsque le panel est dessiné
     * @param g
     *      graphics
     */
    public void paintComponent(Graphics g){
        g.setColor(this.LIGHT_BLUE);
        g.fillRect(0, 0, 1080, 360);

        this.drawCard(g);
        if(this.isBank){
            this.drawBankName(g);
        }
    }

    /**
     * methode permettant de dessiner le nom de la bank en haut du panel
     * si le panel est celui de la banque
     * @param g
     */
    public void drawBankName(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.setRenderingHints(rh);

        g.setColor(this.LIGHT_GREY);
        Font font = new Font("Helvetica Neue", Font.PLAIN, 22);
        g.setFont(font);
        g.drawString("Bank", 510, 40);
    }

    /**
     * permet de dessiner les cartes du joueur et de la banque
     */
    public void drawCard(Graphics g) {

        g.setColor(this.BLUE);

        if(isBank){
            g.fillRect(0, 70, 1080, 230);
        } else {
            g.fillRect(0, 10, 1080, 230);
        }

        LinkedList<Card> cards = this.hand.getCardList();

        int posY;

        if(isBank) {
            posY = 85;
        } else {
            posY = 25;
        }
        for(Card card : cards){
            try {
                Image img = ImageIO.read(new File("images/" + card.getValueSymbole() + "_" + card.getColorName() + ".png"));
                g.drawImage(img, findPosX(cards.size()+1, cards.indexOf(card)), posY, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Image img = ImageIO.read(new File("images/" + endType + ".png"));
            g.drawImage(img, findPosX(cards.size()+1, cards.size()), posY, this);
        } catch (IOException e) {
            e.printStackTrace();
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
