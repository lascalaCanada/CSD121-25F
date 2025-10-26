package lab3.game; // Package that the java file is part of.

/**
 * Represents the current state of a Tic-Tac-Toe game.
 * This includes the board and the current player.
 * It encapsulates game progression logic such as turn switching and win/draw checks.
 *
 * @author Fernando Lascala
 */
public record GameState(Board board, PlayerName currentPlayer) {

    /**
     * Returns the next game state after attempting to place the current player's symbol
     * at the given position. If the move is invalid, the current state is returned unchanged.
     *
     * @param pos the position to place the symbol
     * @param nextPlayer the player who will play next
     * @return the updated GameState with the next player, or the same state if move is invalid
     */
    public GameState nextTurn(Position pos, PlayerName nextPlayer) {

        /*
        * Validating if the position is available
        * */
        if (board.place(currentPlayer, pos)) return this;

        /*
        * Returning the new game state with the next player
        * */
        return new GameState(board, nextPlayer);
    }

    /**
     * Checks if the current player has won the game.
     *
     * @return true if the current player has a winning configuration, false otherwise
     */
    public boolean isWin() {
        /*
        * Validating if the current player has a winning configuration
        * */
        return board.theWinner(currentPlayer);
    }

    /**
     * Checks if the game has ended in a draw.
     * A draw occurs when the board is full and no player has won.
     *
     * @param player1 the first player
     * @param player2 the second player
     * @return true if the game is a draw, false otherwise
     */
    public boolean isDraw(PlayerName player1, PlayerName player2) {
        /*
        * Validating if the board is full and no player has won
        * */
        return board.isFull() && !board.theWinner(player1) && !board.theWinner(player2);
    }
}