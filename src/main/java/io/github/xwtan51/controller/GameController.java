package io.github.xwtan51.controller;

import io.github.xwtan51.model.*;
import io.github.xwtan51.view.*;
import java.util.Scanner;

public class GameController {
    private final Board board;
    private Player currentPlayer;
    private Player otherPlayer;
    private final Scanner scanner = new Scanner(System.in);

    public GameController(Board board, Player player1, Player player2) {
        this.board = board;
        this.currentPlayer = player1;
        this.otherPlayer = player2;
    }

    public void startGame() {
        while (!board.isFull()) {
            ConsoleView.clearScreen();
            ConsoleView.displayBoard(board);
            ConsoleView.displayPlayers(currentPlayer, otherPlayer);

            boolean validMove = false;
            while (!validMove) {
                System.out.print("请玩家[" + currentPlayer.getName() + "]输入落子位置（如1a）：");
                String input = scanner.nextLine().trim();

                if (input.length() != 2) {
                    System.out.println("输入格式错误，请重新输入！");
                    continue;
                }

                int row = input.charAt(0) - '1';
                int col = input.charAt(1) - 'a';

                if (board.placePiece(row, col, currentPlayer.getPiece())) {
                    validMove = true;
                } else if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
                    System.out.println("非法位置！");
                } else {
                    System.out.println("已经有棋子了！");
                }
            }
            // 交换执棋方
            Player temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
        }

        // 若棋盘已填满
        ConsoleView.clearScreen();
        ConsoleView.displayBoard(board);
        System.out.println("棋盘已满，游戏结束！");
    }
}