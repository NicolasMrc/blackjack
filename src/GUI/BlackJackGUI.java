package GUI;

import BlackJack.BlackJack;
import BlackJack.Hand;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nico on 09/11/2016.
 */
public class BlackJackGUI implements ActionListener{

    private BlackJack blackJack;
    private JFrame bjframe;
    private JPanel table;

    private JButton btnDraw;
    private JButton btnStand;

    public BlackJackGUI(){

        this.btnDraw = new JButton("Draw");
        this.btnDraw.setActionCommand("draw");
        this.btnDraw.addActionListener(this);
        this.btnDraw.setBounds(0,100,200,30);

        this.btnStand = new JButton("Stand");
        this.btnStand.setActionCommand("stand");
        this.btnStand.addActionListener(this);
        this.btnStand.setBounds(0,100,200,30);

        this.bjframe = new JFrame();
        this.bjframe.setTitle("BlackJack");
        this.bjframe.setMinimumSize(new Dimension(1280, 720));
        this.bjframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.blackJack = new BlackJack();

        this.bjframe.setLayout(new BorderLayout());

        this.bjframe.add(initSidePanel(), BorderLayout.WEST);

        this.table = new JPanel();
        this.table.setLayout(new BorderLayout());
        this.table.add(initPlayerPanel(), BorderLayout.SOUTH);
        this.table.add(initBankPanel(), BorderLayout.NORTH);

        this.bjframe.add(table, BorderLayout.EAST);

        this.bjframe.setVisible(true);
    }

    public static void main(String[] args){
        new BlackJackGUI();
    }

    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "reset":
                this.blackJack.reset();
                bjframe.add(initSidePanel(), BorderLayout.WEST);
                this.table = new JPanel();
                table.setLayout(new BorderLayout());
                table.add(initPlayerPanel(), BorderLayout.SOUTH);
                table.add(initBankPanel(), BorderLayout.NORTH);
                bjframe.add(table, BorderLayout.EAST);
                bjframe.setVisible(true);
                break;
            case "draw":
                if(!this.blackJack.isGameFinished()) {
                    blackJack.playerDrawAnotherCard();

                    if (blackJack.getPlayerBest() > 21) {
                        table.add(initLoosePanel(this.blackJack.getPlayerHand(), false), BorderLayout.SOUTH);
                        table.add(initWinnerPanel(this.blackJack.getBankHand(), true), BorderLayout.NORTH);
                        table.revalidate();
                    } else if (blackJack.getPlayerBest() == 21) {
                        table.add(initBlackJackPanel(this.blackJack.getPlayerHand(), false), BorderLayout.SOUTH);
                        table.add(initLoosePanel(this.blackJack.getBankHand(), true), BorderLayout.NORTH);
                    } else {
                        table.add(initPlayerPanel(), BorderLayout.SOUTH);
                    }
                    bjframe.add(table, BorderLayout.EAST);
                    bjframe.add(initSidePanel(), BorderLayout.WEST);
                    bjframe.setVisible(true);
                }
                break;
            case "stand":
                if(!this.blackJack.isGameFinished()) {
                    this.blackJack.bankLastTurn();

                    if (blackJack.getBankBest() > 21) {
                        table.add(initLoosePanel(this.blackJack.getBankHand(), true), BorderLayout.NORTH);
                        table.add(initWinnerPanel(this.blackJack.getPlayerHand(), false), BorderLayout.SOUTH);
                        table.revalidate();
                    } else if (blackJack.getBankBest() == 21) {
                        table.add(initBlackJackPanel(this.blackJack.getBankHand(), true), BorderLayout.NORTH);
                        table.add(initLoosePanel(this.blackJack.getPlayerHand(), false), BorderLayout.SOUTH);
                    } else {
                        table.add(initWinnerPanel(this.blackJack.getBankHand(), true), BorderLayout.NORTH);
                        table.add(initLoosePanel(this.blackJack.getPlayerHand(), false), BorderLayout.SOUTH);
                    }
                    bjframe.add(table, BorderLayout.EAST);
                    bjframe.add(initSidePanel(), BorderLayout.WEST);
                    bjframe.setVisible(true);
                }
                break;
        }
    }

    private SidePanel initSidePanel(){

        SidePanel sidePanel = new SidePanel(blackJack.getPlayerBest(), blackJack.getBankBest());
        sidePanel.setPreferredSize(new Dimension(200, 720));

        JButton btnReset = new JButton("Reset");
        btnReset.setActionCommand("reset");
        btnReset.addActionListener(this);
        btnReset.setBounds(0,650,200,50);

        JPanel resetPanel = new JPanel();
        resetPanel.setBackground(new Color(17, 21, 28));
        resetPanel.setPreferredSize(new Dimension(200, 50));
        resetPanel.add(btnReset);

        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(resetPanel, BorderLayout.SOUTH);

        return sidePanel;
    }

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

    private BankPanel initBankPanel(){
        BankPanel bankPanel = new BankPanel(this.blackJack.getBankHand());
        bankPanel.setPreferredSize(new Dimension(1080, 360));

        return bankPanel;
    }

    private EndPanel initLoosePanel(Hand hand, boolean isBank){
        EndPanel endPanel = new EndPanel("loose", hand, isBank);
        endPanel.setPreferredSize(new Dimension(1080, 360));

        return endPanel;
    }

    private EndPanel initBlackJackPanel(Hand hand, boolean isBank){
        EndPanel endPanel = new EndPanel("blackjack", hand, isBank);
        endPanel.setPreferredSize(new Dimension(1080, 360));

        return endPanel;
    }

    private EndPanel initWinnerPanel(Hand hand, boolean isBank){
        EndPanel endPanel = new EndPanel("winner", hand, isBank);
        endPanel.setPreferredSize(new Dimension(1080, 360));

        return endPanel;
    }
}
