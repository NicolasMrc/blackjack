package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Le panel de coté contenant le titre du jeu et les score des joueurs
 * Created by Nico on 11/11/2016.
 */
public class SidePanel extends JPanel {

    /**
     * constante de couleur pour le bleu median utilisé
     */
    private java.awt.Color MEDIUM_BLUE = new java.awt.Color(30,38,50);

    /**
     * constante de couleur pour le bleu clair affiché
     */
    private java.awt.Color LIGHT_BLUE = new java.awt.Color(44, 55, 72);

    /**
     * constante de couleur pour le gris utilisé por les fonts
     */
    private java.awt.Color LIGHT_GREY = new java.awt.Color(183,183,183);

    /**
     * les score du joueur et de la bank
     */
    private String playerBest, bankBest;

    /**
     * constraucteur du SidePanel
     * @param bankBest
     *      le score de la bank
     * @param playerBest
     *      le score du joueur
     */
    public SidePanel(int bankBest, int playerBest){
        this.bankBest = String.valueOf(bankBest);
        this.playerBest = String.valueOf(playerBest);
    }

    /**
     * methode appelée quand le panel est dessiné
     * @param g
     *      graphics
     */
    public void paintComponent(Graphics g){
        g.setColor(this.MEDIUM_BLUE);
        g.fillRect(0, 0, 200, 720);

        g.setColor(this.LIGHT_BLUE);
        g.fillRect(0, 50, 200, 2);
        g.fillRect(0, 100, 200, 2);
        g.fillRect(0, 150, 200, 2);

        //Voodoo pour l'antialiasing des fonts
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.setRenderingHints(rh);

        this.drawBest(g);
        this.drawStrings(g);
    }

    /**
     * methode servant a afficher les scores
     * @param g
     *      graphics
     */
    public void drawBest(Graphics g){

        g.setColor(this.MEDIUM_BLUE);
        g.fillRect( 140, 55, 50, 40);
        g.fillRect( 140, 105, 50, 40);

        g.setColor(this.LIGHT_GREY);
        Font font = new Font("Helvetica Neue", Font.PLAIN, 13);
        g.setFont(font);

        int posX;
        if (this.playerBest.length() == 1){
            posX = 170;
        } else {
            posX = 160;
        }
        g.drawString(this.playerBest, posX, 80);
        if (this.bankBest.length() == 1){
            posX = 170;
        } else {
            posX = 160;
        }
        g.drawString(bankBest, posX, 130);
    }

    /**
     * methode servant a afficher les String
     * @param g
     *      graphics
     */
    public void drawStrings(Graphics g){

        g.setColor(this.LIGHT_GREY);
        Font font = new Font("Helvetica Neue", Font.PLAIN, 22);
        g.setFont(font);
        g.drawString("BlackJack", 40, 35);
        font = new Font("Helvetica Neue", Font.PLAIN, 15);
        g.setFont(font);
        g.drawString("Player best", 10, 130);
        g.drawString("Bank best", 10, 80);
    }
}
