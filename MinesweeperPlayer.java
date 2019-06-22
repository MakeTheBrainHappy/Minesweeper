/*
    Description: Allows the player to interact with the minesweeper game.
    Author: Theo N.
    Contributors: n/a
    Date: 2/12/19
*/

import java.util.Scanner;

public class MinesweeperPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter three positive constants (the # of rows | the # of columns | the # of mines): ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int mines = sc.nextInt();
        System.out.println("Please note that mines are represented by the # 9 while -1 refers to 'hidden' spaces");
        System.out.println("");
        MinesweeperGame game = new MinesweeperGame(rows, columns, mines); // Creates the game
        System.out.println("");
        System.out.println("Let's get started!");
        int x = 0;
        while (x != -1) { // Actually plays the game
            System.out.println("");
            System.out.println("Please select a row | column to examine (zero-based indexing please): ");
            int inputRow = sc.nextInt();
            int inputColumn = sc.nextInt();
            int y = game.playerInteract(inputRow, inputColumn); // User input to select square
            if (y == 2) { // Response System: Win, Hit or Miss
                System.out.println("");
                System.out.println("You have hit a mine!");
                System.out.println("");
                game.getBoard();
                System.out.println("Game over");
                System.exit(0); // Exits after the game is complete
            }
            if (y == 1) {
                System.out.println("");
                System.out.println("You won! Congratulations");
                System.out.println("");
                game.getBoard();
                System.out.println("Game over");
                System.exit(0); // Exits after the game is complete
            }
            if (y == 0) {
                System.out.println("");
                System.out.println("Here is the board for reference. Play you next move wisely.");
                System.out.println("");
                game.getVisibleBoard(); // Continues if the game has not been completed. 
            }
        }
    }
}
