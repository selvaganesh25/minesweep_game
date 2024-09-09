package minesweep;

import javax.swing.JButton;

public class CellButton extends JButton {
    private final int row;
    private final int col;

    public CellButton(int row, int col) {
        this.row = row;
        this.col = col;
        setPreferredSize(new java.awt.Dimension(30, 30));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

