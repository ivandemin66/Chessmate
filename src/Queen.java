public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.checkPos(toLine) || !board.checkPos(toColumn)) return false;

        if (line == toLine || column == toColumn) {
            // Rook-like movement
            return new Rook(this.color).canMoveToPosition(board, line, column, toLine, toColumn);
        } else if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            // Bishop-like movement
            return new Bishop(this.color).canMoveToPosition(board, line, column, toLine, toColumn);
        }

        return false;
    }


    private boolean isPositionValid(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}
