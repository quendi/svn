package ui;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;

import domain.Player;
import domain.RobberKnight;

@SuppressWarnings("unused")
public class WinScreen{

    private JFrame frame = new JFrame("Win Screen");

    public WinScreen(RobberKnight game,final GUI gui){

        /**
         *Calculations
         */

        int total = 0;
        int[] playerTotals = game.getTotals();
        int winner = 0;

        for(int i = 0; i < 4; i++){
            if (playerTotals[i] > total){
                total = playerTotals[i];
                winner = i;
            }
        }

        /**
         *Default
         */
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(750, 300, 600, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        /**
         *Display who won game
         */
        JLabel player = new JLabel();
        player.setText("Player ");
        Font font = new Font("Serif", Font.BOLD, 34);
        player.setFont(font);

        JLabel winningPlayer = new JLabel();
        winningPlayer.setText(game.getPlayerByNumber(winner).getName());
        winningPlayer.setFont(font);

        JLabel win = new JLabel();
        win.setText(" Wins!");
        win.setFont(font);

        JPanel winningPanel = new JPanel();
        winningPanel.add(player);
        winningPanel.add(winningPlayer);
        winningPanel.add(win);
        panel.add(winningPanel, BorderLayout.NORTH);

        /**
         *Display Picture
         */
        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon("resources/fireworks.gif"));
        panel.add(pic, BorderLayout.WEST);

        /**
         * Play Sound
         */
        GUI.playSound("resources/YouWin.wav");

        /**
         *Display player scores
         */
        JPanel playerPoints = new JPanel();
        for(int i=0;i<game.getNumPlayers();i++){
            playerPoints.add(new JLabel(game.getPlayerByNumber(i).getName()+"\t:"+playerTotals[i]));
        }
        panel.add(playerPoints, BorderLayout.CENTER);

        /**
         *Add button ActionListeners
         */
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                if(gui!= null && gui.InGame != null)
                    gui.InGame.dispose();
                new PlayerSelection();
            }
        });
        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        /**
         *Add buttons
         */
        newGame.setPreferredSize(new Dimension(110,50));
        quit.setPreferredSize(new Dimension(110,50));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newGame);
        buttonPanel.add(quit);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        /**
         * Add everything to frame
         */
        frame.add(panel);
    }

    /***Testing**
     public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
     new WinScreen(new RobberKnight(0, null, null, null), new GameMenu(true));
     }
     });
     }
     /******/
}
