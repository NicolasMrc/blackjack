import BlackJack.BlackJack;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BlackJackTable extends JPanel {
/*
    private Graphics graphics;
    private java.awt.Color LIGHT_GREY = new java.awt.Color(183,183,183);
    private java.awt.Color LIGHT_BLUE = new java.awt.Color(44, 55, 72);
    private java.awt.Color BLUE = new java.awt.Color(35, 42, 55);
    private java.awt.Color MEDIUM_BLUE = new java.awt.Color(30,38,50);
    private java.awt.Color DARK_BLUE = new java.awt.Color(17, 24, 35);

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.graphics = g;
        this.graphics.setColor(this.MEDIUM_BLUE);
        this.graphics.fillRect(0, 0, 200, 720);
        this.graphics.setColor(this.LIGHT_BLUE);
        this.graphics.fillRect(200, 0, 1080, 720);
        this.graphics.fillRect(0, 50, 200, 2);
        this.graphics.fillRect(0, 100, 200, 2);
        this.graphics.fillRect(0, 150, 200, 2);
        this.graphics.fillRect(200, 0, 1080, 720);
        this.graphics.setColor(this.DARK_BLUE);
        this.graphics.fillRect(0, 660, 200, 40);

        this.drawPlayerButton();
        this.drawString();
    }

    public void drawPlayerButton(){
        this.graphics.setColor(this.MEDIUM_BLUE);
        this.graphics.fillRect(555, 600, 150, 40);
        this.graphics.fillRect(755, 600, 150, 40);
        Font font = new Font("Helvetica Neue", Font.PLAIN, 22);
        this.graphics.setColor(this.LIGHT_GREY);
        this.graphics.drawString("Draw", 615, 625);
        this.graphics.drawString("Stand", 815, 625);
    }

    public void drawString(){
        Graphics2D g2 = (Graphics2D)this.graphics;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.setRenderingHints(rh);

        this.graphics.setColor(this.LIGHT_GREY);
        Font font = new Font("Helvetica Neue", Font.PLAIN, 22);
        this.graphics.setFont(font);
        this.graphics.drawString("BlackJack", 40, 35);
        this.graphics.drawString("Bank", 700, 35);
        this.graphics.drawString("Player", 700, 675);
        font = new Font("Helvetica Neue", Font.PLAIN, 15);
        this.graphics.setFont(font);
        this.graphics.drawString("Player best", 10, 130);
        this.graphics.drawString("Bank best", 10, 80);
        this.graphics.drawString("Reset", 80, 685);
    }




    public void drawCard(LinkedList<BlackJack.Card> cards, boolean player){
        int posY;
        if(player) {
            this.graphics.setColor(new java.awt.Color(35, 42, 55));
            this.graphics.fillRect(200, 360, 1080, 230);
            posY = 375;
        } else{
            this.graphics.setColor(this.BLUE);
            this.graphics.fillRect(200, 70, 1080, 230);
            posY = 85;
        }

        for(BlackJack.Card card : cards){
            try {
                Image img = ImageIO.read(new File("images/" + card.getValueSymbole() + "_" + card.getColorName() + ".png"));
                this.graphics.drawImage(img, findPosX(cards.size(), cards.indexOf(card)), posY, this);
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
            return (660 - (nbCard - 1)  * 80) + (index * 160);
    }
}