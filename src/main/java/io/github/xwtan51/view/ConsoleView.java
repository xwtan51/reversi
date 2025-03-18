package io.github.xwtan51.view;

import io.github.xwtan51.model.*;
import java.io.IOException;

public class ConsoleView {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("清屏失败：" + e.getMessage());
            Thread.currentThread().interrupt(); // 重新设置线程中断状态
        }
    }

    public static void displayBoard(Board board) {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < board.getSize(); i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(board.getGrid()[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void displayPlayers(Player currentPlayer, Player otherPlayer) {
        if (currentPlayer.getPiece() == Piece.BLACK) {
            System.out.println("玩家[" + currentPlayer.getName() + "] " + currentPlayer.getPiece());
            System.out.println("玩家[" + otherPlayer.getName() + "] ");
        } else {
            System.out.println("玩家[" + otherPlayer.getName() + "] ");
            System.out.println("玩家[" + currentPlayer.getName() + "] " + currentPlayer.getPiece());
        }
    }
}