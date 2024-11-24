public class Horse extends ChessPiece {

    public Horse(String color) {
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

        int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        for (int[] move : moves) {
            int newLine = line + move[0];
            int newColumn = column + move[1];

            if (newLine == toLine && newColumn == toColumn &&
                    (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
