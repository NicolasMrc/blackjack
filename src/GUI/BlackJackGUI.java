package GUI;

import BlackJack.BlackJack;
import BlackJack.Hand;
import BlackJack.EmptyDeckException;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe d'interface graphique du BlackJack
 * Created by Nico on 09/11/2016.
 */
public class BlackJackGUI implements ActionListener{

    /**
     * instance du jeu de blackjack
     */
    private BlackJack blackJack;

    /**
     * JFrame du jeu de blackjack dans laquelle tout les element seront imbriqués
     */
    private JFrame bjframe;

    /**
     * panel gauche contenant les main de la bank et du joueur
     */
    private JPanel table;

    /**
     * boutton servant a demander une nouvelle carte
     */
    private JButton btnDraw;

    /**
     * boutton servant a rester sur son score actuel
     */
    private JButton btnStand;

    /**
     * panel contenant le bouton de reinitialisation
     */
    private JPanel resetPanel;

    /**
     * methode servant a initialiser tout les élèments de la fenetre
     */
    public BlackJackGUI(){

        this.btnDraw = this.initButton("Draw", new Color(35, 42, 55), new Dimension(150, 50));
        this.btnStand = this.initButton("Stand", new Color(35, 42, 55), new Dimension(150, 50));
        JButton btnReset = initButton("Reset", new Color(17, 21, 28), new Dimension(150, 40));

        this.resetPanel = new JPanel();
        this.resetPanel.setBackground(new Color(17, 21, 28));
        this.resetPanel.setPreferredSize(new Dimension(200, 50));
        this.resetPanel.add(btnReset);

        this.bjframe = new JFrame();
        this.bjframe.setTitle("BlackJack");
        this.bjframe.setMinimumSize(new Dimension(1280, 720));
        this.bjframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try{
            this.blackJack = new BlackJack();
        } catch (EmptyDeckException e){
            System.exit(-1);
        }

        this.bjframe.setLayout(new BorderLayout());

        this.bjframe.add(initSidePanel(), BorderLayout.WEST);

        this.table = new JPanel();
        this.table.setLayout(new BorderLayout());
        this.table.add(initPlayerPanel(), BorderLayout.SOUTH);
        this.table.add(initBankPanel(), BorderLayout.NORTH);

        this.bjframe.add(table, BorderLayout.EAST);

        this.bjframe.setVisible(true);
    }

    /**
     * main lancant le constructeur
     * @param args
     *      les arguments
     */
    public static void main(String[] args){
        new BlackJackGUI();
    }

