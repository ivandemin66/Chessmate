public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!isPositionValid(line, column) || !isPositionValid(toLine, toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        int deltaX = Math.abs(line - toLine);
        int deltaY = Math.abs(column - toColumn);

        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }

    private boolean isPositionValid(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}
