public class King extends ChessPiece {

    public King(String color) {
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

        return Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1 && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color));

    }



    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(this.color)) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
