package lab3.game; // Package that the java file is part of.
import java.util.Arrays;
import static lab3.game.Row.verticalWord;


/**
 * This class represents the Tic Tac Toe game board and its operations.
 * It manages the grid state, symbol placement, win detection, and board formatting.
 *
 * @author Fernando
 */
public class Board {

    /*
    * Local variable: 3x3 grid to hold player symbols
    * */
    private final char[][] grid = new char[3][3];

    /**
     * Constructs a new empty Board.
     * Initializes all grid cells with a blank space character.
     */
    public Board() {
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
    }

    /**
     * Places the player's symbol at the specified position on the board.
     * If the position is already occupied, the move is rejected.
     * If the move results in a win, the game ends.
     *
     * @param player the player making the move
     * @param position the position to place the symbol
     *
     * @return true if the symbol was placed successfully, false if the position is already taken
     */
    public boolean place(PlayerName player, Position position) {

        /*
         * Get row and column indexes from the position object
         * */
        int gridRow = position.rowIndex();
        int gridCol = position.colIndex();

        /*
         * Check if the position is already occupied
         * */
        if (grid[gridRow][gridCol] != ' ') {
            return false;
        }

        /*
         * Place the symbol into the grid
         * */
        grid[gridRow][gridCol] = player.getSymbol();

        /*
         * Return true to indicate successful placement
         * */
        return true;
    }


    /**
     * Checks if the board is completely filled.
     * Used to detect draw conditions.
     *
     * @return true if all cells are filled, false otherwise
     */
    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {

                /*
                * If any cell is empty, the board is not full
                * */
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the given player has won the game.
     * Evaluates rows, columns, and diagonals for a winning pattern.
     *
     * @param player the player to check for a win
     *
     * @return true if the player has won, false otherwise
     */
    public boolean theWinner(PlayerName player) {
        /*
        * Get the symbol to check for winning condition
        * */
        char winner = player.getSymbol();

        /*
        * Check all rows and columns for a winning line
        * */
        for (int count = 0; count < 3; count++) {
            if (grid[count][0] == winner && grid[count][1] == winner && grid[count][2] == winner) return true;
            if (grid[0][count] == winner && grid[1][count] == winner && grid[2][count] == winner) return true;
        }

        /*
        * Check both diagonals for a winning line
        * */
        return (grid[0][0] == winner && grid[1][1] == winner && grid[2][2] == winner) ||
                (grid[0][2] == winner && grid[1][1] == winner && grid[2][0] == winner);
    }

    /**
     * Formats the current board state into a visual string representation. (lascala > Not Bad)
     * Includes row and column labels for easier reference.
     * Used for displaying the board in the console.
     *
     * @return a formatted string representing the board with coordinates
     */
    public String boardFormatter() {
        StringBuilder stringBuilder = new StringBuilder("\n");

        /*
        * Add column headers
        * */
        stringBuilder.append("    1/l 2/m 3/r\n");

        for (int countRow = 0; countRow < 3; countRow++) {

            /*
            * Add row label
            * */
            stringBuilder.append(" ").append(countRow + 1).append("/").append(verticalWord(countRow)).append("  ");

            for (int countCol = 0; countCol < 3; countCol++) {

                /*
                * Add cell content
                * */
                stringBuilder.append(" ").append(grid[countRow][countCol]);

                /*
                * Add column separator unless it's the last column
                * */
                if (countCol < 2) stringBuilder.append(" |");
            }

            stringBuilder.append("\n");

            /*
            * Add row separator unless it's the last row
            * */
            if (countRow < 2) stringBuilder.append("      ---+---+---\n");
        }

        return stringBuilder.toString();
    }


    /**
     * Overrides the default toString method to return the formatted board.
     *
     * @return a string representation of the board
     */
    public String toString() {
        return boardFormatter();
    }
}
