/**
 * KLASSENHEADER
 * Name: Claus Hierzer
 * Date: 13.09.2023
 * Version: 20.002
 * Description: The Programm implements the board and the logic for the game Tic-Tac-Toe.
 **/
public class TikTakToe {

    //--------------------------------------------------
    // Variablen und Konstanten Hier einfügen
    public static final int boardSize = 3;
    public static final String empty_cell = "   ";
    private static final String ROW = "---+---+---";
    private static final String COLUMN = "|";
    public String[][] board;
    //--------------------------------------------------

    // Constructor
    public TikTakToe() {
        // Add code here
        board = new String[boardSize][boardSize];
        initBoard();
    }

    /**
     * Initializes the board with the specified values.
     */
    void initBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = empty_cell;
            }
        }
    }

    /**
     * Prints the whole board with all separation characters
     */
    void printBoard() {
        System.out.println();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j]);
                if (j < boardSize - 1) {
                    System.out.print(COLUMN);
                }
            }
            System.out.println();
            if (i < boardSize - 1) {
                System.out.println(ROW);
            }
        }
        System.out.println();
    }

    /**
     * Sets a position in the board array to the given player string.
     *
     * @param r      row index
     * @param c      column index
     * @param player player string
     * @return true if and only if the position was set
     */
    boolean setPosition(int r, int c, String player) {
        if (board[r][c].equals(empty_cell)) {
            board[r][c] = player;
            return true;
        } else {
            System.out.println("Error: Position is already taken! Please choose a different field.");
            return false;
        }
    }

    /**
     * Checks if the game has been won by one of the users
     *
     * @return //'@return' tag description was missing (ein warning weniger)
     */
    boolean isGameOver() {
        for (int i = 0; i < boardSize; i++) {
            if (!board[i][0].equals(empty_cell) &&
                    board[i][0].equals(board[i][1]) &&
                    board[i][1].equals(board[i][2])) {
                return true; // Row win
            }
        }
        for (int j = 0; j < boardSize; j++) {
            if (!board[0][j].equals(empty_cell) &&
                    board[0][j].equals(board[1][j]) &&
                    board[1][j].equals(board[2][j])) {
                return true;  // Column win
            }
        }
        if (!board[0][0].equals(empty_cell) &&
                board[0][0].equals(board[1][1]) &&
                board[1][1].equals(board[2][2])) {
            return true;  // Diagonal left to right win
        }
        if (!board[0][2].equals(empty_cell))
            return board[0][2].equals(board[1][1]) &&
                    board[1][1].equals(board[2][0]);
        // Diagonal right to left win
        return false;
    }

    // Checks if the board is full.
    boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].equals(empty_cell)) {
                    return false;
                }
            }
        }
        return true;
    }
    // Habe ich auskommentiert, weil es dann ein warning weniger gibt
   /* boolean isGameOverBonus() {

       return true;
    }   **/
}