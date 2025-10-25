package lab3.game;

/**
 * This enum represents a row on the TicTaeToe board.
 * TOP, MIDDLE, and BOTTON are the available options.
 *
 * @author Fernando Lascala
 * */
public enum Row {
    TOP, MIDDLE, BOTTOM;

    /**
     * Parses a string into a Row value.
     * This CODE covers all possibles typed information
     * */
    public static Row parse(String input) {
        return switch (input.toLowerCase()) {
            case "1", "t", "top" -> TOP;
            case "2", "m", "c", "middle", "center" -> MIDDLE;
            case "3", "b", "bottom" -> BOTTOM;
            default -> throw new IllegalArgumentException("Invalid row: " + input);
        };
    }

    /**
     * INT Public variable to adjust the index inside the TicTacToe game.
     * Adjusting the line number based on the customer choice.
     * */
    public int toIndex() {
        return switch (this) {
            case TOP -> 0;
            case MIDDLE -> 1;
            case BOTTOM -> 2;
        };
    }

    /**
     * STRING Public function to return the letter based on the line position on the board of the TicTacToe game.
     * Main use in the Boarding creation.
     * */
    public static String verticalWord(int line) {
        return switch (line) {
            case 0 -> "t";
            case 1 -> "m";
            case 2 -> "b";
            default -> " ";
        };
    }

}



