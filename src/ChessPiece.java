public abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) || chessBoard.checkPos(toColumn) || (line == toLine && column == toColumn)) {
            return false;
        }
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        if (targetPiece != null && targetPiece.getColor().equals(this.color)) {
            return false;
        }

        return canMoveSpecific(chessBoard, line, column, toLine, toColumn);
    }

    protected boolean canMoveSpecific(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return true;
    }

    public abstract String getSymbol();
}
