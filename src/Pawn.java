public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) || chessBoard.checkPos(toColumn)) return false;

        if (line == toLine && column == toColumn) return false;

        int direction = color.equals("White") ? 1 : -1;
        int startLine = color.equals("White") ? 1 : 6;

        int moveDistance = Math.abs(toLine - line);

        if (column == toColumn) {
            if (chessBoard.board[toLine][toColumn] != null) return false;
            if (line == startLine && moveDistance <= 2 && (toLine - line) * direction > 0) return true;
            return moveDistance == 1 && (toLine - line) * direction > 0;
        } else if (Math.abs(column - toColumn) == 1 && moveDistance == 1 && (toLine - line) * direction > 0 && chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
