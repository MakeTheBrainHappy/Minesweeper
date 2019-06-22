/*
    Description: The actual mine sweeper game.
    Author: Theo N.
    Contributors: n/a
    Date: 2/12/19
*/

public class MinesweeperGame {
    private int rows;
    private int columns;
    private int mines;
    private int board[][];
    private int visibleBoard[][];

    public MinesweeperGame(int inputRows, int inputColumns, int inputMines) { // Service Constructor
        rows = inputRows;
        columns = inputColumns;
        mines = inputMines;
        visibleBoard = new int[rows][columns];
        board = this.createBoard();
        board = populateBoard(board);
        visibleBoard();
    }

    public int playerInteract(int inputRow, int inputColumn) { // Determines the result of an interaction with the board and changes all components appropriately
        if (board[inputRow][inputColumn] == 9) {
            return 2;
        }
        else {
            visibleBoard[inputRow][inputColumn] = board[inputRow][inputColumn];
        }
        for (int i = 0; i< rows; i++) { // Checks for a win, if they haven't won yet, then they need to keep playing
            for (int j = 0; j < columns; j++) {
                if (board[i][j] != 9) {
                    if (visibleBoard[i][j] == board[i][j]) {
                        visibleBoard[i][j] = visibleBoard[i][j];
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public void getVisibleBoard() {
        printBoard(visibleBoard);
    } // Calls the "visible" board, i.e. what the player can see
    public void getBoard() {
        printBoard(board);
    } // Calls the master board with all of the answers

    private int[][] createBoard(){ // Helper Method to instantiate the board
        int temp[][] = new int[rows][columns];
        return temp;
    }

    private int[][] populateBoard(int inputBoard[][]) { // Helper Method to randomly place mines
        while (mines != 0) {
            int a = (int)(Math.random()*rows);
            int b = (int)(Math.random()*columns);
            if (inputBoard[a][b] == 0) {
                inputBoard[a][b] = 9;
                mines -= 1;
            }
        }

        for(int i = 0; i < rows; i++) { // This section then assigns each space of number based on the surrounding mines.
            for (int j = 0; j < columns; j++) {
                if (inputBoard[i][j] != 9) {
                    int tempMines = 0;
                    if ((j - 1) != -1) {
                        if (inputBoard[i][j - 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1) {
                        if (inputBoard[i - 1][j] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1 && (j - 1) != -1) {
                        if (inputBoard[i - 1][j - 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1 && (j + 1) != columns) {
                        if (inputBoard[i - 1][j + 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows) {
                        if (inputBoard[i + 1][j] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((j + 1) != columns) {
                        if (inputBoard[i][j + 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows && (j + 1) != columns) {
                        if (inputBoard[i + 1][j + 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows && (j - 1) != -1) {
                        if (inputBoard[i + 1][j - 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    inputBoard[i][j] = tempMines;
                }
            }
        }
        return (inputBoard);
    }

    private void printBoard(int inputBoard[][]) { // Prints the board in a neat matrix fashion
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(inputBoard[i][j] + "   ");
            }
            System.out.println();
        }
    }

    private void visibleBoard() { // Generates a blank "visible board"
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                visibleBoard[i][j] = -1;
            }
        }
        printBoard(visibleBoard);
    }

}
