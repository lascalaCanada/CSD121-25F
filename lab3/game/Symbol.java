package lab3.game;  // Package that the java file is part of.

/**
 * This enum represents the allowed symbols in the Tic-Tac-Toe game.
 * Only 'X' and 'O' are allowed.
 * Each symbol is associated with a character value used on the board.
 * This enum is used to assign and retrieve player symbols based on player number.
 *
 * @author Fernando Lascala
 */
public enum Symbol {

    /*
     * Symbols X and O
     * This values are immutable
     * */
    X('X'),
    O('O');

    /*
     * Internal field to store the character representation
     * */
    private final char value;

    /**
     * Constructor to assign the character value.
     * This constructor is used internally by the enum constants.
     *
     * @param value the character representing the symbol ('X' or 'O')
     */
    Symbol(char value) {
        this.value = value;
    }

    /**
     * Returns the character value of the symbol.
     * Used to display the symbol on the board.
     *
     * @return the character value ('X' or 'O')
     */
    public char getValue() {
        return value;
    }

    /**
     * Returns the symbol assigned to a player number.
     * Player 1 is assigned 'X', Player 2 is assigned 'O'.
     *
     * @param playerNumber the number of the player (1 or 2)
     * @return the corresponding Symbol enum (X or O)
     */
    public static Symbol fromPlayerNumber(int playerNumber) {
        if (playerNumber == 1)
            return X;
        else
            return O;
    }
}