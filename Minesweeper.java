package minesweep;

import javax.swing.JFrame;

public class Minesweeper {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        
        GameBoard gameBoard = new GameBoard();
        frame.add(gameBoard);
        
        frame.setVisible(true);
    }
}
