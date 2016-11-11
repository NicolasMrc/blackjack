package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nico on 11/11/2016.
 */
public class SidePanel extends JPanel {

    private java.awt.Color MEDIUM_BLUE = new java.awt.Color(30,38,50);
    private java.awt.Color LIGHT_BLUE = new java.awt.Color(44, 55, 72);
    private java.awt.Color LIGHT_GREY = new java.awt.Color(183,183,183);
    private String playerBest, bankBest;

    public SidePanel(int bankBest, int playerBest){
        this.bankBest = String.valueOf(bankBest);
        this.playerBest = String.valueOf(playerBest);
    }

    public void paintComponent(Graphics g){
        g.setColor(this.MEDIUM_BLUE);
        g.fillRect(0, 0, 200, 720);

        g.setColor(this.LIGHT_BLUE);
        g.fillRect(0, 50, 200, 2);
        g.fillRect(0, 100, 200, 2);
        g.fillRect(0, 150, 200, 2);

        this.drawBest(g);
        this.drawStrings(g);
    }

    public void drawBest(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.setRenderingHints(rh);

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

    public void drawStrings(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.setRenderingHints(rh);

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
