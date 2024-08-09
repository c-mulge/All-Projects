package com.example.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tictactoeboard extends JFrame {
    private JButton[][] buttons;
    private tictactoegame game;

    public tictactoeboard() {
        game = new tictactoegame();
        buttons = new JButton[3][3];
        setLayout(new GridLayout(3, 3));
        initializeButtons();
        setTitle("Tic-Tac-Toe");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("-");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (game.placeMark(row, col)) {
                            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
                            if (game.checkForWin()) {
                                JOptionPane.showMessageDialog(null, "Player " + game.getCurrentPlayer() + " wins!");
                                resetButtons();
                            } else if (game.isBoardFull()) {
                                JOptionPane.showMessageDialog(null, "The game is a tie!");
                                resetButtons();
                            } else {
                                game.changePlayer();
                            }
                        }
                    }
                });
                add(buttons[i][j]);
            }
        }
    }

    private void resetButtons() {
        game = new tictactoegame();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("-");
            }
        }
    }
}
