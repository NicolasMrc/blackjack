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
 * Panel d'affichage de la main de la bank
 * Created by Nico on 11/11/2016.
 */
public class BankPanel extends JPanel {

    /**
     * constante de gris clair pour les fonts
     */
    private java.awt.Color LIGHT_GREY = new java.awt.Color(183,183,183);

    /**
     * constante de bleu clair pour le bakcground
     */
    private java.awt.Color LIGHT_BLUE = new java.awt.Color(44, 55, 72);

    /**
     * constante de bleu pour le background
     */
    private java.awt.Color BLUE = new java.awt.Color(35, 42, 55);

    /**
     * la main de la banque
     */
    private Hand bankHand;

    /**
     * constructeur de bankPanel
     * @param bankHand
     *      la main de la bank
     */
    public BankPanel(BlackJack.Hand bankHand){
        this.bankHand = bankHand;
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
        this.drawText(g);
    }

    /**
     * methode appelée pour afficher le nom de la bank en haut du panel
     * @param g
     */
    public void drawText(Graphics g){
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
    public void drawCard(Graphics g){
        int posY;

        g.setColor(this.BLUE);
        g.fillRect(0, 70, 1080, 230);
        posY = 85;

        LinkedList<Card> cards = this.bankHand.getCardList();

        for(Card card : cards){
            try {
                Image img = ImageIO.read(new File("images/" + card.getValueSymbole() + "_" + card.getColorName() + ".png"));
                g.drawImage(img, findPosX(cards.size(), cards.indexOf(card)), posY, this);
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
