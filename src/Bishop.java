public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    protected boolean canMoveSpecific(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        if (line == toLine && column == toColumn) return false;

        if (Math.abs(line - toLine) != Math.abs(column - toColumn)) return false;

        int rowOffset = (toLine > line) ? 1 : -1;
        int colOffset = (toColumn > column) ? 1 : -1;

        for (int i = 1; i < Math.abs(line - toLine); i++) {
            if (chessBoard.board[line + i * rowOffset][column + i * colOffset] != null) {
                return false;
            }
        }

        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}