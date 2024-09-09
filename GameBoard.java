package minesweep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameBoard extends JPanel {
    private static final int SIZE = 10;
    private static final int NUM_MINES = 10;
    private CellButton[][] buttons;
    private boolean[][] mines;
    private boolean[][] revealed;
    private boolean[][] flagged;
    private boolean gameOver;

    public GameBoard() {
        setLayout(new GridLayout(SIZE, SIZE));
        buttons = new CellButton[SIZE][SIZE];
        mines = new boolean[SIZE][SIZE];
        revealed = new boolean[SIZE][SIZE];
        flagged = new boolean[SIZE][SIZE];
        gameOver = false;

        initializeBoard();
        placeMines();
        updateNumbers();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new CellButton(i, j);
                buttons[i][j].addActionListener(new ButtonClickListener());
                add(buttons[i][j]);
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < NUM_MINES) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (!mines[row][col]) {
                mines[row][col] = true;
                minesPlaced++;
            }
        }
    }

    private void updateNumbers() {
        // Logic to update cell numbers based on adjacent mines
        // Not included here for brevity
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CellButton button = (CellButton) e.getSource();
            int row = button.getRow();
            int col = button.getCol();

            if (gameOver || revealed[row][col] || flagged[row][col]) return;

            if (mines[row][col]) {
                button.setText("*");
                gameOver = true;
                revealAll();
            } else {
                revealCell(row, col);
            }
        }
    }

    private void revealCell(int row, int col) {
        // Recursive cell revealing logic
        // Not included here for brevity
    }

    private void revealAll() {
        // Reveal all cells when game is over
        // Not included here for brevity
    }
}