    /**
     * methode servant a definir les actions des différents boutons de la vue
     * @param e
     *      evenement enclenché
     */
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "reset":
                this.reset();
                break;
            case "draw":
                this.draw();
                break;
            case "stand":
                this.stand();
                break;
        }
    }

    /**
     * methode permettant d'initialiser le panel de coté contenant les score et le nom du jeu
     * @return
     *      le SidePanel
     */
    private SidePanel initSidePanel(){

        SidePanel sidePanel = new SidePanel(blackJack.getPlayerBest(), blackJack.getBankBest());
        sidePanel.setPreferredSize(new Dimension(200, 720));

        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(this.resetPanel, BorderLayout.SOUTH);

        return sidePanel;
    }

    /**
     * methode permettant d'initialiser le panel du joueur
     * @return
     *      une instance de PlayerPanel
     */
    private PlayerPanel initPlayerPanel(){
        PlayerPanel playerPanel = new PlayerPanel(blackJack.getPlayerHand());
        playerPanel.setPreferredSize(new Dimension(1080, 360));

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnDraw);
        btnPanel.add(btnStand);
        btnPanel.setPreferredSize(new Dimension(1080, 110));
        btnPanel.setBackground(new Color(44, 55, 72));

        playerPanel.setLayout(new BorderLayout());
        playerPanel.add(btnPanel, BorderLayout.SOUTH);
        return playerPanel;
    }

    /**
     * methode permettant d'initialiser le pannel de la bank
     * @return
     *      une instance de bankPannel
     */
    private BankPanel initBankPanel(){
        BankPanel bankPanel = new BankPanel(this.blackJack.getBankHand());
        bankPanel.setPreferredSize(new Dimension(1080, 360));

        return bankPanel;
    }

    /**
     * methode permettant de retourner les panels de finde partie
     * @param hand
     *      la main devrant etre affichée
     * @param isBank
     *      true si le panel de fin a dessiner est celui de la bank
     *      false si c'est celui du joueur
     * @param endType
     *      le type de fin : loser, winner, blackjack
     * @return
     *      une instance de EndPanel
     */
    private EndPanel initEndPanel(Hand hand, boolean isBank, String endType){
        EndPanel endPanel = new EndPanel(endType, hand, isBank);
        endPanel.setPreferredSize(new Dimension(1080, 360));

        if (!isBank){
            JPanel btnPanel = new JPanel();
            btnPanel.add(btnDraw);
            btnPanel.add(btnStand);
            btnPanel.setPreferredSize(new Dimension(1080, 110));
            btnPanel.setBackground(new Color(44, 55, 72));

            endPanel.setLayout(new BorderLayout());
            endPanel.add(btnPanel, BorderLayout.SOUTH);
        }

        return endPanel;
    }

    /**
     * methode permettant d'initialiser les boutons de la vue
     * @param buttonName
     *      le nom du bouton affiché
     * @param color
     *      la couleur du bouton
     * @param dimension
     *      les dimensions du boutons
     * @return
     *      le bouton
     */
    private JButton initButton(String buttonName, Color color, Dimension dimension){
        JButton btn = new JButton(buttonName);
        btn.setActionCommand(buttonName.toLowerCase());
        btn.addActionListener(this);
        btn.setOpaque(true);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(dimension);
        btn.setBorderPainted(false);

        return  btn;
    }

    /**
     * méthode servant a reinitialiser dans le cas d'une nouvelle partie
     */
    public void reset(){
        try{
            this.blackJack.reset();
        } catch (EmptyDeckException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        bjframe.add(initSidePanel(), BorderLayout.WEST);
        this.table = new JPanel();
        table.setLayout(new BorderLayout());
        table.add(initPlayerPanel(), BorderLayout.SOUTH);
        table.add(initBankPanel(), BorderLayout.NORTH);
        bjframe.add(table, BorderLayout.EAST);
        bjframe.setVisible(true);
        this.btnStand.setEnabled(true);
        this.btnDraw.setEnabled(true);
    }

    /**
     * méthode servant au joueur pour piocher une nouvelle carte dans le deck
     */
    public void draw(){
        if(!this.blackJack.isGameFinished()) {
            blackJack.playerDrawAnotherCard();

            if (blackJack.getPlayerBest() > 21) {
                this.btnStand.setEnabled(false);
                this.btnDraw.setEnabled(false);
                table.add(initEndPanel(this.blackJack.getPlayerHand(), false, "loser"), BorderLayout.SOUTH);
                table.add(initEndPanel(this.blackJack.getBankHand(), true, "winner"), BorderLayout.NORTH);
                table.revalidate();
            } else if (blackJack.getPlayerBest() == 21) {
                this.blackJack.bankLastTurn();
                this.btnStand.setEnabled(false);
                this.btnDraw.setEnabled(false);
                if(this.blackJack.getBankBest() == 21){
                    table.add(initEndPanel(this.blackJack.getPlayerHand(), false, "draw"), BorderLayout.SOUTH);
                    table.add(initEndPanel(this.blackJack.getBankHand(), true, "draw"), BorderLayout.NORTH);
                } else {
                    table.add(initEndPanel(this.blackJack.getPlayerHand(), false, "blackjack"), BorderLayout.SOUTH);
                    table.add(initEndPanel(this.blackJack.getBankHand(), true, "loser"), BorderLayout.NORTH);
                }
            }  else if (blackJack.getBankBest() == blackJack.getPlayerBest()) {
                this.btnStand.setEnabled(false);
                this.btnDraw.setEnabled(false);
                table.add(initEndPanel(this.blackJack.getBankHand(), true, "draw"), BorderLayout.NORTH);
                table.add(initEndPanel(this.blackJack.getPlayerHand(), false, "draw"), BorderLayout.SOUTH);
            } else {
                table.add(initPlayerPanel(), BorderLayout.SOUTH);
            }
            bjframe.add(table, BorderLayout.EAST);
            bjframe.add(initSidePanel(), BorderLayout.WEST);
            bjframe.setVisible(true);
        }
    }

    /**
     * methode appellée quand le joueur reste sur son score
     */
    public void stand(){
        if(!this.blackJack.isGameFinished()) {
            this.blackJack.bankLastTurn();

            if (blackJack.getBankBest() == blackJack.getPlayerBest()) {
                this.btnStand.setEnabled(false);
                this.btnDraw.setEnabled(false);
                table.add(initEndPanel(this.blackJack.getBankHand(), true, "draw"), BorderLayout.NORTH);
                table.add(initEndPanel(this.blackJack.getPlayerHand(), false, "draw"), BorderLayout.SOUTH);
            } else if (blackJack.getBankBest() > 21) {
                this.btnStand.setEnabled(false);
                this.btnDraw.setEnabled(false);
                table.add(initEndPanel(this.blackJack.getBankHand(), true, "loser"), BorderLayout.NORTH);
                table.add(initEndPanel(this.blackJack.getPlayerHand(), false, "winner"), BorderLayout.SOUTH);
                table.revalidate();
            } else if (blackJack.getBankBest() == 21) {
                this.btnStand.setEnabled(false);
                this.btnDraw.setEnabled(false);
                table.add(initEndPanel(this.blackJack.getBankHand(), true, "blackjack"), BorderLayout.NORTH);
                table.add(initEndPanel(this.blackJack.getPlayerHand(), false, "loser"), BorderLayout.SOUTH);
            } else {
                this.btnStand.setEnabled(false);
                this.btnDraw.setEnabled(false);
                table.add(initEndPanel(this.blackJack.getBankHand(), true, "winner"), BorderLayout.NORTH);
                table.add(initEndPanel(this.blackJack.getPlayerHand(), false, "loser"), BorderLayout.SOUTH);
            }
            bjframe.add(table, BorderLayout.EAST);
            bjframe.add(initSidePanel(), BorderLayout.WEST);
            bjframe.setVisible(true);
        }
    }
}
