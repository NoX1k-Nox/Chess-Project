public class Rook extends ChessPiece {

    public Rook(String color) {
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

        if (line != toLine && column != toColumn) return false;

        int rowOffset = Integer.compare(toLine, line);
        int colOffset = Integer.compare(toColumn, column);


        int row = line + rowOffset;
        int col = column + colOffset;
        while (row != toLine || col != toColumn) {

            if (chessBoard.board[row][col] != null) {
                return false;
            }
            row += rowOffset;
            col += colOffset;
        }

        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color);

    }

    @Override
    public String getSymbol() {
        return "R";
    }
}