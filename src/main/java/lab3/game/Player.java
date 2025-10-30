package lab3.game; // Package that the java file is part of.

/**
 * Represents a player in the Tic-Tac-Toe game.
 * Each player is identified by a symbol ('X' or 'O') and can alternate turns.
 */
public enum Player {

    /**
     * Allowed characters for the Player enum ("X" and "0").
     */
    X('X'),
    O('O');

    /*
     * The character symbol used to represent the player on the board.
     * */
    private final char symbol;

    /**
     * Constructs a Player enum constant with the given symbol.
     *
     * @param symbol the character representing the player
     */
    Player(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol associated with the player.
     *
     * @return the character symbol ('X' or 'O')
     */
    public char symbol() {
        return symbol;
    }

    /**
     * Returns the next player in turn.
     * If the current player is X, returns O; if O, returns X.
     *
     * @return the opposing player
     */
    public Player next() {
        return this == X ? O : X;
    }
}