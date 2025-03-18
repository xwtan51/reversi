package io.github.xwtan51.model;

public class Board {
    private final int size;
    private final Piece[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Piece[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = Piece.EMPTY;
            }
        }
    }

    public boolean placePiece(int row, int col, Piece piece) {
        if (row < 0 || row >= size || col < 0 || col >= size || grid[row][col] != Piece.EMPTY) {
            return false;
        }
        grid[row][col] = piece;
        return true;
    }

    public boolean isFull() {
        for (Piece[] row : grid) {
            for (Piece square : row) {
                if (square == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public Piece[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    } 
}
