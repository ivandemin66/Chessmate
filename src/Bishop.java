public class Bishop extends ChessPiece {


    public Bishop(String color) {
        super(color);
    }


    @Override
    public String getSymbol() {
        return "B";
    }


    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {

        if (!board.checkPos(toLine) || !board.checkPos(toColumn)) return false;

        if (Math.abs(line - toLine) != Math.abs(column - toColumn)) return false;

        int rowStep = (toLine - line) / Math.abs(toLine - line);
        int colStep = (toColumn - column) / Math.abs(toColumn - column);
        for (int i = 1; i < Math.abs(toLine - line); i++) {
            if (board.board[line + i * rowStep][column + i * colStep] != null) return false;
        }


        if (board.board[toLine][toColumn] != null && board.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }



    private boolean isPositionValid(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}

