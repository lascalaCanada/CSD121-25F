package lab3.game; // Package that the java file is part of.

/**
 * This class represents a player in the Tic-Tac-Toe game.
 * It stores the player's name and chosen symbol ('X' or 'O').
 * Used to personalize gameplay and track player identity.
 *
 * @author Fernando Lascala
 */
public class PlayerName {

    /*
    * The player's name
    * The player's symbol (e.g., 'X' or 'O')
    * */
    private final String name;
    private final char symbol;

    /**
     * Constructs a PlayerName object with a name and symbol.
     * This constructor is used during game setup to assign identity to each player.
     *
     * @param name the name of the player
     * @param symbol the symbol assigned to the player ('X' or 'O')
     */
    public PlayerName(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Returns the player's name.
     * Used for personalized prompts and win messages.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's symbol.
     * Used to mark moves on the board and identify ownership.
     *
     * @return the symbol assigned to the player ('X' or 'O')
     */
    public char getSymbol() {
        return symbol;
    }
}
