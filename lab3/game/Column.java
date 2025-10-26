package lab3.game; // Package that the java file is part of.

/** This enum represents a row on the TicTaeToe board.
 *  "LEFT, MIDDLE, and RIGHT" are the available options"
 *
 *  @author Fernando Lascala *
 * */
public enum Column {
    LEFT, MIDDLE, RIGHT;

    /**
     * Parses a string into a Column value.
     *
     * @param input receives the end-user position in the board.
     * */
    public static Column parse(String input) {
        return switch (input.toLowerCase()) {
            case "1", "l", "left" -> LEFT;
            case "2", "m", "c", "middle", "center" -> MIDDLE;
            case "3", "r", "right" -> RIGHT;
            default -> throw new IllegalArgumentException("Invalid column: " + input);
        };
    }


    /** INT Public variable to adjust the index inside the TicTacToe game.
     *  Adjusting the line number based on the customer choice.
     * */
    public int toIndex() {
        return switch (this) {
            case LEFT -> 0;
            case MIDDLE -> 1;
            case RIGHT -> 2;
        };
    }
}
