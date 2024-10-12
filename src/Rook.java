public class Rook extends ChessPiece {


    public Rook(String color) {
        super(color);
    }


    @Override
    public String getSymbol() {
        return "R";
    }


    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        // Check if the target position is within bounds
        if (!board.checkPos(toLine) || !board.checkPos(toColumn)) return false;

        // Rook moves in straight lines (either row or column must remain constant)
        if (line != toLine && column != toColumn) return false;

        // Check if there's a piece blocking the path
        if (line == toLine) {
            int start = Math.min(column, toColumn);
            int end = Math.max(column, toColumn);
            for (int i = start + 1; i < end; i++) {
                if (board.board[line][i] != null) return false;
            }
        } else {
            int start = Math.min(line, toLine);
            int end = Math.max(line, toLine);
            for (int i = start + 1; i < end; i++) {
                if (board.board[i][column] != null) return false;
            }
        }

        // Check if the destination contains a friendly piece
        if (board.board[toLine][toColumn] != null && board.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }



    private boolean isPositionValid(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}
