package io.github.xwtan51;

import io.github.xwtan51.controller.*;
import io.github.xwtan51.model.*;


public class Main {
    public static void main(String[] args) {
        Board board = new Board(8);
        Player player1 = new Player("张三", Piece.BLACK);
        Player player2 = new Player("李四", Piece.WHITE);

        GameController gameController = new GameController(board, player1, player2);
        gameController.startGame();
    }
}