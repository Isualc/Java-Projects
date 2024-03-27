import java.util.Scanner;

/**
 * KLASSENHEADER
 * Name: Claus Hierzer
 * Date: 13.09.2023
 * Version: 20.002
 * Description: The Programm implements the board and the logic for the game Tic-Tac-Toe.
 */
public class Main {
    public static final String player_X_ = " X ";
    public static final String player_O_ = " O ";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TikTakToe game = new TikTakToe();
        String current_player = player_X_;
        System.out.println("Welcome to Tik-Tak-Codersbay!");

        while (!game.isGameOver()) {
            game.printBoard();
            int row = getRow();
            int col = getColumn();
            boolean succsessfulMove = game.setPosition(row, col, current_player);

            if (succsessfulMove) {
                if (game.isGameOver()) {
                    game.printBoard();
                    System.out.println(current_player + "win!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("Draw");
                    break;
                }
                current_player = getNextPlayer(current_player);
            }
        }
    }

    /**
     * @return a valid row if the input was entered correctly
     */
    private static int getRow() {
        return readIntegerInput("Row: ",
                "Invalid Input! Please enter a valid integer for the row you want to select!", scanner);
    }

    /**
     * @return a valid column if the input was entered correctly
     */
    private static int getColumn() {
        return readIntegerInput("Column: ",
                "Invalid Input! Please enter a valid integer for the row you want to select!", scanner);
    }

    /**
     * Asks for an input and checks if it can be converted into an integer.
     * If the input can't be converted, the input prompt is printed again.
     *
     * @param prompt is the prompt to the user
     * @return the integer value of the input if possible
     */
    private static int readIntegerInput(String prompt, String error_message, Scanner input) {
        int str_to_int = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            String input_string = input.nextLine();

            try {
                str_to_int = Integer.parseInt(input_string);
                if (str_to_int >= 0 && str_to_int <= 2) {
                    validInput = true;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println(error_message);
            }
        }
        return str_to_int;
    }

    /**
     * Switches the player.
     *
     * @param current_player is the player that had his/her turn
     * @return the next Player
     */
    private static String getNextPlayer(String current_player) {
        if (current_player.equals(player_X_)) {
            return player_O_;
        } else {
            return player_X_;
        }
    }
}