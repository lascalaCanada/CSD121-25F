package lab3.game;


/** This record represents the position on the TicTaeToe board.
 *
 *  @author Fernando Lascala
 * */
public record Position(Row row, Column column) {

    /**
     * INT rowIndex variable
     * This variable represents the exactly ROW in the TicTacToe board.
     * */
    public int rowIndex() {
        return row.toIndex();
    }

    /**
     * INT colIndex variable.
     * This variable represents the exactly COLUMN in the TicTacToe board.
     * */
    public int colIndex() {
        return column.toIndex();
    }
}
