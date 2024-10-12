public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "P";
    }


    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.checkPos(toLine) || !board.checkPos(toColumn)) return false;

        int direction = this.color.equals("White") ? 1 : -1;

        // Check for normal forward movement
        if (column == toColumn) {
            // Pawns can move one space forward, or two spaces if they haven't moved yet
            if (toLine - line == direction && board.board[toLine][toColumn] == null) return true;
            if (line == (this.color.equals("White") ? 1 : 6) && toLine - line == 2 * direction && board.board[line + direction][column] == null && board.board[toLine][toColumn] == null) return true;
        }

        // Check for diagonal capture
        if (Math.abs(column - toColumn) == 1 && toLine - line == direction) {
            if (board.board[toLine][toColumn] != null && !board.board[toLine][toColumn].getColor().equals(this.getColor())) {
                return true;
            }
        }

        return false;
    }



    private boolean isPositionValid(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}
