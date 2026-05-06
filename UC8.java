import java.util.Scanner;
import java.util.Random;

public class UC8 {

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    public static void main(String[] args) {
        initializeBoard();
        tossAndAssignSymbols();

        while (!gameOver) {
            printBoard();
            if (isHumanTurn) {
                int slot = getUserSlot();
                int row = getRowFromSlot(slot);
                int col = getColFromSlot(slot);

                if (isValidMove(row, col)) {
                    placeMove(row, col, humanSymbol);
                    if (checkWin() || checkDraw()) {
                        gameOver = true;
                    } else {
                        isHumanTurn = false;
                    }
                } else {
                    System.out.println("Slot already taken or invalid. Try again.");
                }
            } else {
                computerMove();
                if (checkWin() || checkDraw()) {
                    gameOver = true;
                } else {
                    isHumanTurn = true;
                }
            }
        }

        printBoard();
        System.out.println("Game Over.");
    }
}