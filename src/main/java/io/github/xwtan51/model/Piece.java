package io.github.xwtan51.model;

public enum Piece {
    EMPTY("·"),
    BLACK("●"),
    WHITE("○");

    private final String symbol;

    Piece(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
