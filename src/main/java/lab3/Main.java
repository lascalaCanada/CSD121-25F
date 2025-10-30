package lab3; // Package that the java file is part of.
import lab3.game.*;
import lab3.ui.TicTacToeConsole;


/**
 * Entry point for the Tic-Tac-Toe game.
 * This class coordinates the interaction between the user interface and the game logic.
 * It maintains the game loop and handles turn progression, win/draw detection, and board updates.
 *
 * @author Fernando Lascala
 * */
public class Main {

    /**
     * Main method that initializes the game and runs the game loop.
     *
     * @param args command-line arguments (not used)
     * */
    public static void main(String[] args) {

        /*
         * Creating the Console object to handle user interaction
         * */
        TicTacToeConsole ui = new TicTacToeConsole();

        /*
         * Prompting for Player 1 information (name and symbol)
         * The numm parameter was created to validate if the second player has the same name for the first one
         * */
        PlayerName player1 = ui.promptPlayer(1, null);

        /*
         * Prompting for Player 2 information (name and symbol)
         * This process will validate if the name of the second player is equal than the first one
         * */
        PlayerName player2 = ui.promptPlayer(2, player1.getName());

        /*
         * Creating a new empty game board
         * */
        Board board = new Board();

        /*
         * Setting the starting player to Player 1
         * */
        PlayerName current = player1;

        /*
         * Begin the main game loop
         * */
        while (true) {

            /*
             * Displaying the current state of the board
             * */
            ui.showBoard(board);

            /*
             * Checking if the game has ended in a draw
             * */
            if (board.isFull()) {
                ui.showMessage("It's a draw!");
                break;
            }

            /*
             * Prompting the current player for their move
             * */
            Position move = ui.promptMove(current);

            /*
             * Attempting to place the player's symbol at the chosen position
             * */
            boolean validMove = board.place(current, move);

            /*
             * If the move is invalid (position already taken), ask again
             * */
            if (!validMove) {
                ui.showMessage("Position already taken. Try again.");
                continue;
            }

            /*
             * Checking if the current player has won the game
             * */
            if (board.theWinner(current)) {
                ui.showBoard(board);
                ui.showMessage("Player " + current.getName() + " (" + current.getSymbol() + ") wins!");
                break;
            }

            /*
             * Switching to the next player for the upcoming turn
             * */
            current = (current == player1) ? player2 : player1;
        }
    }
}
