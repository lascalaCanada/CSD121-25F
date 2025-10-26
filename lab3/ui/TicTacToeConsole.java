package lab3.ui; // Package that the java file is part of.
import lab3.game.*;
import java.io.*;

/** This class handles all user interaction via the console.
 *  It uses the new IO API introduced in JDK 25 for input/output operations.
 *
 *  @author Fernando
 */
public class TicTacToeConsole {

    /*
    * Constructs the console interface using JDK 25 IO API
    * */
    public TicTacToeConsole() {

    }

    /** Prompts the user to enter a player's name.
     * Player 1 is automatically assigned symbol 'X'.
     * Player 2 is automatically assigned symbol 'O'.
     * Empty names are not allowed. Player 2 must have a different name than Player 1.
     *
     * @param playerNumber the player number (1 or 2)
     * @param existingName the name of Player 1 (null if playerNumber == 1)
     * @return a PlayerName object with name and assigned symbol
     */
    public PlayerName promptPlayer(int playerNumber, String existingName) {

        String name;

        /*
        * Loop until a valid (non-empty and unique) name is entered
        * */
        while (true) {
            IO.print("\nEnter name for Player " + playerNumber + ": ");
            name = IO.readln().trim();

            /*
            * Validate that the name is not empty
            * */
            if (name.isEmpty()) {
                IO.println("Name can not be empty. Please enter a valid name.");
                continue;
            }

            /*
            * Validate that Player 2's name is different from Player 1
            * */
            if (playerNumber == 2 && name.equalsIgnoreCase(existingName)) {
                IO.println("Player 2 must not have the same name as Player 1. Please choose a different name.");
                continue;
            }

            break;
        }

        /*
        * Assign symbol based on player number
        * */
        char symbol = (playerNumber == 1) ? 'X' : 'O';

        /*
        * Inform the player of their assigned symbol
        * */
        IO.println(name + " your symbol is " + symbol);

        /*
        * Return a new PlayerName object with name and symbol
        * */
        return new PlayerName(name, symbol);
    }


    /**
     * Prompts the current player to enter their move on the board.
     * Accepts input in either spaced format (e.g., "2 2", "m r") or compact format (e.g., "22", "mr").
     * Validates the input and converts it into a Position object.
     * Keeps prompting until a valid move is entered.
     *
     * @param player the player whose turn it is
     * @return a valid Position object representing the player's move
     */
    public Position promptMove(PlayerName player) {

        /*
        * Loop until a valid move is entered
        * */
        while (true) {

            /*
            * Display prompt message with player's name and symbol
            * */
            IO.print(player.getName() + " (" + player.getSymbol() + "), enter your move (e.g., '2 2', '22', 'm r', or 'mr') > ('x' to exit!): ");

            /*
            * Read input from the user and normalize it
            * */
            String input = IO.readln().trim().toLowerCase();
            String[] parts;

            /*
            * If x or X is typed, the program is break
             */
            if (input.equalsIgnoreCase("x")) {
                IO.println("Game aborted by Player " + player.getName() + "!");
                System.exit(0);
            }

            /*
            * If input is compact (2 characters, no space), split manually
            * */
            if (input.length() == 2 && !input.contains(" ")) {
                parts = new String[] {
                        String.valueOf(input.charAt(0)),  // First character (row or letter)
                        String.valueOf(input.charAt(1))   // Second character (column or letter)
                };
            } else {
                /*
                * Otherwise, split input by spaces
                * In this part, using REGEX is the best option to split the user input
                * */
                parts = input.split("\\s+");
            }

            /*
            * Validate that we have exactly two parts
            * */
            if (parts.length != 2) {
                IO.println("Invalid format. Please enter two coordinates (e.g., '2 2' or 'mr').");
                continue;
            }

            try {
                /*
                * Try to parse the row and column using helper classes
                * */
                Row row = Row.parse(parts[0]);          // Convert first part to Row
                Column col = Column.parse(parts[1]);    // Convert second part to Column

                /*
                * If parsing succeeds, return the new Position
                * */
                return new Position(row, col);

            } catch (IllegalArgumentException e) {

                /*
                * If parsing fails, show error message and ask again
                * The printed message is generated by system error
                * */
                IO.println("Invalid input: " + e.getMessage());
            }
        }
    }


    /** Displays the current state of the board.
     *
     *  @param board the board to display
     */
    public void showBoard(Board board) {
        IO.println(board.toString());
    }

    /** Displays a message to the console.
     *
     *  @param message the message to display
     */
    public void showMessage(String message) {
        IO.println(message);
    }

}
