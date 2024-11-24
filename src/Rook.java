public class Rook extends ChessPiece {

    public Rook(String color) {
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

        if (line != toLine && column != toColumn) return false;

        if (line == toLine) {
            int step = (toColumn > column) ? 1 : -1;
            for (int i = column + step; i != toColumn; i += step) {
                if (chessBoard.board[line][i] != null) {
                    return false;
                }
            }
        } else {
            int step = (toLine > line) ? 1 : -1;
            for (int i = line + step; i != toLine; i += step) {
                if (chessBoard.board[i][column] != null) {
                    return false;
                }
            }
        }

        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
